package com.swvl.movies.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.swvl.movies.databinding.ItemErrorBinding

class ErrorViewHolder(binding: ItemErrorBinding) : RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun create(parent: ViewGroup): ErrorViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val itemBinding: ItemErrorBinding =
                ItemErrorBinding.inflate(layoutInflater, parent, false)
            return ErrorViewHolder(itemBinding)
        }
    }
}