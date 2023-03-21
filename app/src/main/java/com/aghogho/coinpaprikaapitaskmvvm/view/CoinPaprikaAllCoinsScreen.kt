package com.aghogho.coinpaprikaapitaskmvvm.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.aghogho.coinpaprikaapitaskmvvm.view.screens.Screen
import com.aghogho.coinpaprikaapitaskmvvm.viewmodel.CoinPaprikaViewModel

@Composable
fun CoinPaprikaAllCoinsScreen(
    navController: NavController,
    viewModel: CoinPaprikaViewModel = hiltViewModel()
) {
    Box(modifier = Modifier.fillMaxSize()) {
    val allCoins = viewModel.getAllCoins
        LazyColumn(modifier = Modifier.fillMaxSize()) {
//            items(allCoins) {
//                CoinPaprikaListItem(coin = allCoins
//                    onCoinClicked {
//                        navController.navigate(Screen.CoinPaprikaDetailCoinScreen.route)
//                    }
//                )
//            }

        }
    }
}
