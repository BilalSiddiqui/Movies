package com.swvl.movies.ui.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.swvl.movies.data.model.Movie
import com.swvl.movies.databinding.ItemGalleryBinding
import com.swvl.movies.databinding.ItemMovieBinding

class GalleryViewHolder(private val binding: ItemGalleryBinding) : RecyclerView.ViewHolder(binding.root)  {


    fun bind(photo: String?) {
        binding.imageUrl=photo
        binding.executePendingBindings();
    }




    companion object {
        fun create(parent: ViewGroup): GalleryViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val itemBinding: ItemGalleryBinding = ItemGalleryBinding.inflate(layoutInflater, parent, false)
            return GalleryViewHolder(itemBinding)
        }
    }
}