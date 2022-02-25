package com.lolozianas.cryptotracker.ui.overview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.lolozianas.cryptotracker.databinding.LinearViewItemBinding
import com.lolozianas.cryptotracker.network.Coin

/**
 * This class implements a [RecyclerView] [ListAdapter] which uses Data Binding to present [List]
 * data, including computing diffs between lists.
 */
class OverviewAdapter : ListAdapter<Coin, OverviewAdapter.OverviewViewHolder>(DiffCallback) {
    /**
     * The [OverviewViewHolder] constructor takes the binding variable from the associated
     * LinearViewItem, which nicely gives it access to the full [Coin] information.
     */
    class OverviewViewHolder(private var binding: LinearViewItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(coin: Coin) {
            // Bind the coin object
            binding.coin = coin
            binding.isActive = coin.isActive

            // This is important, because it forces the data binding to execute immediately,
            // which allows the RecyclerView to make the correct view size measurements
            binding.executePendingBindings()
        }
    }

    /**
     * Create new [RecyclerView] item views by invoking the layout Manager
     * */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OverviewViewHolder {
        return OverviewViewHolder(LinearViewItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    /**
     * Replaces the contents of a view (invoked by the layout manager)
     */
    override fun onBindViewHolder(holder: OverviewViewHolder, position: Int) {
        val coin = getItem(position)
        holder.bind(coin)
    }

    /**
     * Allows the [RecyclerView] to determine which items have changed when the [List] of [Coin]
     * has been updated
     * */
    companion object DiffCallback : DiffUtil.ItemCallback<Coin>() {
        override fun areItemsTheSame(oldItem: Coin, newItem: Coin): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Coin, newItem: Coin): Boolean {
            return oldItem.name == newItem.name
        }

    }
}