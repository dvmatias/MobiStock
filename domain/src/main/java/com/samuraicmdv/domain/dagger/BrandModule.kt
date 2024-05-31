package com.samuraicmdv.domain.dagger

import com.samuraicmdv.domain.repository.BrandRepository
import com.samuraicmdv.domain.usecase.GetProductBrandsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object BrandModule {
    @Provides
    fun provideGetProductBrandsUseCase(brandRepository: BrandRepository): GetProductBrandsUseCase =
        GetProductBrandsUseCase(brandRepository)

}