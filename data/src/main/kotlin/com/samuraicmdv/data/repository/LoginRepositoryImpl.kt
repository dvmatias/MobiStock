package com.samuraicmdv.data.repository

import com.samuraicmdv.data.datasource.retrofit.LoginDataSourceRetrofitImpl
import com.samuraicmdv.domain.model.LoginResponseModel
import com.samuraicmdv.domain.repository.LoginRepository
import com.samuraicmdv.domain.util.ResponseWrapper
import javax.inject.Inject

/**
 * Implementation - This repository provides a bridge for interactions between login flow and data
 * layer.
 *
 * @param loginDataSource Data source to provide interactions with data source layer classes.
 */
class LoginRepositoryImpl @Inject constructor(
    private val loginDataSource: LoginDataSourceRetrofitImpl,
) : LoginRepository {
    override suspend fun loginWithCredentials(
        userName: String,
        password: String,
    ): ResponseWrapper<LoginResponseModel> = loginDataSource.login(userName, password)
}