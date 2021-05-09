package com.swvl.movies.data.repo

import android.content.Context
import com.swvl.movies.data.model.MovieListResponse

interface MovieDataSource {
    fun getMoviesList(context: Context): MovieListResponse
}