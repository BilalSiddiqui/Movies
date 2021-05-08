package com.swvl.movies.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.swvl.movies.R

class MovieDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_movie)
        setSupportActionBar(findViewById(R.id.toolbar))
    }

}