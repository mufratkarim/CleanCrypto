package com.mka.cleancrypto.di

import com.mka.cleancrypto.common.Constants
import com.mka.cleancrypto.data.remote.CoinPaprikaApi
import com.mka.cleancrypto.data.repository.CoinRepoImpl
import com.mka.cleancrypto.domain.repository.CoinRepository
import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesPaprikaApi(): CoinPaprikaApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPaprikaApi::class.java)

    }

    @Provides
    @Singleton
    fun providesPaprikaRepository(api: CoinPaprikaApi): CoinRepository {
        return CoinRepoImpl(api)
    }
}