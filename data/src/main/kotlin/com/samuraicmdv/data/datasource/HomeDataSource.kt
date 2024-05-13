package com.samuraicmdv.data.datasource

import com.samuraicmdv.domain.model.ProductCategoriesResponseModel
import com.samuraicmdv.domain.model.UserProfileResponseModel
import com.samuraicmdv.domain.util.ResponseWrapper

/**
 * Interface Data Source - This class along with its implementations are in charge of originate data
 * that serves the Home screen.
 */
interface HomeDataSource {
    /**
     * Gets the current user profile
     *
     * @param userId User ID to fetch user's profile.
     */
    suspend fun getUserProfile(userId: Int): ResponseWrapper<UserProfileResponseModel>

    /**
     * Gets the current user profile
     *
     * @param storeId Store unique identifier.
     * @param all When 'true' fetches all categories including categories without stock for the
     * current store. When 'false' it will only fetch product categories with product in stock
     */
    suspend fun getProductCategories(
        storeId: Int,
        all: Boolean,
    ): ResponseWrapper<ProductCategoriesResponseModel>
}