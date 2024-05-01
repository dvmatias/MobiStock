package com.samuraicmdv.data.api

import com.samuraicmdv.data.entity.LoginRequestEntity
import com.samuraicmdv.data.entity.LoginResponseEntity
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * Retrofit Service - Login
 */
interface LoginApi {
    @POST(LOGIN_PATH)
    suspend fun login(
        @Body body: LoginRequestEntity,
    ): Response<LoginResponseEntity>

    companion object {
        private const val LOGIN_PATH = "login"
    }
}