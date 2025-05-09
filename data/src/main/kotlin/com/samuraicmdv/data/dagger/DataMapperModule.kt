package com.samuraicmdv.data.dagger

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
object DataMapperModule {
    @Provides
    fun provideLoginDataMapper(): LoginDataMapper = LoginDataMapper

    @Provides
    fun provideUserProfileMapper(): UserProfileDataMapper = UserProfileDataMapper

    @Provides
    fun provideProductCategoryMapper(): ProductCategoryMapper = ProductCategoryMapper

    @Provides
    fun provideCategoryDataMapper(): CategoryDataMapper = CategoryDataMapper

    @Provides
    fun provideBrandDataMapper(): BrandDataMapper = BrandDataMapper

    @Provides
    fun provideCreateProductDataMapper(): CreateProductDataMapper = CreateProductDataMapper

    @Provides
    fun provideGetProductDetailsDataMapper(): GetProductDetailsDataMapper =
        GetProductDetailsDataMapper

    @Provides
    fun provideSalesLedgeDataMapper(): SalesLedgeDataMapper =
        SalesLedgeDataMapper
}