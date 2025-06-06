package com.samuraicmdv.domain.dagger

import com.samuraicmdv.domain.repository.ProductRepository
import com.samuraicmdv.domain.usecase.CreateProductUseCase
import com.samuraicmdv.domain.usecase.GetProductDetailsForStoreUseCase
import com.samuraicmdv.domain.usecase.GetProductDetailsGeneralUseCase
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
    fun provideGetProductDetailsForStoreUseCase(
        productRepository: ProductRepository,
    ): GetProductDetailsForStoreUseCase =
        GetProductDetailsForStoreUseCase(productRepository)

    @Provides
    fun provideGetProductDetailsGeneralUseCase(
        productRepository: ProductRepository,
    ): GetProductDetailsGeneralUseCase =
        GetProductDetailsGeneralUseCase(productRepository)
}