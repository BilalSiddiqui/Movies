package com.swvl.movies.ui.find

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.swvl.movies.databinding.ItemSearchMovieBinding

class SearchMovieViewHolder(private val binding: ItemSearchMovieBinding) :
    RecyclerView.ViewHolder(binding.root) {


    fun bind(movie: RecyclerItem.Movie?) {
        binding.movie = movie
        binding.executePendingBindings();
    }

    companion object {
        fun create(parent: ViewGroup): SearchMovieViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val itemBinding: ItemSearchMovieBinding =
                ItemSearchMovieBinding.inflate(layoutInflater, parent, false)
            return SearchMovieViewHolder(itemBinding)
        }
    }
}