package com.samuraicmdv.data.dagger

import com.samuraicmdv.data.repository.LoginRepositoryImpl
import com.samuraicmdv.domain.repository.LoginRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object LoginModule {

    @Provides
    fun provideLoginRepository(): LoginRepository = LoginRepositoryImpl()

}