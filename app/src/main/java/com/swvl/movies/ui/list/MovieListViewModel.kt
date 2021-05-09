package com.swvl.movies.ui.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.swvl.movies.R
import com.swvl.movies.data.repo.MovieDataSource
import com.swvl.movies.data.repo.MovieRepository
import com.swvl.movies.utils.MovieApplication
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MovieListViewModel(private val repository: MovieDataSource) : ViewModel() {
    val adapter = MovieAdapter()
    var errorMessage:String?=null

    fun fetchMovies() {
        viewModelScope.launch(Dispatchers.IO) {
            val moviesListResponse = repository.getMoviesList(MovieApplication.instance)
            if(moviesListResponse.movies.isNullOrEmpty()){
                errorMessage=MovieApplication.instance.getString(R.string.no_record)
            }else {
                errorMessage= null
                withContext(Dispatchers.Main) {
                    adapter.submitList(moviesListResponse.movies)
                }
            }
        }
    }

}