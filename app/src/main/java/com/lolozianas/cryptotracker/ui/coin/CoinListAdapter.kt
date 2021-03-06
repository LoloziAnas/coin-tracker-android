package com.lolozianas.cryptotracker.ui.coin

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.lolozianas.cryptotracker.databinding.ListViewCoinBinding
import com.lolozianas.cryptotracker.network.Coin


class CoinListAdapter(private val clickListener: CoinListener) :
    ListAdapter<Coin, CoinListAdapter.CoinViewHolder>(CoinDiffCallback) {

    inner class CoinViewHolder(private val binding: ListViewCoinBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindCoin(coin: Coin, clickListener: CoinListener) {
            binding.coin = coin
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinViewHolder {
        return CoinViewHolder(ListViewCoinBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: CoinViewHolder, position: Int) {
        val coin = getItem(position)
        holder.bindCoin(coin, clickListener)
    }

    companion object CoinDiffCallback : DiffUtil.ItemCallback<Coin>() {
        override fun areItemsTheSame(oldItem: Coin, newItem: Coin): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Coin, newItem: Coin): Boolean {
            return oldItem == newItem
        }

    }
}

class CoinListener(val clickListener: (coin: Coin) -> Unit) {
    fun onClick(coin: Coin) = clickListener(coin)
}
