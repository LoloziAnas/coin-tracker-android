package com.lolozianas.cryptotracker.ui.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lolozianas.cryptotracker.network.Coin
import com.lolozianas.cryptotracker.network.CoinAPI
import kotlinx.coroutines.launch
import java.lang.Exception

class OverviewViewModel : ViewModel() {
    private val _coins = MutableLiveData<List<Coin>>()
    val coins: LiveData<List<Coin>> = _coins

    private val _status = MutableLiveData<String>()
    val status: LiveData<String> = _status

    init {
        getCoins()
    }
    private fun getCoins(){
        viewModelScope.launch {
            try {
                _coins.value = CoinAPI.retrofitService.getCoins()
            }catch (e: Exception){

            }
        }
    }

}