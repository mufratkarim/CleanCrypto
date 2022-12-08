package com.mka.cleancrypto.data.remote

import com.mka.cleancrypto.data.remote.dto.CoinDetailDto
import com.mka.cleancrypto.data.remote.dto.CoinListDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaApi {
    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinListDto>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId: String): CoinDetailDto
}