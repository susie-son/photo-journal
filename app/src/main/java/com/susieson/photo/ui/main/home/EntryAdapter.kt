package com.susieson.photo.ui.main.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.susieson.photo.common.formatDate
import com.susieson.photo.databinding.ItemEntryBinding
import com.susieson.photo.model.Entry

class EntryAdapter :
    ListAdapter<Entry, EntryAdapter.ViewHolder>(EntryDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemEntryBinding.inflate(inflater)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(val binding: ItemEntryBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(entry: Entry) {
            binding.thumbnail.load(entry.imageUrl)
            binding.description.text = entry.description
            binding.timestamp.text = formatDate(entry.timestamp.toDate())
        }
    }

    class EntryDiffCallback : DiffUtil.ItemCallback<Entry>() {
        override fun areItemsTheSame(oldItem: Entry, newItem: Entry) = oldItem == newItem
        override fun areContentsTheSame(oldItem: Entry, newItem: Entry) = oldItem == newItem
    }
}