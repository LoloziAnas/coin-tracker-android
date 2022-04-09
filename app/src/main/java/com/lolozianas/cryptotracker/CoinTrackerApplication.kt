package com.lolozianas.cryptotracker

import android.app.Application
import com.lolozianas.cryptotracker.database.AppDatabase

class CoinTrackerApplication : Application() {
    val database: AppDatabase by lazy {
        AppDatabase.getDatabase(this)
    }
}