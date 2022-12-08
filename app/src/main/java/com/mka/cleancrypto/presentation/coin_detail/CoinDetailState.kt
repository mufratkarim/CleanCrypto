package com.mka.cleancrypto.presentation.coin_detail

import com.mka.cleancrypto.domain.model.CoinDetail
import com.mka.cleancrypto.domain.model.CoinList

data class CoinDetailState(
    val loading: Boolean = false,
    val coinDetail: CoinDetail? = null,
    val error: String = ""
)