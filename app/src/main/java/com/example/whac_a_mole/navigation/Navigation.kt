package com.example.whac_a_mole.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.whac_a_mole.ui.screens.gamescreen.GameScreen
import com.example.whac_a_mole.ui.screens.resultscreen.ResultScreen
import com.example.whac_a_mole.ui.screens.startscreen.StartScreen

@Composable
fun Navigation(navController: NavHostController = rememberNavController()) {
    NavHost(navController = navController, startDestination = NavRoute.StartScreen.name) {
        composable(NavRoute.StartScreen.name) {
            StartScreen(navController = navController)
        }
        composable(NavRoute.GameScreen.name) {
            GameScreen(navController = navController)
        }
        composable(NavRoute.ResultScreen.name) {
            ResultScreen(navController = navController)
        }
    }
}