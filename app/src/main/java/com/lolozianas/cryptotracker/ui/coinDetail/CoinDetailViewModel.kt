package com.lolozianas.cryptotracker.ui.coinDetail

import android.util.Log
import androidx.lifecycle.*
import com.lolozianas.cryptotracker.network.Coin
import com.lolozianas.cryptotracker.network.CoinApi
import com.lolozianas.cryptotracker.network.CoinDetail
import kotlinx.coroutines.launch

/** The [CoinDetailViewModel] associated to the [CoinDetailFragment], containing information about
 *  the selected coin*/

class CoinDetailViewModel(val coin: Coin) : ViewModel() {

    private val _selectedCoin = MutableLiveData<Coin>()

    // The external LiveData for the selectedCoin
    val selectedCoin: LiveData<Coin> get() = _selectedCoin
    private val _coinDetail = MutableLiveData<CoinDetail>()
    val coinDetail: LiveData<CoinDetail> get() = _coinDetail


    init {
        _selectedCoin.value = coin
    }

    fun getCoinById() {
        viewModelScope.launch {
            try {
                _coinDetail.value = CoinApi.retrofitService.getCoinById(_selectedCoin.value!!.id)
                Log.d("CDViewModel", "getCoinById: ${_coinDetail.value?.name!!}")
            } catch (e: Exception) {

            }
        }
    }
}

/**
 * Simple ViewModel factory that provides the Coin to the [CoinDetailViewModel]
 * */
class CoinDetailViewModelFactory(val coin: Coin) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CoinDetailViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return CoinDetailViewModel(coin) as T
        }
        throw IllegalArgumentException("Unknown ViewModel  class")
    }
}