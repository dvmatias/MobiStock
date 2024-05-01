package com.samuraicmdv.domain.repository

import com.samuraicmdv.domain.model.LoginResponseModel
import com.samuraicmdv.domain.util.ResponseWrapper

/**
 * Interface - This repository provides a bridge for interactions between login flow and data layer.
 */
interface LoginRepository {
    /**
     * Login the user using credentials.
     *
     * @param
     * @param
     * @return A login screen model object.
     */
    suspend fun loginWithCredentials(
        userName: String,
        password: String,
    ): ResponseWrapper<LoginResponseModel>
}