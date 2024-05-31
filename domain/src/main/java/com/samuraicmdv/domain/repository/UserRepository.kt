package com.samuraicmdv.domain.repository

import com.samuraicmdv.domain.model.UserProfileResponseModel
import com.samuraicmdv.domain.util.ResponseWrapper

/**
 * Interface - This repository provides a bridge for interactions between home flow and data layer.
 */
interface UserRepository {
    /**
     * Gets the current user's profile.
     *
     * @param userId User's unique identifier.
     */
    suspend fun getUserProfileByUserId(userId: Int): ResponseWrapper<UserProfileResponseModel>

}