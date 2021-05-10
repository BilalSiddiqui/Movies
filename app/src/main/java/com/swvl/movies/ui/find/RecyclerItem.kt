package com.swvl.movies.ui.find

import com.swvl.movies.data.model.Movie

sealed class RecyclerItem {
    abstract fun getTitle(): String

    data class MoviePresentationModel(val movie: Movie) : RecyclerItem() {
        override fun getTitle(): String {
            return movie.title
        }
    }

    data class Section(val sectionName: String) : RecyclerItem() {
        override fun getTitle(): String {
            return sectionName
        }
    }
}