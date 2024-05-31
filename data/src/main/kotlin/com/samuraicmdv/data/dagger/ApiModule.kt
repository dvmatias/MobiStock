package com.samuraicmdv.data.dagger

import com.samuraicmdv.data.api.BrandApi
import com.samuraicmdv.data.api.CategoryApi
import com.samuraicmdv.data.api.HomeApi
import com.samuraicmdv.data.api.LoginApi
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
    fun provideHomeApi(retrofit: Retrofit): HomeApi = retrofit.create(HomeApi::class.java)

    @Provides
    @Singleton
    fun provideCategoryApi(retrofit: Retrofit): CategoryApi = retrofit.create(CategoryApi::class.java)

    @Provides
    @Singleton
    fun provideBrandApi(retrofit: Retrofit): BrandApi = retrofit.create(BrandApi::class.java)
}