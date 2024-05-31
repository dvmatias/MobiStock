package com.samuraicmdv.data.api

import com.samuraicmdv.data.entity.ProductBrandsResponseEntity
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Retrofit Service - Brands
 */
interface BrandApi {
    @GET("brands")
    suspend fun getBrands(
        @Query("store_id") storeId: Int
    ): Response<ProductBrandsResponseEntity>
}