package com.mka.cleancrypto.data.repository

import com.mka.cleancrypto.data.remote.CoinPaprikaApi
import com.mka.cleancrypto.data.remote.dto.CoinDetailDto
import com.mka.cleancrypto.data.remote.dto.CoinListDto
import com.mka.cleancrypto.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepoImpl @Inject constructor(private val api: CoinPaprikaApi): CoinRepository {
    override suspend fun getCoins(): List<CoinListDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}