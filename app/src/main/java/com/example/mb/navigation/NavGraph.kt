package com.example.mb.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.*
import androidx.navigation.compose.*
import com.example.mb.ui.ExchangeDetailScreen
import com.example.mb.ui.ExchangeScreen

@Composable
fun NavGraph(startDestination: String = "exchangeScreen") {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = startDestination) {
        composable("exchangeScreen") {
            ExchangeScreen(navController = navController)
        }
        composable(
            "exchangeDetail/{exchange}",
            arguments = listOf(navArgument("exchange") { type = NavType.StringType })
        ) { backStackEntry ->
            val exchange = backStackEntry.arguments?.getString("exchange").orEmpty()
            ExchangeDetailScreen(navController = navController, exchange = exchange)
        }
    }
}
