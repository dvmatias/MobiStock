package com.samuraicmdv.data.api

import com.samuraicmdv.data.entity.CategoryResponseEntity
import com.samuraicmdv.data.entity.ProductCategoriesResponseEntity
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Retrofit Service - Category
 */
interface CategoryApi {
    @GET("stock/category")
    suspend fun getCategory(
        @Query("store_id") storeId: Int,
        @Query("category_id") categoryId: Int,
    ): Response<CategoryResponseEntity>

    @GET("stock/categories")
    suspend fun getCategories(
        @Query("store_id") storeId: Int,
        @Query("all") all: Boolean,
    ): Response<ProductCategoriesResponseEntity>
}