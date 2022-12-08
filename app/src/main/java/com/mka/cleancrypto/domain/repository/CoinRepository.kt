package com.mka.cleancrypto.domain.repository

import com.mka.cleancrypto.data.remote.dto.CoinDetailDto
import com.mka.cleancrypto.data.remote.dto.CoinListDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinListDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto
}