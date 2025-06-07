package com.samuraicmdv.data.dagger

import com.samuraicmdv.data.mapper.BrandEntityMapper
import com.samuraicmdv.data.mapper.CategoryEntityMapper
import com.samuraicmdv.data.mapper.CreateProductEntityMapper
import com.samuraicmdv.data.mapper.GetProductDetailsEntityMapper
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
abstract class DataMapperModule {

    companion object {
        @Provides
        fun provideLoginDataMapper(): LoginEntityMapper = LoginEntityMapper

        @Provides
        fun provideUserProfileMapper(): UserProfileEntityMapper = UserProfileEntityMapper

        @Provides
        fun provideProductCategoryMapper(): ProductCategoryMapper = ProductCategoryMapper

        @Provides
        fun provideCategoryDataMapper(): CategoryEntityMapper = CategoryEntityMapper

        @Provides
        fun provideBrandDataMapper(): BrandEntityMapper = BrandEntityMapper

        @Provides
        fun provideCreateProductDataMapper(): CreateProductEntityMapper = CreateProductEntityMapper

        @Provides
        fun provideSalesLedgeDataMapper(): SalesLedgeEntityMapper = SalesLedgeEntityMapper

        @Provides
        fun provideGetProductDetailsEntityMapper(): GetProductDetailsEntityMapper {
            return GetProductDetailsEntityMapper()
        }
    }
}