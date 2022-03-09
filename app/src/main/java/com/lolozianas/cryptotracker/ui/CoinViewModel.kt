package com.lolozianas.cryptotracker.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lolozianas.cryptotracker.network.Coin
import com.lolozianas.cryptotracker.network.CoinApi
import kotlinx.coroutines.launch

enum class APIStatus { DONE, LOADING, ERROR }
class CoinViewModel : ViewModel() {
    /** */
    private val _coins = MutableLiveData<List<Coin>>()
    val coins: LiveData<List<Coin>> = _coins

    private val _status = MutableLiveData<APIStatus>()
    val status: LiveData<APIStatus> = _status

    init {
        getCoins()
    }

    private fun getCoins() {
        viewModelScope.launch {
            _status.value = APIStatus.LOADING
            try {
                _status.value = APIStatus.DONE
                _coins.value = CoinApi.retrofitService.getCoins()
            } catch (e: Exception) {
                _status.value = APIStatus.ERROR
                _coins.value = listOf()
            }
        }
    }
}