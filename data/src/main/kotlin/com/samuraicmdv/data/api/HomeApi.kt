package com.samuraicmdv.data.api

import com.samuraicmdv.data.entity.CategoriesRequestEntity
import com.samuraicmdv.data.entity.ProductCategoriesResponseEntity
import com.samuraicmdv.data.entity.UserProfileRequestEntity
import com.samuraicmdv.data.entity.UserProfileResponseEntity
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * Retrofit Service - Home
 */
interface HomeApi {
    @POST(PROFILE_PATH)
    suspend fun getProfile(
        @Body body: UserProfileRequestEntity,
    ): Response<UserProfileResponseEntity>

    @POST(CATEGORIES_PATH)
    suspend fun getCategories(
        @Body body: CategoriesRequestEntity
    ): Response<ProductCategoriesResponseEntity>

    companion object {
        private const val PROFILE_PATH = "profile"
        private const val CATEGORIES_PATH = "stock/categories"
    }
}