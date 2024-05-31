package com.samuraicmdv.data.datasource.retrofit

import com.samuraicmdv.data.api.HomeApi
import com.samuraicmdv.data.datasource.HomeDataSource
import com.samuraicmdv.data.entity.UserProfileRequestEntity
import com.samuraicmdv.data.mapper.ProductCategoryMapper
import com.samuraicmdv.data.mapper.UserProfileDataMapper
import com.samuraicmdv.domain.model.ProductCategoriesResponseModel
import com.samuraicmdv.domain.util.ResponseFailure
import com.samuraicmdv.domain.util.ResponseWrapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Implementation Data Source - This class along is in charge of originate data that serves the
 * Login screen.
 *
 * @param homeApi Retrofit Service interface. Provides Login service operations.
 * @param userProfileMapper Mapper class for transforming service data later response into model layer response.
 */
class HomeDataSourceRetrofitImpl @Inject constructor(
    private val homeApi: HomeApi,
    private val userProfileMapper: UserProfileDataMapper,
) : HomeDataSource {
    override suspend fun getUserProfile(userId: Int) =
        withContext(Dispatchers.IO) {
            UserProfileRequestEntity(userId = userId).let { requestEntity ->
                homeApi.getProfile(requestEntity).let { serviceResponse ->
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