package com.lolozianas.cryptotracker.network

import com.squareup.moshi.Json

data class CoinDetail(
    @Json(name = "description") val description: String,
    @Json(name = "id") val id: String,
    @Json(name = "is_active") val is_active: Boolean,
    @Json(name = "name") val name: String,
    @Json(name = "symbol") val symbol: String,
    @Json(name = "tags") val tags: List<Tag>,
    @Json(name = "team") val team: List<Team>,
)