package com.project.seekho.data.model

import com.google.gson.annotations.SerializedName

data class MovieListResponse(
    @SerializedName("data")
    val data: ArrayList<MovieListData>?,
    val pagination: Pagination?
)