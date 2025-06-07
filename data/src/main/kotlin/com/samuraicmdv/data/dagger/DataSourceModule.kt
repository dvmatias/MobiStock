package com.samuraicmdv.data.dagger

import com.samuraicmdv.data.api.BrandApi
import com.samuraicmdv.data.api.CategoryApi
import com.samuraicmdv.data.api.LoginApi
import com.samuraicmdv.data.api.ProductApi
import com.samuraicmdv.data.api.SalesLedgeApi
import com.samuraicmdv.data.api.UserApi
import com.samuraicmdv.data.datasource.BrandDataSource
import com.samuraicmdv.data.datasource.CategoryDataSource
import com.samuraicmdv.data.datasource.LoginDataSource
import com.samuraicmdv.data.datasource.ProductDataSource
import com.samuraicmdv.data.datasource.SalesLedgeDataSource
import com.samuraicmdv.data.datasource.UserDataSource
import com.samuraicmdv.data.datasource.retrofit.BrandDataSourceRetrofitImpl
import com.samuraicmdv.data.datasource.retrofit.CategoryDataSourceRetrofitImpl
import com.samuraicmdv.data.datasource.retrofit.LoginDataSourceRetrofitImpl
import com.samuraicmdv.data.datasource.retrofit.ProductDataSourceRetrofitImpl
import com.samuraicmdv.data.datasource.retrofit.SalesLedgeDataSourceRetrofitImpl
import com.samuraicmdv.data.datasource.retrofit.UserDataSourceRetrofitImpl
import com.samuraicmdv.data.mapper.BrandEntityMapper
import com.samuraicmdv.data.mapper.CategoryEntityMapper
import com.samuraicmdv.data.mapper.CreateProductEntityMapper
import com.samuraicmdv.data.mapper.LoginEntityMapper
import com.samuraicmdv.data.mapper.ProductCategoryMapper
import com.samuraicmdv.data.mapper.SalesLedgeEntityMapper
import com.samuraicmdv.data.mapper.UserProfileEntityMapper
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
        dataMapper: LoginEntityMapper,
    ): LoginDataSource = LoginDataSourceRetrofitImpl(loginApi, dataMapper)

    @Provides
    fun provideUserDataSourceRetrofit(
        userApi: UserApi,
        userProfileDataMapper: UserProfileEntityMapper,
    ): UserDataSource =
        UserDataSourceRetrofitImpl(userApi, userProfileDataMapper)

    @Provides
    fun provideCategoryDataSource(
        categoryApi: CategoryApi,
        categoryDataMapper: CategoryEntityMapper,
        productCategoryMapper: ProductCategoryMapper,
    ): CategoryDataSource =
        CategoryDataSourceRetrofitImpl(categoryApi, categoryDataMapper, productCategoryMapper)

    @Provides
    fun provideBrandDataSource(
        brandApi: BrandApi,
        brandDataMapper: BrandEntityMapper,
    ): BrandDataSource =
        BrandDataSourceRetrofitImpl(brandApi, brandDataMapper)

    @Provides
    fun provideProductDataSource(
        productApi: ProductApi,
        createProductDataMapper: CreateProductEntityMapper,
    ): ProductDataSource =
        ProductDataSourceRetrofitImpl(
            productApi,
            createProductDataMapper
        )

    @Provides
    fun provideSalesLedgeDataSource(
        api: SalesLedgeApi,
        salesLedgeDataMapper: SalesLedgeEntityMapper,
    ): SalesLedgeDataSource =
        SalesLedgeDataSourceRetrofitImpl(
            api,
            salesLedgeDataMapper
        )
}