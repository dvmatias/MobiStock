package com.samuraicmdv.data.datasource.retrofit

import com.samuraicmdv.data.api.LoginApi
import com.samuraicmdv.data.datasource.LoginDataSource
import com.samuraicmdv.data.entity.LoginRequestEntity
import com.samuraicmdv.data.mapper.LoginDataMapper
import com.samuraicmdv.domain.model.LoginResponseModel
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
class LoginDataSourceRetrofitImpl @Inject constructor(
    private val loginApi: LoginApi,
    private val mapper: LoginDataMapper,
) : LoginDataSource {
    override suspend fun login(
        username: String,
        password: String,
    ): ResponseWrapper<LoginResponseModel> =
        withContext(Dispatchers.IO) {
            loginApi.login(LoginRequestEntity(username, password)).let { response ->
                if (response.isSuccessful && response.body() != null) {
                    ResponseWrapper.success(mapper.entityToModel(response.body()))
                } else {
                    ResponseWrapper.error(
                        null,
                        ResponseFailure.ServerError("Login response failure.")
                    )
                }
            }
        }
}