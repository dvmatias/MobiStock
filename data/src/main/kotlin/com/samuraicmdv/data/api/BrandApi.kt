package com.samuraicmdv.data.api

import com.samuraicmdv.data.entity.GetBrandsResponseEntity
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Retrofit Service - This interface defines the API endpoints for Brand resources.
 */
interface BrandApi {
    @GET("brands")
    suspend fun getBrands(
        @Query("store_id") storeId: Int
    ): Response<GetBrandsResponseEntity>
}