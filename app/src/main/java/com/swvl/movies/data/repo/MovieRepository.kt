package com.swvl.movies.data.repo

import android.content.Context
import com.google.gson.Gson
import com.swvl.movies.R
import com.swvl.movies.data.model.MovieListResponse


class MovieRepository:MovieDataSource {

    override fun getMoviesList(context: Context): MovieListResponse {
        val text = context.resources.openRawResource(R.raw.movies)
            .bufferedReader().use { it.readText() }
        return Gson().fromJson(text, MovieListResponse::class.java)
    }
}
