package com.mka.cleancrypto.presentation.coin_list

import com.mka.cleancrypto.domain.model.CoinList

data class CoinListState(
    val loading: Boolean = false,
    val coins: List<CoinList> = emptyList(),
    val error: String = ""
)