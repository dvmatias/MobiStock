package com.samuraicmdv.data.datasource.retrofit

import com.samuraicmdv.data.api.ProductApi
import com.samuraicmdv.data.datasource.ProductDataSource
import com.samuraicmdv.data.entity.CreateProductRequestEntity
import com.samuraicmdv.data.entity.PriceEntity
import com.samuraicmdv.data.mapper.ProductDataMapper
import com.samuraicmdv.domain.model.CreateProductResponseModel
import com.samuraicmdv.domain.util.ResponseFailure
import com.samuraicmdv.domain.util.ResponseWrapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ProductDataSourceRetrofitImpl @Inject constructor(
    private val productApi: ProductApi,
    private val mapper: ProductDataMapper,
) : ProductDataSource {

    override suspend fun createProduct(
        name: String,
        shortDescription: String,
        longDescription: String,
        code: String?,
        model: String?,
        categoryId: Int,
        brandId: Int,
        sku: String?,
        selling: Double?,
        cost: Double?,
        currencyId: Int?,
        storeId: Int?,
        preferredMargin: Int?
    ): ResponseWrapper<CreateProductResponseModel> =
        withContext(Dispatchers.IO) {
            productApi.createProduct(
                CreateProductRequestEntity(
                    name = name,
                    shortDescription = shortDescription,
                    longDescription = longDescription,
                    code = code,
                    model = model,
                    categoryId = categoryId,
                    brandId = brandId,
                    sku = sku,
                    price = PriceEntity(
                        selling = selling,
                        cost = cost,
                        currencyId = currencyId,
                        storeId = storeId,
                        preferredMargin = preferredMargin
                    )
                )
            ).let { response ->
                if (response.isSuccessful && response.body() != null) {
                    ResponseWrapper.success(mapper.entityToModel(response.body()))
                } else {
                    ResponseWrapper.error(
                        null,
                        ResponseFailure.ServerError("Create product response failure.")
                    )
                }
            }
        }

}