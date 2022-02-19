package com.lolozianas.cryptotracker.ui.overview

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.lolozianas.cryptotracker.databinding.LinearViewItemBinding
import com.lolozianas.cryptotracker.network.Coin

class OverviewAdapter : ListAdapter<Coin, OverviewAdapter.OverviewViewHolder>(DiffCallback) {
    class OverviewViewHolder(private var binding: LinearViewItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(coin: Coin) {
            binding.coin = coin
            binding.isActive = coin.isActive
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OverviewViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: OverviewViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Coin>() {
        override fun areItemsTheSame(oldItem: Coin, newItem: Coin): Boolean {
            TODO("Not yet implemented")
        }

        override fun areContentsTheSame(oldItem: Coin, newItem: Coin): Boolean {
            TODO("Not yet implemented")
        }

    }
}