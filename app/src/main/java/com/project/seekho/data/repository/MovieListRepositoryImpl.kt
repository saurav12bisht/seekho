package com.project.seekho.data.repository

import com.project.seekho.data.model.MovieDetailResponse
import com.project.seekho.data.model.MovieListData
import com.project.seekho.data.model.MovieListResponse
import com.project.seekho.data.remote.ApiService
import com.project.seekho.domain.repository.MovieListRepository
import com.project.seekho.utils.Response
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MovieListRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : MovieListRepository {
    override fun getMovieList(): Flow<Response<MovieListResponse>> = flow {

        emit(Response.Loading)
        try {
            val response = apiService.getMovieList()
            emit(Response.Success(response))
        } catch (e: Exception) {
            emit(Response.Error(e))

        }

    }

    override fun getMovieDetail(animeId: Int): Flow<Response<MovieDetailResponse>> = flow {

        emit(Response.Loading)
        try {
            val response = apiService.getMovieDetail(animeId)
            emit(Response.Success(response))
        } catch (e: Exception) {
            emit(Response.Error(e))

        }
    }

}