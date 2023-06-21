package com.sedra.fitroad.view.register.hoppies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.sedra.fitroad.R
import com.sedra.fitroad.databinding.AdapterInterestsBinding

class CustomViewHolder(val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root)
class InterestsAdapter(private val listener: (input: Int) -> Unit) :
    ListAdapter<Int, CustomViewHolder>(Companion) {

    companion object : DiffUtil.ItemCallback<Int>() {
        override fun areItemsTheSame(oldItem: Int, newItem: Int): Boolean {
            return false
        }

        override fun areContentsTheSame(oldItem: Int, newItem: Int): Boolean {
            return false
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = AdapterInterestsBinding.inflate(inflater, parent, false)
        return CustomViewHolder(binding)

    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val currentMovie = getItem(position)
        val itemBinding = holder.binding as AdapterInterestsBinding
        itemBinding.imageView7.load(currentMovie)
        itemBinding.root.setOnClickListener {
            listener(currentMovie)
        }
    }

}