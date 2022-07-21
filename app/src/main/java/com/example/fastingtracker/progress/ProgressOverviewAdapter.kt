package com.example.fastingtracker.progress

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.fastingtracker.database.progress.Diet
import com.example.fastingtracker.databinding.ItemProgressOverviewBinding

class ProgressOverviewAdapter :
    ListAdapter<Diet, ProgressOverviewAdapter.ProgressViewHolder>(DiffCallback) {

    class ProgressViewHolder(private var binding: ItemProgressOverviewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        // TODO: Implement ProgressViewHolder
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProgressViewHolder {
        // Inflate the layout
        return ProgressViewHolder(
            ItemProgressOverviewBinding.inflate(
                LayoutInflater.from(parent.context)
            )
        )
    }

    /**
     * Bind the view at the specified position.
     */
    override fun onBindViewHolder(holder: ProgressViewHolder, position: Int) {
        // TODO: Implement onBindViewHolder(..)
    }

    companion object {
        // Helps ListAdapter determine which items in new and old lists
        // are different when updating list. For better performance
        private val DiffCallback = object : DiffUtil.ItemCallback<Diet>() {
            /**
             * Checks if object (or row in the database in this case) is same by only checking IDs.
             */
            override fun areItemsTheSame(oldItem: Diet, newItem: Diet): Boolean {
                return oldItem.id == newItem.id
            }

            /**
             * Checks if all properties, not just the ID, are the same.
             */
            override fun areContentsTheSame(oldItem: Diet, newItem: Diet): Boolean {
                return oldItem == newItem
            }

        }
    }

}