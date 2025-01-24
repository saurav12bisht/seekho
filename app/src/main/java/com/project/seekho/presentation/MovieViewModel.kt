package com.project.seekho.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.seekho.data.model.MovieDetailResponse
import com.project.seekho.data.model.MovieListResponse
import com.project.seekho.domain.repository.MovieListRepository
import com.project.seekho.utils.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val movieListRepository: MovieListRepository
) : ViewModel() {

    private val _movieListResponse =
        mutableStateOf<Response<MovieListResponse>>(Response.Initialisation)
    val movieListResponse: State<Response<MovieListResponse>> = _movieListResponse


    fun getMovieList() {
        viewModelScope.launch {
            movieListRepository.getMovieList().collect {
                _movieListResponse.value = it
            }
        }

    }

    private val _movieDetailResponse =
        mutableStateOf<Response<MovieDetailResponse>>(Response.Initialisation)
    val movieDetailResponse: State<Response<MovieDetailResponse>> = _movieDetailResponse


    fun getMovieDetail(movieId: Int) {
        viewModelScope.launch {

            movieListRepository.getMovieDetail(movieId).collect {
                _movieDetailResponse.value = it
            }

        }
    }


}