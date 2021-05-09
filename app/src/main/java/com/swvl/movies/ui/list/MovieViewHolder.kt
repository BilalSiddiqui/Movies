package com.swvl.movies.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.swvl.movies.data.model.Movie
import com.swvl.movies.databinding.ItemMovieBinding

class MovieViewHolder(private val binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root)  {


    fun bind(movie: Movie?) {
        binding.movie=movie
        binding.executePendingBindings();
    }

    companion object {
        fun create(parent: ViewGroup): MovieViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val itemBinding: ItemMovieBinding = ItemMovieBinding.inflate(layoutInflater, parent, false)
            return MovieViewHolder(itemBinding)
        }
    }
}