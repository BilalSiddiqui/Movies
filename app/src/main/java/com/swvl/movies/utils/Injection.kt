package com.swvl.movies.utils

import androidx.lifecycle.ViewModelProvider
import com.swvl.movies.data.api.FlickrService
import com.swvl.movies.data.repo.FlickrRepository
import com.swvl.movies.data.repo.MovieRepository


object Injection {

    fun provideMovieRepository(): MovieRepository {
        return MovieRepository()
    }

    fun provideFlickrRepository(): FlickrRepository {
        return FlickrRepository(FlickrService.create())
    }

    fun provideMoviesViewModelFactory(): ViewModelProvider.Factory {
        return MoviesViewModelFactory(provideMovieRepository())
    }

    fun provideFlickrViewModelFactory(): ViewModelProvider.Factory {
        return FlickrViewModelFactory(provideFlickrRepository())
    }
}
