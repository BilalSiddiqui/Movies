package com.swvl.movies.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.swvl.movies.data.repo.MovieDataSource
import com.swvl.movies.ui.find.MovieSearchViewModel
import com.swvl.movies.ui.list.MovieListViewModel


class MoviesViewModelFactory(private val moviesRepository: MovieDataSource) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>) =
        with(modelClass) {
            when {
                isAssignableFrom(MovieListViewModel::class.java) ->
                    MovieListViewModel(moviesRepository)

                isAssignableFrom(MovieSearchViewModel::class.java) ->
                    MovieSearchViewModel(moviesRepository)

                else ->
                    throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
            }
        } as T

}
