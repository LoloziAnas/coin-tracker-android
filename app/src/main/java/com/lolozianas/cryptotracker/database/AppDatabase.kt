package com.lolozianas.cryptotracker.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Coin::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun coinDao(): CoinDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    "app_database"
                )
                    .createFromAsset("database/coin_db.db")
                    .build()
                INSTANCE = instance

                instance
            }
        }
    }
}