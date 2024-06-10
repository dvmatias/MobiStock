package com.samuraicmdv.data.datasource.retrofit

import com.samuraicmdv.data.api.BrandApi
import com.samuraicmdv.data.datasource.BrandDataSource
import com.samuraicmdv.data.mapper.BrandDataMapper
import com.samuraicmdv.domain.model.GetBrandsResponseModel
import com.samuraicmdv.domain.util.ResponseFailure
import com.samuraicmdv.domain.util.ResponseWrapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class BrandDataSourceRetrofitImpl @Inject constructor(
    private val brandApi: BrandApi,
    private val brandDataMapper: BrandDataMapper,
) : BrandDataSource {

    override suspend fun getBrands(storeId: Int): ResponseWrapper<GetBrandsResponseModel> =
        withContext(Dispatchers.IO) {
            brandApi.getBrands(
                storeId = storeId
            ).let { serviceResponse ->
                if (serviceResponse.isSuccessful) {
                    ResponseWrapper.success(
                        data = brandDataMapper.entityToModel(serviceResponse.body())
                    )
                } else {
                    ResponseWrapper.error(
                        responseFailure = ResponseFailure.ServerError("Get product brands failure")
                    )
                }
            }
        }

}