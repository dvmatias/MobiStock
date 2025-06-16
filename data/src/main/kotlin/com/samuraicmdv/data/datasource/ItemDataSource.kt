package com.samuraicmdv.data.datasource

import com.samuraicmdv.data.entity.ItemSummaryResponseEntity
import com.samuraicmdv.domain.model.CreateProductResponseModel
import com.samuraicmdv.domain.util.ResponseWrapper

interface ItemDataSource {
    /**
     *
     * @param itemId The ID of the item to retrieve details for.
     * @param storeId The ID of the store for which to retrieve item details.
     */
    suspend fun getProductSummary(
        itemId: Int? = null,
        itemCode: String? = null,
        storeId: Int? = null
    ): ResponseWrapper<ItemSummaryResponseEntity>


    /**
     * Triggers the service call to create a item.
     */
    suspend fun createProduct(
        name: String,
        shortDescription: String,
        longDescription: String,
        code: String? = null,
        model: String? = null,
        categoryId: Int,
        brandId: Int,
        sku: String? = null,
        selling: Double? = null,
        cost: Double? = null,
        currencyId: Int? = null,
        storeId: Int? = null,
        preferredMargin: Int? = null,
    ): ResponseWrapper<CreateProductResponseModel>
}