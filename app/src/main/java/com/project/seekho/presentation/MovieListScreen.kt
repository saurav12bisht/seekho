package com.project.seekho.presentation

import android.util.Log
import android.widget.Toast
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.google.gson.Gson
import com.project.seekho.utils.Response


@Composable
fun MovieListScreen(
    navController: NavController
) {
    val viewModel: MovieViewModel = hiltViewModel()
    val context = LocalContext.current
    val response = viewModel.movieListResponse
    val gson = Gson()

    LaunchedEffect(Unit) {
        viewModel.getMovieList()
    }
    val systemUiController = rememberSystemUiController()

    systemUiController.setStatusBarColor(MaterialTheme.colorScheme.primary)

    when (val currentResponse = response.value) {
        is Response.Error -> {
            Toast.makeText(context, currentResponse.e.message, Toast.LENGTH_SHORT).show()
        }

        is Response.Initialisation -> {

        }

        is Response.Loading -> {
            CircularLoader()
        }

        is Response.Success -> {
            val movieList = currentResponse.data.data ?: emptyList()
            val movieJson = gson.toJson(movieList)

            Log.e("MOVIE_LIST", "MovieList JSON: $movieJson")

            MovieList(movie = movieList, navController)
        }
    }
}
