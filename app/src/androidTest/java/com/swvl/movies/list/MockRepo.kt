package com.swvl.movies.list

import android.content.Context
import com.swvl.movies.data.model.Movie
import com.swvl.movies.data.model.MovieListResponse
import com.swvl.movies.data.repo.MovieDataSource

class MockRepo:MovieDataSource {

    var listOfMovies= emptyList<Movie>();

    override fun getMoviesList(context: Context): MovieListResponse {
       return MovieListResponse(listOfMovies)
    }
}