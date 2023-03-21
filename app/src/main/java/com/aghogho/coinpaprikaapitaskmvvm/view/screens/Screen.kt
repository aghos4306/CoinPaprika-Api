package com.aghogho.coinpaprikaapitaskmvvm.view.screens

sealed class Screen(val route: String) {

    object CoinPaprikaAllCoinsScreen: Screen("paprika_all_coins_screen")
    object CoinPaprikaDetailCoinScreen: Screen("paprika_coin_detail_screen")

}
