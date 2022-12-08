package com.mka.cleancrypto.data.remote.dto

import com.mka.cleancrypto.domain.model.CoinList

data class CoinListDto(
    val id: String,
    val is_active: Boolean,
    val is_new: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val type: String
)

fun CoinListDto.toCoin() : CoinList {
    return CoinList(
        id = id,
        is_active = is_active,
        name = name,
        rank = rank,
        symbol = symbol
    )
}