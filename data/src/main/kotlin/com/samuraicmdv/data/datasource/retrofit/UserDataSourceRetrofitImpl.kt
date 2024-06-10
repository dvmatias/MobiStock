package com.samuraicmdv.data.datasource.retrofit

import com.samuraicmdv.data.api.UserApi
import com.samuraicmdv.data.datasource.UserDataSource
import com.samuraicmdv.data.entity.GetUserProfileRequestEntity
import com.samuraicmdv.data.mapper.UserProfileDataMapper
import com.samuraicmdv.domain.util.ResponseFailure
import com.samuraicmdv.domain.util.ResponseWrapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Implementation Data Source - This class along is in charge of originate data that serves the
 * Login screen.
 *
 * @param userApi Retrofit Service interface. Provides Login service operations.
 * @param userProfileMapper Mapper class for transforming service data later response into model layer response.
 */
class UserDataSourceRetrofitImpl @Inject constructor(
    private val userApi: UserApi,
    private val userProfileMapper: UserProfileDataMapper,
) : UserDataSource {

    override suspend fun getUserProfileByUserId(userId: Int) =
        withContext(Dispatchers.IO) {
            GetUserProfileRequestEntity(userId = userId).let { requestEntity ->
                userApi.getProfile(requestEntity).let { serviceResponse ->
                    if (serviceResponse.isSuccessful) {
                        ResponseWrapper.success(
                            data = userProfileMapper.entityToModel(serviceResponse.body())
                        )
                    } else {
                        ResponseWrapper.error(
                            responseFailure = ResponseFailure.ServerError("Get user profile failure")
                        )
                    }
                }
            }
        }

}