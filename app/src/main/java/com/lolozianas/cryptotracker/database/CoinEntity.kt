package com.lolozianas.cryptotracker.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "coins")
data class Coin(
    @PrimaryKey val id: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "symbol") val symbol: String,
    val isActive: Boolean,
)