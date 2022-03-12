package com.lolozianas.cryptotracker.network

import com.squareup.moshi.Json

data class Tag(
    @Json(name = "name")
    val name: String
)