package com.lolozianas.cryptotracker.network

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

/**
 * This data class defines a Coin which includes all the information about a coin.
 * The names of this data class are used by Moshi to match the names of values in JSON.
 * */

@Parcelize
data class Coin(

    // used to map id from JSON to id of our class
    @Json(name = "id") val id: String,

    // used to map name from JSON to name of our class
    @Json(name = "name") val name: String,

    // used to map symbol from JSON to symbol of our class
    @Json(name = "symbol") val symbol: String,

    // used to map is_active from JSON to isActive of our class
    @Json(name = "is_active") val isActive: Boolean,
) : Parcelable

