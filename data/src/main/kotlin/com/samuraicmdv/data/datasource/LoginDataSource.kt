package com.samuraicmdv.data.datasource

import com.samuraicmdv.domain.model.LoginResponseModel
import com.samuraicmdv.domain.util.ResponseWrapper

/**
 * Interface Data Source - This class along with its implementations are in charge of originate data
 * that serves the Login screen.
 */
interface LoginDataSource {

    /**
     * Triggers the service call to login a user.
     *
     * @param username Account user's name. It can be an email or name.
     * @param password Account user's password.
     */
    suspend fun login(
        username: String,
        password: String,
    ): ResponseWrapper<LoginResponseModel>
}