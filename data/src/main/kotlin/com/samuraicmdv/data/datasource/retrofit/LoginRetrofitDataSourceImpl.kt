package com.samuraicmdv.data.datasource.retrofit

import com.samuraicmdv.data.api.LoginApi
import com.samuraicmdv.data.datasource.LoginDataSource
import com.samuraicmdv.data.entity.LoginRequestEntity
import com.samuraicmdv.data.entity.LoginResponseEntity
import com.samuraicmdv.domain.util.ResponseFailure
import com.samuraicmdv.domain.util.ResponseWrapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Implementation Data Source - This class along is in charge of originate data that serves the
 * Login screen.
 *
 * @param loginApi Retrofit Service interface. Provides Login service operations.
 */
class LoginRetrofitDataSourceImpl @Inject constructor(
    private val loginApi: LoginApi,
) : LoginDataSource {
    override suspend fun login(
        username: String,
        password: String,
    ): ResponseWrapper<LoginResponseEntity> =
        withContext(Dispatchers.IO) {
            loginApi.login(LoginRequestEntity(username, password)).let { response ->
                if (response.isSuccessful && response.body() != null) {
                    ResponseWrapper.success(response.body())
                } else {
                    ResponseWrapper.error(null, ResponseFailure.ServerError("Login response failure."))
                }
            }
        }
}