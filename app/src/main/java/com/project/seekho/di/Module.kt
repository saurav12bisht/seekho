package com.project.seekho.di

import com.project.seekho.data.remote.ApiService
import com.project.seekho.data.repository.MovieListRepositoryImpl
import com.project.seekho.domain.repository.MovieListRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Module {

    @Singleton
    @Provides
    fun provideMovieRepository(
        apiService: ApiService
    ): MovieListRepository {
        return MovieListRepositoryImpl(apiService = apiService)
    }
}