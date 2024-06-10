package com.samuraicmdv.domain.dagger

import com.samuraicmdv.domain.repository.ProductRepository
import com.samuraicmdv.domain.usecase.CreateProductUseCase
import com.samuraicmdv.domain.usecase.GetProductDetailsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    fun provideCreateProductUseCase(productRepository: ProductRepository): CreateProductUseCase =
        CreateProductUseCase(productRepository)

    @Provides
    fun provideGetProductDetailsUseCase(
        productRepository: ProductRepository,
    ): GetProductDetailsUseCase =
        GetProductDetailsUseCase(productRepository)
}