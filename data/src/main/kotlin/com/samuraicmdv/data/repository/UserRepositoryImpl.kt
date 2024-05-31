package com.samuraicmdv.data.repository

import com.samuraicmdv.data.datasource.UserDataSource
import com.samuraicmdv.domain.model.UserProfileResponseModel
import com.samuraicmdv.domain.repository.UserRepository
import com.samuraicmdv.domain.util.ResponseWrapper
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userDataSource: UserDataSource,
) : UserRepository {

    override suspend fun getUserProfileByUserId(
        userId: Int
    ): ResponseWrapper<UserProfileResponseModel> =
        userDataSource.getUserProfileByUserId(userId)

}