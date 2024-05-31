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

}