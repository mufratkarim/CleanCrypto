package com.mka.cleancrypto.presentation

sealed class Screen(val route: String) {

    object CoinListScreen: Screen("coin_list_screen")
    object CoinDetailtScreen: Screen("coin_detail_screen")
}