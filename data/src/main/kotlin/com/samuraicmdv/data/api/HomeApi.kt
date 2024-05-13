package com.samuraicmdv.data.api

import com.samuraicmdv.data.entity.ProductCategoriesResponseEntity
import com.samuraicmdv.data.entity.UserProfileRequestEntity
import com.samuraicmdv.data.entity.UserProfileResponseEntity
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

/**
 * Retrofit Service - Home
 */
interface HomeApi {
    @POST("profile")
    suspend fun getProfile(
        @Body body: UserProfileRequestEntity,
    ): Response<UserProfileResponseEntity>

    @GET("stock/categories")
    suspend fun getCategories(
        @Query("store_id") storeId: Int,
        @Query("all") all: Boolean,
    ): Response<ProductCategoriesResponseEntity>

}