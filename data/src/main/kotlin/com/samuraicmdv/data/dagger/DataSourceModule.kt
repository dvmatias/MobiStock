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
import com.samuraicmdv.data.mapper.BrandDataMapper
import com.samuraicmdv.data.mapper.CategoryDataMapper
import com.samuraicmdv.data.mapper.CreateProductDataMapper
import com.samuraicmdv.data.mapper.GetProductDetailsDataMapper
import com.samuraicmdv.data.mapper.LoginDataMapper
import com.samuraicmdv.data.mapper.ProductCategoryMapper
import com.samuraicmdv.data.mapper.SalesLedgeDataMapper
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
    fun provideUserDataSourceRetrofit(
        userApi: UserApi,
        userProfileDataMapper: UserProfileDataMapper,
    ): UserDataSource =
        UserDataSourceRetrofitImpl(userApi, userProfileDataMapper)

    @Provides
    fun provideCategoryDataSource(
        categoryApi: CategoryApi,
        categoryDataMapper: CategoryDataMapper,
        productCategoryMapper: ProductCategoryMapper,
    ): CategoryDataSource =
        CategoryDataSourceRetrofitImpl(categoryApi, categoryDataMapper, productCategoryMapper)

    @Provides
    fun provideBrandDataSource(
        brandApi: BrandApi,
        brandDataMapper: BrandDataMapper,
    ): BrandDataSource =
        BrandDataSourceRetrofitImpl(brandApi, brandDataMapper)

    @Provides
    fun provideProductDataSource(
        productApi: ProductApi,
        createProductDataMapper: CreateProductDataMapper,
        getProductDetailsDataMapper: GetProductDetailsDataMapper,
    ): ProductDataSource =
        ProductDataSourceRetrofitImpl(
            productApi,
            createProductDataMapper,
            getProductDetailsDataMapper
        )

    @Provides
    fun provideSalesLedgeDataSource(
        api: SalesLedgeApi,
        salesLedgeDataMapper: SalesLedgeDataMapper,
    ): SalesLedgeDataSource =
        SalesLedgeDataSourceRetrofitImpl(
            api,
            salesLedgeDataMapper
        )
}