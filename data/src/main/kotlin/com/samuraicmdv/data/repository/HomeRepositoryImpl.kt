package com.samuraicmdv.data.repository

import com.samuraicmdv.data.datasource.HomeDataSource
import com.samuraicmdv.domain.model.UserProfileResponseModel
import com.samuraicmdv.domain.repository.HomeRepository
import com.samuraicmdv.domain.util.ResponseWrapper
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val homeDataSource: HomeDataSource
) : HomeRepository {
    override suspend fun getProfile(userId: Int): ResponseWrapper<UserProfileResponseModel> =
        homeDataSource.getUserProfile(userId)
}