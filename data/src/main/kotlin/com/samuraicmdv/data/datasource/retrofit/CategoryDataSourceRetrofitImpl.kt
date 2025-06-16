package com.samuraicmdv.data.datasource.retrofit

import com.samuraicmdv.data.api.CategoryApi
import com.samuraicmdv.data.datasource.CategoryDataSource
import com.samuraicmdv.data.mapper.CategoryEntityMapper
import com.samuraicmdv.data.mapper.GetCategoriesResponseEntityMapper
import com.samuraicmdv.domain.model.CategoryResponseModel
import com.samuraicmdv.domain.model.GetCategoriesResponseModel
import com.samuraicmdv.domain.util.ResponseFailure
import com.samuraicmdv.domain.util.ResponseWrapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CategoryDataSourceRetrofitImpl @Inject constructor(
    private val categoryApi: CategoryApi,
    private val categoryDataMapper: CategoryEntityMapper,
    private val productCategoryMapper: GetCategoriesResponseEntityMapper,
) : CategoryDataSource {
    override suspend fun getCategory(storeId: Int, categoryId: Int): ResponseWrapper<CategoryResponseModel> =
        withContext(Dispatchers.IO) {
            categoryApi.getCategoryByCategoryId(storeId, categoryId).let { serviceResponse ->
                if (serviceResponse.isSuccessful) {
                    ResponseWrapper.success(
                        data = categoryDataMapper.map(serviceResponse.body())
                    )
                } else {
                    ResponseWrapper.error(
                        responseFailure = ResponseFailure.ServerError("Get category failure")
                    )
                }
            }
        }


    override suspend fun getProductCategories(
        storeId: Int,
        all: Boolean,
    ): ResponseWrapper<GetCategoriesResponseModel> =
        withContext(Dispatchers.IO) {
            categoryApi.getCategories(
                storeId = storeId,
                all = all
            ).let { serviceResponse ->
                if (serviceResponse.isSuccessful) {
                    ResponseWrapper.success(
                        data = productCategoryMapper.map(serviceResponse.body())
                    )
                } else {
                    ResponseWrapper.error(
                        responseFailure = ResponseFailure.ServerError("Get item categories failure")
                    )
                }
            }
        }
}