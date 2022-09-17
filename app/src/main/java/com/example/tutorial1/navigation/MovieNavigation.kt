package com.example.tutorial1.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.tutorial1.screens.details.DetailScreen
import com.example.tutorial1.screens.home.HomeScreen

@Composable
fun MovieNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = MovieScreens.HomeScreen.name
    ) {
        composable(
            MovieScreens.HomeScreen.name,
        ) { backStackEntry ->
            HomeScreen(
                navController = navController,
            )
        }
        composable(
            MovieScreens.DetailScreen.name+"/{movie}",
            arguments = listOf(navArgument(name="movie") { type = NavType.StringType })
        ) { backStackEntry ->
            DetailScreen(
                navController = navController,
                backStackEntry.arguments?.getString("movie")
            )
        }
    }
}
