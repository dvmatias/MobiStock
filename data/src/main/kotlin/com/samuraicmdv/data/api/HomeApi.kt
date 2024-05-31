package com.samuraicmdv.data.api

import com.samuraicmdv.data.entity.UserProfileRequestEntity
import com.samuraicmdv.data.entity.UserProfileResponseEntity
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * Retrofit Service - Home
 */
interface HomeApi {
    @POST("profile")
    suspend fun getProfile(
        @Body body: UserProfileRequestEntity,
    ): Response<UserProfileResponseEntity>

}