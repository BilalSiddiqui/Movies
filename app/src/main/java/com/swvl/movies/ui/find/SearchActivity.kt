package com.swvl.movies.ui.find

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.swvl.movies.R
import com.swvl.movies.databinding.ActivityListMovieBinding
import com.swvl.movies.databinding.ActivitySearchMovieBinding
import com.swvl.movies.ui.list.MovieListViewModel
import com.swvl.movies.utils.Injection

class SearchActivity : AppCompatActivity() {
    private var movieSearchViewModel: MovieSearchViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_movie)
        val binding: ActivitySearchMovieBinding= DataBindingUtil.setContentView(this, R.layout.activity_search_movie)
        binding.lifecycleOwner = this
        movieSearchViewModel = ViewModelProvider(this, Injection.provideViewModelFactory()).get(MovieSearchViewModel::class.java)
        binding.searchViewModel = movieSearchViewModel
        binding.search.setOnQueryTextListener(movieSearchViewModel?.queryTextListener)
        setSupportActionBar(findViewById(R.id.toolbar))
    }


}