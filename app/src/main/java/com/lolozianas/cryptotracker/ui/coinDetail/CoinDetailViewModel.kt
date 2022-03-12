package com.lolozianas.cryptotracker.ui.coinDetail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lolozianas.cryptotracker.network.CoinApi
import com.lolozianas.cryptotracker.network.CoinDetail
import kotlinx.coroutines.launch

class CoinDetailViewModel : ViewModel() {

    private val _coinDetail = MutableLiveData<CoinDetail>()
    val coinDetail: LiveData<CoinDetail> get() = _coinDetail


    fun getCoinById(coinId: String) {
        viewModelScope.launch {
            try {
                _coinDetail.value = CoinApi.retrofitService.getCoinById(coinId)
                Log.d("CDViewModel", "getCoinById: ${_coinDetail.value?.name!!}")
            } catch (e: Exception) {

            }
        }
    }

}