package com.swvl.movies.ui.find

sealed class RecyclerItem {
    abstract fun getTitle(): String

    data class Movie(val name: String,val rating:Int) : RecyclerItem() {
        override fun getTitle(): String {
            return name
        }
    }

    data class Section(val sectionName: String) : RecyclerItem() {
        override fun getTitle(): String {
            return sectionName
        }
    }
}