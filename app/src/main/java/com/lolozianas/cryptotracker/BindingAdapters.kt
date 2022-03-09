package com.lolozianas.cryptotracker

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.lolozianas.cryptotracker.network.Coin
import com.lolozianas.cryptotracker.ui.APIStatus
import com.lolozianas.cryptotracker.ui.CoinListAdapter

/**
 * Updates the data shown in the [RecyclerView].
 */
@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Coin>?) {
    val adapter = recyclerView.adapter as CoinListAdapter
    adapter.submitList(data)
}

/**
 * This binding adapter displays the [] of the network request in an image view.  When
 * the request is loading, it displays a loading_animation.  If the request has an error, it
 * displays a broken image to reflect the connection error.  When the request is finished, it
 * hides the image view.
 */

@BindingAdapter("apiStatus")
fun bindStatus(statusImageView: ImageView, status: APIStatus?) {
    when (status) {
        APIStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading_animation)
        }
        APIStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_connection_error)
        }
        // APIStatus.DONE
        else -> {
            statusImageView.visibility = View.GONE
        }
    }
}
