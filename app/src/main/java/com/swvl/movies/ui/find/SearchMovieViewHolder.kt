package com.swvl.movies.ui.find

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.swvl.movies.databinding.ItemSearchMovieBinding
import com.swvl.movies.ui.detail.MovieDetailActivity

class SearchMovieViewHolder(private val binding: ItemSearchMovieBinding) :
    RecyclerView.ViewHolder(binding.root) {
   private val clickListener=object :MovieItemClickListener{
       override fun onMovieItemClicked(moviePresentationModel: RecyclerItem.MoviePresentationModel, view: View) {
           val intent = Intent(view.context, MovieDetailActivity::class.java)
           intent.putExtra(MovieDetailActivity.ARG_MOVIE,moviePresentationModel.movie)
           view.context.startActivity(intent)
       }

   }


    fun bind(moviePresentationModel: RecyclerItem.MoviePresentationModel?) {
        binding.movie = moviePresentationModel
        binding.listener = clickListener
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