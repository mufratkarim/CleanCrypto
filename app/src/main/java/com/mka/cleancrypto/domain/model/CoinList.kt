package com.mka.cleancrypto.domain.model

data class CoinList(
    val id: String,
    val is_active: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
)
