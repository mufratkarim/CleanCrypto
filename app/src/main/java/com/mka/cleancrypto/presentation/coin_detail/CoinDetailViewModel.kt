package com.mka.cleancrypto.presentation.coin_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mka.cleancrypto.common.Constants
import com.mka.cleancrypto.common.Resource
import com.mka.cleancrypto.domain.use_case.get_coin.GetCoinUseCase
import com.mka.cleancrypto.domain.use_case.get_coins.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    private val getCoinUseCase: GetCoinUseCase,
    val savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _state = mutableStateOf(CoinDetailState())
    val state: State<CoinDetailState> = _state

    init {
        savedStateHandle.get<String>(Constants.COIN_ID)?.let { coinid ->
            getCoin(coinid)
        }
    }

    private fun getCoin(coinid : String) {
        getCoinUseCase(coinid).onEach { result ->
            when(result) {
                is Resource.Success -> {
                    _state.value = CoinDetailState(coinDetail = result.data)
                }

                is Resource.Error -> {
                    _state.value = CoinDetailState(error = result.message ?: "An unexpected error has occurred")
                }

                is Resource.Loading -> {
                    _state.value = CoinDetailState(loading = true)
                }

            }
        }.launchIn(viewModelScope)
    }
}