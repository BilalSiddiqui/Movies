package com.swvl.movies.ui.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.swvl.movies.R
import com.swvl.movies.data.repo.MovieDataSource
import com.swvl.movies.utils.MovieApplication
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MovieListViewModel(private val repository: MovieDataSource) : ViewModel() {
    val adapter = MovieAdapter()
    var errorMessageLiveData= MutableLiveData<String>()

    fun fetchMovies() {
        viewModelScope.launch(Dispatchers.IO) {
            val moviesListResponse = repository.getMoviesList(MovieApplication.instance)
            if(moviesListResponse.movies.isNullOrEmpty()){
                errorMessageLiveData.postValue(MovieApplication.instance.getString(R.string.no_record))
            }else {
                errorMessageLiveData.postValue(null)
                withContext(Dispatchers.Main) {
                    adapter.submitList(moviesListResponse.movies)
                }
            }
        }
    }

}