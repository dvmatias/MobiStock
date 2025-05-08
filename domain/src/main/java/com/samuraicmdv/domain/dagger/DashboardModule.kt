package com.samuraicmdv.domain.dagger

import com.samuraicmdv.domain.repository.CategoryRepository
import com.samuraicmdv.domain.repository.SalesLedgeRepository
import com.samuraicmdv.domain.repository.UserRepository
import com.samuraicmdv.domain.usecase.GetDailySalesLedgeUseCase
import com.samuraicmdv.domain.usecase.GetDailySalesLedgeUseCaseImpl
import com.samuraicmdv.domain.usecase.GetProductCategoriesUseCase
import com.samuraicmdv.domain.usecase.GetUserProfileUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DashboardModule {
    @Provides
    fun provideGetUserProfileUseCase(userRepository: UserRepository): GetUserProfileUseCase =
        GetUserProfileUseCase(userRepository)

    @Provides
    fun provideGetProductCategoriesUseCase(
        categoryRepository: CategoryRepository,
    ): GetProductCategoriesUseCase =
        GetProductCategoriesUseCase(categoryRepository)

    @Provides
    fun provideGetDailySalesLedgeUseCase(
        salesLedgeRepository: SalesLedgeRepository,
    ): GetDailySalesLedgeUseCase =
        GetDailySalesLedgeUseCaseImpl(salesLedgeRepository)
}