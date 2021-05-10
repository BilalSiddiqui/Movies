package com.swvl.movies.ui.list

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.swvl.movies.R
import com.swvl.movies.databinding.ActivityListMovieBinding
import com.swvl.movies.ui.find.SearchActivity
import com.swvl.movies.utils.Injection

class MovieListActivity : AppCompatActivity() {
    private var movieListViewModel: MovieListViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityListMovieBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_list_movie)

        // Specify the current activity as the lifecycle owner.
        binding.lifecycleOwner = this
        movieListViewModel = ViewModelProvider(
            this,
            Injection.provideMoviesViewModelFactory()
        ).get(MovieListViewModel::class.java)
        binding.movieListViewModel = movieListViewModel
        movieListViewModel?.fetchMovies()
        setSupportActionBar(findViewById(R.id.toolbar))


    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> {
                startActivity(Intent(this, SearchActivity::class.java))
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}