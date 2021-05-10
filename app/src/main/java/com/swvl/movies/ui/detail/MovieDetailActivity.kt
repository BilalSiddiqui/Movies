package com.swvl.movies.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.swvl.movies.R
import com.swvl.movies.data.model.Movie
import com.swvl.movies.databinding.ActivityDetailMovieBinding
import com.swvl.movies.utils.Injection

class MovieDetailActivity : AppCompatActivity() {
    private lateinit var movieDetailViewModel: MovieDetailViewModel

    companion object {
        const val ARG_MOVIE = "arg_movie"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_movie)

        val movie = intent.getSerializableExtra(ARG_MOVIE) as Movie
        val binding: ActivityDetailMovieBinding = DataBindingUtil.setContentView(this, R.layout.activity_detail_movie)
        binding.lifecycleOwner = this
        movieDetailViewModel = ViewModelProvider(this, Injection.provideFlickrViewModelFactory()).get(MovieDetailViewModel::class.java)
        movieDetailViewModel.movie=movie
        movieDetailViewModel.getPhotos(movie.title)
        binding.detailViewModel = movieDetailViewModel
        setSupportActionBar(findViewById(R.id.toolbar))
    }

}