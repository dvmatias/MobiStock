package com.samuraicmdv.data.api

import com.samuraicmdv.data.entity.UsersRequestEntity
import com.samuraicmdv.data.entity.UsersResponseEntity
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * Retrofit Service - Home
 */
interface HomeApi {
    @POST(USERS_PATH)
    suspend fun relatedUsers(
        @Body body: UsersRequestEntity,
    ): Response<UsersResponseEntity>

    companion object {
        private const val USERS_PATH = "users"
    }
}