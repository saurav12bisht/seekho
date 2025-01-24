package com.project.seekho.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.project.seekho.utils.Screens


@Composable
fun AppNavigation() {
    val navController = rememberNavController()


    NavHost(navController = navController, startDestination = Screens.MovieListScreen.route) {
        composable(Screens.MovieListScreen.route) {
            MovieListScreen(navController)
        }

        composable(
            route = Screens.MovieDetailScreen.route,
            arguments = listOf(navArgument("movieId") { type = NavType.IntType })
        ) { backStackEntry ->
            val movieId = backStackEntry.arguments?.getInt("movieId") ?: 0 // Default to 0 if null
            MovieDetailScreen(movieId = movieId,navController)
        }

    }
}

