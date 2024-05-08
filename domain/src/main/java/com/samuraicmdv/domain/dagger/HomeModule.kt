package com.samuraicmdv.domain.dagger

import com.samuraicmdv.domain.repository.HomeRepository
import com.samuraicmdv.domain.usecase.GetUserProfileUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object HomeModule {
    @Provides
    fun provideGetUserProfileUseCase(homeRepository: HomeRepository): GetUserProfileUseCase =
        GetUserProfileUseCase(homeRepository)
}