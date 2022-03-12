package com.lolozianas.cryptotracker.network

import com.lolozianas.cryptotracker.BASE_URL
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path


/**
 * Build the Moshi object that Retrofit will be using, making sure to add the Kotlin adapter for
 * full Kotlin compatibility.
 */
private val moshi = Moshi
    .Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

/**
 * Use the Retrofit builder to build a retrofit object using a Moshi converter with our Moshi
 * object.
 */
private val retrofit = Retrofit
    .Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .build()

/**
 * A public interface that exposes the [getCoinById] and [getCoins] methods
 */
interface CoinApiService {

    @GET("coins")
    suspend fun getCoins(): List<Coin>

    @GET("coins/{coin_id}")
    suspend fun getCoinById(@Path("coin_id") coinId: String): CoinDetail
}

/**
 * A public Api object that exposes the lazy-initialized Retrofit service
 */
object CoinApi {
    val retrofitService: CoinApiService by lazy {
        retrofit.create(CoinApiService::class.java)
    }
}