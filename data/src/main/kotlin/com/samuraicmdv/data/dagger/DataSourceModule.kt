package com.samuraicmdv.data.dagger

import com.samuraicmdv.data.api.CategoryApi
import com.samuraicmdv.data.api.HomeApi
import com.samuraicmdv.data.api.LoginApi
import com.samuraicmdv.data.datasource.CategoryDataSource
import com.samuraicmdv.data.datasource.HomeDataSource
import com.samuraicmdv.data.datasource.LoginDataSource
import com.samuraicmdv.data.datasource.retrofit.CategoryDataSourceRetrofitImpl
import com.samuraicmdv.data.datasource.retrofit.HomeDataSourceRetrofitImpl
import com.samuraicmdv.data.datasource.retrofit.LoginDataSourceRetrofitImpl
import com.samuraicmdv.data.mapper.CategoryDataMapper
import com.samuraicmdv.data.mapper.LoginDataMapper
import com.samuraicmdv.data.mapper.ProductCategoryMapper
import com.samuraicmdv.data.mapper.UserProfileDataMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {
    @Provides
    fun provideLoginDataSourceRetrofit(
        loginApi: LoginApi,
        dataMapper: LoginDataMapper,
    ): LoginDataSource = LoginDataSourceRetrofitImpl(loginApi, dataMapper)

    @Provides
    fun provideHomeDataSourceRetrofit(
        homeApi: HomeApi,
        userProfileDataMapper: UserProfileDataMapper,
        productCategoryMapper: ProductCategoryMapper,
    ): HomeDataSource =
        HomeDataSourceRetrofitImpl(homeApi, userProfileDataMapper, productCategoryMapper)

    @Provides
    fun provideCategoryDataSource(
        categoryApi: CategoryApi,
        categoryDataMapper: CategoryDataMapper,
    ): CategoryDataSource =
        CategoryDataSourceRetrofitImpl(categoryApi, categoryDataMapper)
}