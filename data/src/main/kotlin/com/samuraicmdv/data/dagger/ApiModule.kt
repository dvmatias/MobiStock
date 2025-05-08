package com.samuraicmdv.data.dagger

import com.samuraicmdv.data.api.BrandApi
import com.samuraicmdv.data.api.CategoryApi
import com.samuraicmdv.data.api.UserApi
import com.samuraicmdv.data.api.LoginApi
import com.samuraicmdv.data.api.ProductApi
import com.samuraicmdv.data.api.SalesLedgeApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {
    @Provides
    @Singleton
    fun provideLoginApi(retrofit: Retrofit): LoginApi = retrofit.create(LoginApi::class.java)

    @Provides
    @Singleton
    fun provideUserApi(retrofit: Retrofit): UserApi = retrofit.create(UserApi::class.java)

    @Provides
    @Singleton
    fun provideCategoryApi(retrofit: Retrofit): CategoryApi = retrofit.create(CategoryApi::class.java)

    @Provides
    @Singleton
    fun provideBrandApi(retrofit: Retrofit): BrandApi = retrofit.create(BrandApi::class.java)

    @Provides
    @Singleton
    fun provideProductApi(retrofit: Retrofit): ProductApi = retrofit.create(ProductApi::class.java)

    @Provides
    @Singleton
    fun provideSalesLedgeApi(retrofit: Retrofit): SalesLedgeApi = retrofit.create(SalesLedgeApi::class.java)
}