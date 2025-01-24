package com.project.seekho.data.remote

import com.project.seekho.data.model.MovieDetailResponse
import com.project.seekho.data.model.MovieListData
import com.project.seekho.data.model.MovieListResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("top/anime")
    suspend fun getMovieList(): MovieListResponse

    @GET("anime/{anime_id}")
    suspend fun getMovieDetail(
        @Path("anime_id") animeId: Int
    ): MovieDetailResponse



}