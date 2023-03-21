package com.aghogho.coinpaprikaapitaskmvvm.view

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.aghogho.coinpaprikaapitaskmvvm.viewmodel.CoinPaprikaViewModel
import dagger.hilt.android.lifecycle.HiltViewModel

@Composable
fun CoinPaprikaAllCoinsScreen(
    navController: NavController,
    viewModel: CoinPaprikaViewModel = hiltViewModel()
) {

}
