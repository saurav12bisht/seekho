package com.project.seekho.utils

sealed class Response<out T> {
    data object Loading : Response<Nothing>()
    data object Initialisation : Response<Nothing>()
    data class Success<out T>(
        val data: T
    ) : Response<T>()


    data class Error(
        val e: Exception
    ) : Response<Nothing>()

}