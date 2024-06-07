package com.samuraicmdv.data.datasource

import com.samuraicmdv.domain.model.CreateProductResponseModel
import com.samuraicmdv.domain.util.ResponseWrapper

interface ProductDataSource {
    /**
     * Triggers the service call to create a product.
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
        selling: String? = null,
        cost: String? = null,
        currencyId: String? = null,
        storeId: String? = null,
        preferredMargin: Int? = null,
    ): ResponseWrapper<CreateProductResponseModel>
}