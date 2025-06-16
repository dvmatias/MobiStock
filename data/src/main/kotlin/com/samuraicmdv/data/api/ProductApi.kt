package com.samuraicmdv.data.api

import com.samuraicmdv.data.entity.CreateProductRequestEntity
import com.samuraicmdv.data.entity.CreateProductResponseEntity
import com.samuraicmdv.data.entity.ItemSummaryResponseEntity
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

    @GET("$PATH/$SUMMARY_PATH")
    suspend fun getProductSummary(
        @Query("id") productId: Int? = null,
        @Query("code") productCode: String? = null,
        @Query("store_id") storeId: Int? = null
    ): Response<ItemSummaryResponseEntity>

    companion object {
        private const val PATH = "item"
        private const val CREATE_PATH = "create"
        private const val DETAILS_PATH = "details"
        private const val SUMMARY_PATH = "summary"
    }
}