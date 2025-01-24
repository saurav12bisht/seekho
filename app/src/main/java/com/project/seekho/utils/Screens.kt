package com.project.seekho.utils

sealed class Screens(val route: String) {
    object MovieListScreen : Screens("MovieListScreen")
    object MovieDetailScreen : Screens("movie_detail_screen/{movieId}")
    fun createRoute(movieId: Int): String = "movie_detail_screen/$movieId"
}
