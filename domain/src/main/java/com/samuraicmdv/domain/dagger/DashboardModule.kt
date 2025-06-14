package com.samuraicmdv.domain.dagger

import com.samuraicmdv.domain.repository.CategoryRepository
import com.samuraicmdv.domain.repository.SalesLedgerRepository
import com.samuraicmdv.domain.repository.UserRepository
import com.samuraicmdv.domain.usecase.GetDaySalesLedgerUseCase
import com.samuraicmdv.domain.usecase.GetDaySalesLedgerUseCaseImpl
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
    fun provideGetDaySalesLedgerUseCase(
        salesLedgerRepository: SalesLedgerRepository,
    ): GetDaySalesLedgerUseCase =
        GetDaySalesLedgerUseCaseImpl(salesLedgerRepository)
}