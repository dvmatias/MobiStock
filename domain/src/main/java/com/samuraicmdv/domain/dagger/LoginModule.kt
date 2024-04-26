package com.samuraicmdv.domain.dagger

import com.samuraicmdv.domain.repository.LoginRepository
import com.samuraicmdv.domain.usecase.LoginWithCredentialsUseCase
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object LoginModule {

    fun provideLoginUseCase(loginRepository: LoginRepository): LoginWithCredentialsUseCase =
        LoginWithCredentialsUseCase(loginRepository)

}