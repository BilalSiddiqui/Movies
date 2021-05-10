package com.swvl.movies.ui.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.swvl.movies.R
import com.swvl.movies.data.model.APIResponse
import com.swvl.movies.data.model.FlickrSearchResponse
import com.swvl.movies.data.model.Movie
import com.swvl.movies.data.model.Photo
import com.swvl.movies.data.repo.FlickrDataSource
import com.swvl.movies.utils.MovieApplication
import kotlinx.coroutines.launch

class MovieDetailViewModel(private val repository: FlickrDataSource) : ViewModel() {
    lateinit var movie: Movie
    val adapter = GalleryAdapter()
    val progress = MutableLiveData<Boolean>()
    val error = MutableLiveData<String>()


    fun getCommaSeperatedListOfCast(): String {
        val listBuilder = StringBuilder()
        for (cast in movie.cast) {
            if (listBuilder.isNotEmpty()) {
                listBuilder.append(",")
            }
            listBuilder.append(cast)
        }
        return listBuilder.toString()
    }

    fun getCommaSeperatedListOfGenere(): String {
        val listBuilder = StringBuilder()
        for (genere in movie.genres) {
            if (listBuilder.isNotEmpty()) {
                listBuilder.append(",")
            }
            listBuilder.append(genere)
        }
        return listBuilder.toString()
    }

    fun getPhotos(query: String) {

        viewModelScope.launch {
            progress.postValue(true)
            val photoListResponse = repository.getPhotosList(query)
            when (photoListResponse) {
                is APIResponse.Success<FlickrSearchResponse> -> {
                    progress.postValue(false)
                    val listOfURLs = getListOfImageUrls(photoListResponse.value.photos?.photo!!)
                    if(listOfURLs.isEmpty()){
                        error.postValue(MovieApplication.instance.resources.getString(R.string.no_image_found))
                    }else{
                        error.postValue(null)
                    }
                    adapter.submitList(listOfURLs)
                }
                is APIResponse.Failure -> {
                    error.postValue(MovieApplication.instance.resources.getString(R.string.no_image_found))
                }

            }


        }
    }

    fun getListOfImageUrls(photos: List<Photo>): List<String> {
        val listOfURLs = ArrayList<String>()
        for (photo in photos) {
            listOfURLs.add(getUrlFromPhoto(photo))
        }
        return listOfURLs
    }

    fun getUrlFromPhoto(photo: Photo): String {
        return "https://farm${photo.farm}.static.flickr.com/${photo.server}/${photo.id}_${photo.secret}.jpg"
    }

}