package com.lolozianas.cryptotracker.ui.overview

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lolozianas.cryptotracker.network.Coin
import com.lolozianas.cryptotracker.network.CoinAPI
import kotlinx.coroutines.launch

/**
 * The [APIStatus] class that dispay the three status of a client request.
 */
enum class APIStatus { LOADING, ERROR, SUCCESS }

/**
 * The [ViewModel] that is attached to the [OverviewFragment].
 */
class OverviewViewModel : ViewModel() {
    // Internal MutableLiveData that stores a coins list of the most recent request
    private val _coins = MutableLiveData<List<Coin>>()

    // External immutable LiveData for coins list
    val coins: LiveData<List<Coin>> = _coins

    // Internal MutableLiveData that stores the status of the most recent request
    private val _status = MutableLiveData<APIStatus>()

    // External immutable LiveData for request's status
    val status: LiveData<APIStatus> = _status

    /**
     * Call getCoins method on init so we can display status immediately
     * */
    init {
        getCoins()
    }

    /**
     * Gets coins information from the Coins API Retrofit service and updates the
     * [Coin] [List] [LiveData].
     */
    private fun getCoins() {
        viewModelScope.launch {
            _status.value = APIStatus.LOADING
            try {
                _coins.value = CoinAPI.retrofitService.getCoins()
                _status.value = APIStatus.SUCCESS
            } catch (e: Exception) {
                _status.value = APIStatus.ERROR
                _coins.value = listOf()
            }
        }
    }

}