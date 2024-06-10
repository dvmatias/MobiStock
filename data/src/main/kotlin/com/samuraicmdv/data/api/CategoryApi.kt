package com.samuraicmdv.data.api

import com.samuraicmdv.data.entity.GetCategoriesResponseEntity
import com.samuraicmdv.data.entity.GetCategoryResponseEntity
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Retrofit Service - This interface defines the API endpoints for Category resources.
 */
interface CategoryApi {

    /**
     * Get a category by its ID.
     */
    @GET("stock/category")
    suspend fun getCategoryByCategoryId(
        @Query("store_id") storeId: Int,
        @Query("category_id") categoryId: Int,
    ): Response<GetCategoryResponseEntity>

    /**
     * Get all categories.
     *
     * @param storeId The ID of the store.
     * @param all Whether to get all categories or get only the categories with products in stock (not empty in stock).
     */
    @GET("stock/categories")
    suspend fun getCategories(
        @Query("store_id") storeId: Int,
        @Query("all") all: Boolean,
    ): Response<GetCategoriesResponseEntity>
}