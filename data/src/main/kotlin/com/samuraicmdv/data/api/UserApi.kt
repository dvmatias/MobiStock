package com.samuraicmdv.data.api

import com.samuraicmdv.data.entity.GetUserProfileRequestEntity
import com.samuraicmdv.data.entity.GetUserProfileResponseEntity
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * Retrofit Service - Home
 */
interface UserApi {
    @POST("profile")
    suspend fun getProfile(
        @Body body: GetUserProfileRequestEntity,
    ): Response<GetUserProfileResponseEntity>

}