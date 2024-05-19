package com.samuraicmdv.data.datasource.retrofit

import com.samuraicmdv.data.api.CategoryApi
import com.samuraicmdv.data.datasource.CategoryDataSource
import com.samuraicmdv.data.mapper.CategoryDataMapper
import com.samuraicmdv.domain.model.CategoryResponseModel
import com.samuraicmdv.domain.util.ResponseFailure
import com.samuraicmdv.domain.util.ResponseWrapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CategoryDataSourceRetrofitImpl @Inject constructor(
    private val categoryApi: CategoryApi,
    private val categoryDataMapper: CategoryDataMapper
) : CategoryDataSource {
    override suspend fun getCategory(storeId: Int, categoryId: Int): ResponseWrapper<CategoryResponseModel> =
        withContext(Dispatchers.IO) {
            categoryApi.getCategory(storeId, categoryId).let { serviceResponse ->
                if (serviceResponse.isSuccessful) {
                    ResponseWrapper.success(
                        data = categoryDataMapper.entityToModel(serviceResponse.body())
                    )
                } else {
                    ResponseWrapper.error(
                        responseFailure = ResponseFailure.ServerError("Get category failure")
                    )
                }
            }
        }
}