package com.project.seekho.presentation

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.project.seekho.utils.Response

@Composable
fun MovieDetailScreen(movieId: Int, navController: NavController) {

    val viewModel: MovieViewModel = hiltViewModel()
    val context = LocalContext.current

    LaunchedEffect(Unit) {
        viewModel.getMovieDetail(movieId)
    }

    when (val response = viewModel.movieDetailResponse.value) {
        is Response.Initialisation -> {

        }

        is Response.Error -> {

            Toast.makeText(context, "Failure ", Toast.LENGTH_LONG).show()
        }

        is Response.Success -> {

            Column {
                Toolbar(true, response.data.data?.title, navController = navController)
                MovieDetailContent(response.data)
            }
        }

        is Response.Loading -> {
          CircularLoader()
        }

    }

}