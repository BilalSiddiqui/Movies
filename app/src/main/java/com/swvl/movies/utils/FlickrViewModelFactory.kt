package com.swvl.movies.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.swvl.movies.data.repo.FlickrDataSource
import com.swvl.movies.ui.detail.MovieDetailViewModel


class FlickrViewModelFactory(private val flickrRepository: FlickrDataSource) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>) =
        with(modelClass) {
            when {

                isAssignableFrom(MovieDetailViewModel::class.java) ->
                    MovieDetailViewModel(flickrRepository)

                else ->
                    throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
            }
        } as T

}
