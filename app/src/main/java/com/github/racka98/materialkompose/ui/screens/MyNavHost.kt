package com.github.racka98.materialkompose.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun MyNavHost(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        modifier = Modifier,
        navController = navController,
        startDestination = Destination.Charts.route
    ) {
        composable(route = Destination.Charts.route) {
            ChartsPreview()
        }
    }
}

enum class Destination(
    val route: String
) {
    Charts(
        route = "charts_route"
    )
}