package com.samuraicmdv.domain.dagger

import com.samuraicmdv.domain.repository.CategoryRepository
import com.samuraicmdv.domain.usecase.GetCategoryUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object CategoryModule {
    @Provides
    fun provideGetCategoryUseCase(categoryRepository: CategoryRepository): GetCategoryUseCase =
        GetCategoryUseCase(categoryRepository)

}