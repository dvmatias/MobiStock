package com.samuraicmdv.domain.repository

import com.samuraicmdv.domain.model.ProductCategoriesResponseModel
import com.samuraicmdv.domain.model.UserProfileResponseModel
import com.samuraicmdv.domain.util.ResponseWrapper

/**
 * Interface - This repository provides a bridge for interactions between home flow and data layer.
 */
interface HomeRepository {
    /**
     * Gets the current user's profile.
     *
     * @param userId User's unique identifier.
     */
    suspend fun getProfile(userId: Int): ResponseWrapper<UserProfileResponseModel>

    /**
     * Gets the product categories.
     *
     * @param storeId Store's unique identifier.
     * @param all Boolean flag to get all categories.
     */
    suspend fun getProductCategories(
        storeId: Int,
        all: Boolean,
    ): ResponseWrapper<ProductCategoriesResponseModel>
}