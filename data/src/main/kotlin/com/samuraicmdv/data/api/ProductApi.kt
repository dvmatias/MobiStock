package com.samuraicmdv.data.api

import com.samuraicmdv.data.entity.CreateProductRequestEntity
import com.samuraicmdv.data.entity.CreateProductResponseEntity
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * Retrofit Service - Product
 */
interface ProductApi {

    @POST("$PATH/$CREATE_PATH")
    suspend fun createProduct(
        @Body body: CreateProductRequestEntity,
    ): Response<CreateProductResponseEntity>

    companion object {
        private const val PATH = "product"
        private const val CREATE_PATH = "create"
    }
}