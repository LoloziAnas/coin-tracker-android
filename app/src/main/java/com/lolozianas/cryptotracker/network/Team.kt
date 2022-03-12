package com.lolozianas.cryptotracker.network

import com.squareup.moshi.Json

data class Team(
    @Json(name = "name")
    val name: String,
    @Json(name = "position")
    val position: String
)