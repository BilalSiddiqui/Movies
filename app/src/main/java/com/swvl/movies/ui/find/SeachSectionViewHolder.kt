package com.swvl.movies.ui.find

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.swvl.movies.databinding.ItemSearchSectionBinding

class SeachSectionViewHolder(private val binding: ItemSearchSectionBinding) :
    RecyclerView.ViewHolder(binding.root) {


    fun bind(title: RecyclerItem.Section) {
        binding.section = title
        binding.executePendingBindings();
    }

    companion object {
        fun create(parent: ViewGroup): SeachSectionViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val itemBinding: ItemSearchSectionBinding =
                ItemSearchSectionBinding.inflate(layoutInflater, parent, false)
            return SeachSectionViewHolder(itemBinding)
        }
    }
}