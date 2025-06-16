package com.samuraicmdv.data.datasource.retrofit

import com.samuraicmdv.data.api.ProductApi
import com.samuraicmdv.data.datasource.ItemDataSource
import com.samuraicmdv.data.entity.CreateProductRequestEntity
import com.samuraicmdv.data.entity.ItemSummaryResponseEntity
import com.samuraicmdv.data.entity.PriceEntity
import com.samuraicmdv.data.mapper.CreateProductEntityMapper
import com.samuraicmdv.domain.model.CreateProductResponseModel
import com.samuraicmdv.domain.util.ResponseFailure
import com.samuraicmdv.domain.util.ResponseWrapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ItemDataSourceRetrofitImpl @Inject constructor(
    private val productApi: ProductApi,
    private val createProductDataMapper: CreateProductEntityMapper
) : ItemDataSource {

    override suspend fun getProductSummary(
        itemId: Int?,
        itemCode: String?,
        storeId: Int?
    ): ResponseWrapper<ItemSummaryResponseEntity> =
        withContext(Dispatchers.IO) {
            productApi.getProductSummary(itemId, itemCode, storeId).let { response ->
                if (response.isSuccessful && response.body() != null) {
                    ResponseWrapper.success(response.body())
                } else {
                    ResponseWrapper.error(
                        null,
                        ResponseFailure.ServerError("Get item details response failure.")
                    )
                }
            }
        }

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
        preferredMargin: Int?,
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
                    ResponseWrapper.success(createProductDataMapper.map(response.body()))
                } else {
                    ResponseWrapper.error(
                        null,
                        ResponseFailure.ServerError("Create item response failure.")
                    )
                }
            }
        }

}