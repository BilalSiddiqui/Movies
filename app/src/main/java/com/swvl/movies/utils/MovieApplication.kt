package com.swvl.movies.utils

import android.app.Application

class MovieApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        lateinit var instance: MovieApplication
            private set
    }
}