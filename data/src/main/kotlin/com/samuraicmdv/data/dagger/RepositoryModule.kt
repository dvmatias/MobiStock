package com.samuraicmdv.data.dagger

import com.samuraicmdv.data.datasource.retrofit.LoginRetrofitDataSourceImpl
import com.samuraicmdv.data.repository.LoginRepositoryImpl
import com.samuraicmdv.domain.repository.LoginRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    fun provideLoginRepository(loginDataSource: LoginRetrofitDataSourceImpl): LoginRepository =
        LoginRepositoryImpl(loginDataSource)
}