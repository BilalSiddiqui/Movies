package com.swvl.movies.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso
import com.swvl.movies.R

object BindingAdapter {

    @JvmStatic
    @BindingAdapter("urlImage")
    fun bindUrlImage(view: ImageView, imageUrl: String?) {
        if (imageUrl != null) {
            Picasso.get()
                .load(imageUrl)
                .fit()
                .placeholder(R.drawable.image_place_holder)
                .centerCrop()
                .into(view)
        } else {
            view.setImageBitmap(null)
        }
    }
}