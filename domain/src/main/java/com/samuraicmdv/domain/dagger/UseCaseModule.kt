package com.samuraicmdv.domain.dagger

import com.samuraicmdv.domain.repository.ItemRepository
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
    fun provideCreateProductUseCase(itemRepository: ItemRepository): CreateProductUseCase =
        CreateProductUseCase(itemRepository)

    @Provides
    fun provideGetProductDetailsByIdForStoreUseCase(
        itemRepository: ItemRepository,
    ): GetProductDetailsByIdForStoreUseCase =
        GetProductDetailsByIdForStoreUseCase(itemRepository)

    @Provides
    fun provideGetProductDetailsByIdGeneralUseCase(
        itemRepository: ItemRepository,
    ): GetProductDetailsByIdGeneralUseCase =
        GetProductDetailsByIdGeneralUseCase(itemRepository)

    @Provides
    fun provideGetProductDetailsByCodeForStoreUseCase(
        itemRepository: ItemRepository,
    ): GetProductDetailsByCodeForStoreUseCase =
        GetProductDetailsByCodeForStoreUseCase(itemRepository)

    @Provides
    fun provideGetProductDetailsByCodeGeneralUseCase(
        itemRepository: ItemRepository,
    ): GetProductDetailsByCodeGeneralUseCase =
        GetProductDetailsByCodeGeneralUseCase(itemRepository)
}