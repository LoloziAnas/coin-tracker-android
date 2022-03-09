package com.lolozianas.cryptotracker.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://api.coinpaprika.com/v1/"
private const val GET_COINS = "coins"

private val moshi = Moshi
    .Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit
    .Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .build()

interface CoinApiService {

    @GET(GET_COINS)
    suspend fun getCoins(): List<Coin>
}

object CoinApi {
    val retrofitService: CoinApiService by lazy {
        retrofit.create(CoinApiService::class.java)
    }
}