package com.samuraicmdv.data.dagger

import com.samuraicmdv.data.api.BrandApi
import com.samuraicmdv.data.api.CategoryApi
import com.samuraicmdv.data.api.LoginApi
import com.samuraicmdv.data.api.ProductApi
import com.samuraicmdv.data.api.SalesLedgeApi
import com.samuraicmdv.data.api.UserApi
import com.samuraicmdv.data.datasource.BrandDataSource
import com.samuraicmdv.data.datasource.CategoryDataSource
import com.samuraicmdv.data.datasource.ItemDataSource
import com.samuraicmdv.data.datasource.LoginDataSource
import com.samuraicmdv.data.datasource.SalesLedgerDataSource
import com.samuraicmdv.data.datasource.UserDataSource
import com.samuraicmdv.data.datasource.retrofit.BrandDataSourceRetrofitImpl
import com.samuraicmdv.data.datasource.retrofit.CategoryDataSourceRetrofitImpl
import com.samuraicmdv.data.datasource.retrofit.ItemDataSourceRetrofitImpl
import com.samuraicmdv.data.datasource.retrofit.LoginDataSourceRetrofitImpl
import com.samuraicmdv.data.datasource.retrofit.SalesLedgerDataSourceRetrofitImpl
import com.samuraicmdv.data.datasource.retrofit.UserDataSourceRetrofitImpl
import com.samuraicmdv.data.mapper.BrandEntityMapper
import com.samuraicmdv.data.mapper.CategoryEntityMapper
import com.samuraicmdv.data.mapper.CreateProductEntityMapper
import com.samuraicmdv.data.mapper.GetCategoriesResponseEntityMapper
import com.samuraicmdv.data.mapper.LoginEntityMapper
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
        productCategoryMapper: GetCategoriesResponseEntityMapper,
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
    ): ItemDataSource =
        ItemDataSourceRetrofitImpl(
            productApi,
            createProductDataMapper
        )

    @Provides
    fun provideSalesLedgeDataSource(api: SalesLedgeApi): SalesLedgerDataSource = SalesLedgerDataSourceRetrofitImpl(api)
}