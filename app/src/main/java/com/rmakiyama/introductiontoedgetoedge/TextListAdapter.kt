package com.rmakiyama.introductiontoedgetoedge

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.rmakiyama.introductiontoedgetoedge.databinding.ItemTextBinding

class TextListAdapter : ListAdapter<String, TextViewHolder>(DemoDiff) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TextViewHolder {
        return TextViewHolder(
            ItemTextBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(
        holder: TextViewHolder,
        position: Int
    ) {
        holder.bind(getItem(position))
    }
}

class TextViewHolder(
    private val binding: ItemTextBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(text: String) {
        binding.text.text = text
    }
}

object DemoDiff : DiffUtil.ItemCallback<String>() {
    override fun areItemsTheSame(
        oldItem: String,
        newItem: String
    ): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(
        oldItem: String,
        newItem: String
    ): Boolean {
        return oldItem == newItem
    }
}
