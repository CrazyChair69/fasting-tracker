package com.example.fastingtracker.progress

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.fastingtracker.database.progress.Diet
import com.example.fastingtracker.databinding.ItemProgressOverviewBinding

/**
 * Adapter of the recyclerview in fragment_progress_overview.xml
 */
class ProgressOverviewAdapter :
    ListAdapter<Diet, ProgressOverviewAdapter.ProgressViewHolder>(DiffCallback) {

    class ProgressViewHolder(private var binding: ItemProgressOverviewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        // TODO: Implement ProgressViewHolder (fun bind)
            // Get total from ProgressViewModel which has a fun that stores last entry and calculates total
    }

    /**
     * Creates a new view holder when there are no existing view holders
     * which the RecyclerView can reuse.
     */
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