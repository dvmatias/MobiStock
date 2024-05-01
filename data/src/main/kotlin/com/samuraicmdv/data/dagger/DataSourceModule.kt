package com.samuraicmdv.data.dagger

import com.samuraicmdv.data.api.LoginApi
import com.samuraicmdv.data.datasource.LoginDataSource
import com.samuraicmdv.data.datasource.retrofit.LoginRetrofitDataSourceImpl
import com.samuraicmdv.data.mapper.LoginDataMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {
    @Provides
    fun provideLoginRetrofitDataSource(
        loginApi: LoginApi,
        dataMapper: LoginDataMapper,
    ): LoginDataSource =
        LoginRetrofitDataSourceImpl(loginApi, dataMapper)
}