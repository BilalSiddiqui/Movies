package com.swvl.movies.ui.find

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.swvl.movies.ui.list.ErrorViewHolder
import com.swvl.movies.ui.list.MovieViewHolder

class MovieSearchAdapter : ListAdapter<RecyclerItem, RecyclerView.ViewHolder>(MOVIE_COMPARATOR) {
    private val TYPE_SECTION = 0
    private val TYPE_MOVIE = 1

    override fun getItemViewType(position: Int) = when(getItem(position)) {
        is RecyclerItem.Movie -> TYPE_MOVIE
        is RecyclerItem.Section -> TYPE_SECTION
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_SECTION -> SeachSectionViewHolder.create(parent)
            TYPE_MOVIE -> SearchMovieViewHolder.create(parent)
            else -> ErrorViewHolder.create(parent)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(val item=getItem(position)) {
            is RecyclerItem.Movie -> (holder as SearchMovieViewHolder).bind(item)
            is RecyclerItem.Section -> (holder as SeachSectionViewHolder).bind(item)
        }
    }



    companion object {
        private val MOVIE_COMPARATOR = object : DiffUtil.ItemCallback<RecyclerItem>() {
            override fun areItemsTheSame(oldItem: RecyclerItem, newItem: RecyclerItem): Boolean =
                oldItem.getTitle() == newItem.getTitle()

            override fun areContentsTheSame(oldItem: RecyclerItem, newItem: RecyclerItem): Boolean =
                oldItem == newItem
        }
    }
}
