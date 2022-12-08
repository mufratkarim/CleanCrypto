package com.mka.cleancrypto.domain.use_case.get_coins

import com.mka.cleancrypto.common.Resource
import com.mka.cleancrypto.data.remote.dto.toCoin
import com.mka.cleancrypto.domain.model.CoinList
import com.mka.cleancrypto.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(private val repository: CoinRepository) {
    operator fun invoke(): Flow<Resource<List<CoinList>>> = flow {
        try {
            emit(Resource.Loading<List<CoinList>>())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success<List<CoinList>>(coins))
        } catch (e: HttpException) {
            emit(Resource.Error<List<CoinList>>(e.localizedMessage ?: "An unexpected error has occurred"))
        } catch (e: IOException) {
            emit(Resource.Error<List<CoinList>>("Server is down!"));
        }
    }
}