package com.samuraicmdv.domain.dagger

import com.samuraicmdv.domain.repository.ProductRepository
import com.samuraicmdv.domain.usecase.CreateProductUseCase
import com.samuraicmdv.domain.usecase.GetProductDetailsByCodeForStoreUseCase
import com.samuraicmdv.domain.usecase.GetProductDetailsByCodeGeneralUseCase
import com.samuraicmdv.domain.usecase.GetProductDetailsByIdForStoreUseCase
import com.samuraicmdv.domain.usecase.GetProductDetailsByIdGeneralUseCase
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
    fun provideGetProductDetailsByIdForStoreUseCase(
        productRepository: ProductRepository,
    ): GetProductDetailsByIdForStoreUseCase =
        GetProductDetailsByIdForStoreUseCase(productRepository)

    @Provides
    fun provideGetProductDetailsByIdGeneralUseCase(
        productRepository: ProductRepository,
    ): GetProductDetailsByIdGeneralUseCase =
        GetProductDetailsByIdGeneralUseCase(productRepository)

    @Provides
    fun provideGetProductDetailsByCodeForStoreUseCase(
        productRepository: ProductRepository,
    ): GetProductDetailsByCodeForStoreUseCase =
        GetProductDetailsByCodeForStoreUseCase(productRepository)

    @Provides
    fun provideGetProductDetailsByCodeGeneralUseCase(
        productRepository: ProductRepository,
    ): GetProductDetailsByCodeGeneralUseCase =
        GetProductDetailsByCodeGeneralUseCase(productRepository)
}