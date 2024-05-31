package com.samuraicmdv.data.dagger

import com.samuraicmdv.data.datasource.BrandDataSource
import com.samuraicmdv.data.datasource.CategoryDataSource
import com.samuraicmdv.data.datasource.retrofit.HomeDataSourceRetrofitImpl
import com.samuraicmdv.data.datasource.retrofit.LoginDataSourceRetrofitImpl
import com.samuraicmdv.data.repository.BrandRepositoryImpl
import com.samuraicmdv.data.repository.CategoryRepositoryImpl
import com.samuraicmdv.data.repository.HomeRepositoryImpl
import com.samuraicmdv.data.repository.LoginRepositoryImpl
import com.samuraicmdv.domain.repository.BrandRepository
import com.samuraicmdv.domain.repository.CategoryRepository
import com.samuraicmdv.domain.repository.HomeRepository
import com.samuraicmdv.domain.repository.LoginRepository
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
    fun provideHomeRepository(homeDataSource: HomeDataSourceRetrofitImpl): HomeRepository =
        HomeRepositoryImpl(homeDataSource)

    @Provides
    fun provideCategoryRepository(categoryDataSource: CategoryDataSource): CategoryRepository =
        CategoryRepositoryImpl(categoryDataSource)

    @Provides
    fun provideBrandRepository(brandDataSource: BrandDataSource): BrandRepository =
        BrandRepositoryImpl(brandDataSource)

}