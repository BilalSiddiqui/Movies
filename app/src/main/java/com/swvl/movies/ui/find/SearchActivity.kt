package com.swvl.movies.ui.find

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.swvl.movies.R

class SearchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_movie)
        setSupportActionBar(findViewById(R.id.toolbar))

    }


}