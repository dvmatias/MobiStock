package com.samuraicmdv.data.dagger

import com.samuraicmdv.data.mapper.LoginDataMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DataMapperModule {
    @Provides
    fun provideLoginDataMapper(): LoginDataMapper = LoginDataMapper
}