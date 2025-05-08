package com.samuraicmdv.data.dagger

import com.samuraicmdv.data.datasource.BrandDataSource
import com.samuraicmdv.data.datasource.CategoryDataSource
import com.samuraicmdv.data.datasource.ProductDataSource
import com.samuraicmdv.data.datasource.SalesLedgeDataSource
import com.samuraicmdv.data.datasource.retrofit.LoginDataSourceRetrofitImpl
import com.samuraicmdv.data.datasource.retrofit.UserDataSourceRetrofitImpl
import com.samuraicmdv.data.repository.BrandRepositoryImpl
import com.samuraicmdv.data.repository.CategoryRepositoryImpl
import com.samuraicmdv.data.repository.LoginRepositoryImpl
import com.samuraicmdv.data.repository.ProductRepositoryImpl
import com.samuraicmdv.data.repository.SalesLedgeRepositoryImpl
import com.samuraicmdv.data.repository.UserRepositoryImpl
import com.samuraicmdv.domain.repository.BrandRepository
import com.samuraicmdv.domain.repository.CategoryRepository
import com.samuraicmdv.domain.repository.LoginRepository
import com.samuraicmdv.domain.repository.ProductRepository
import com.samuraicmdv.domain.repository.SalesLedgeRepository
import com.samuraicmdv.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    fun provideLoginRepository(loginDataSource: LoginDataSourceRetrofitImpl): LoginRepository =
        LoginRepositoryImpl(loginDataSource)

    @Provides
    fun provideUserRepository(homeDataSource: UserDataSourceRetrofitImpl): UserRepository =
        UserRepositoryImpl(homeDataSource)

    @Provides
    fun provideCategoryRepository(categoryDataSource: CategoryDataSource): CategoryRepository =
        CategoryRepositoryImpl(categoryDataSource)

    @Provides
    fun provideBrandRepository(brandDataSource: BrandDataSource): BrandRepository =
        BrandRepositoryImpl(brandDataSource)

    @Provides
    fun provideProductRepository(productDataSource: ProductDataSource): ProductRepository =
        ProductRepositoryImpl(productDataSource)

    @Provides
    fun provideSalesRepository(salesLedgeDataSource: SalesLedgeDataSource): SalesLedgeRepository =
        SalesLedgeRepositoryImpl(salesLedgeDataSource)

}