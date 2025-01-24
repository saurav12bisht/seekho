package com.project.seekho.domain.repository

import com.project.seekho.data.model.MovieDetailResponse
import com.project.seekho.data.model.MovieListData
import com.project.seekho.data.model.MovieListResponse
import com.project.seekho.utils.Response
import kotlinx.coroutines.flow.Flow

interface MovieListRepository {
    fun getMovieList(): Flow<Response<MovieListResponse>>

    fun getMovieDetail(animeId: Int): Flow<Response<MovieDetailResponse>>

}