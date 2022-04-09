package com.lolozianas.cryptotracker.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CoinDao {

    @Query("SELECT * FROM coins")
    fun getAllCoins(): List<Coin>

    @Query("SELECT * FROM coins WHERE id LIKE :coinId")
    fun getCoinById(coinId: String): Coin

    @Insert
    fun insertCoin(coin: Coin)

    @Delete
    fun deleteCoin(coin: Coin)
}