package com.aghogho.coinpaprikaapitaskmvvm.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.aghogho.coinpaprikaapitaskmvvm.ui.theme.CoinPaprikaApiTaskMVVMTheme
import com.aghogho.coinpaprikaapitaskmvvm.view.screens.Screen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoinPaprikaApiTaskMVVMTheme {
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.CoinPaprikaAllCoinsScreen.route
                    ) {
                        composable(
                            route = Screen.CoinPaprikaAllCoinsScreen.route
                        ) {
                            CoinPaprikaAllCoinsScreen(navController = navController)
                        }
                        composable(
                            route = Screen.CoinPaprikaDetailCoinScreen.route
                        ) {
                            CoinPaprikaDetailCoinScreen(navController = navController)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CoinPaprikaApiTaskMVVMTheme {
        Greeting("Android")
    }
}
