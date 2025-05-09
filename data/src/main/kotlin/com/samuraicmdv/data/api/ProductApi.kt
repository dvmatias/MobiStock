package com.samuraicmdv.data.api

import com.samuraicmdv.data.entity.CreateProductRequestEntity
import com.samuraicmdv.data.entity.CreateProductResponseEntity
import com.samuraicmdv.data.entity.GetProductDetailsResponseEntity
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

/**
 * Retrofit Service - Product
 */
interface ProductApi {

    @POST("$PATH/$CREATE_PATH")
    suspend fun createProduct(
        @Body body: CreateProductRequestEntity,
    ): Response<CreateProductResponseEntity>

    @GET("$PATH/$DETAILS_PATH")
    suspend fun getProductDetails(
        @Query("id") productId: Int,
        @Query("store_id") storeId: Int? = null,
    ): Response<GetProductDetailsResponseEntity>

    companion object {
        private const val PATH = "product"
        private const val CREATE_PATH = "create"
        private const val DETAILS_PATH = "details"
    }
}