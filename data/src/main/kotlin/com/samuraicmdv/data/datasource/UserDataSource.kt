package com.samuraicmdv.data.datasource

import com.samuraicmdv.domain.model.UserProfileResponseModel
import com.samuraicmdv.domain.util.ResponseWrapper

/**
 * Interface Data Source - This class along with its implementations are in charge of originate data
 * that serves the Home screen.
 */
interface UserDataSource {
    /**
     * Gets the current user profile
     *
     * @param userId User ID to fetch user's profile.
     */
    suspend fun getUserProfileByUserId(userId: Int): ResponseWrapper<UserProfileResponseModel>

}