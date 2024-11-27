package com.samuraicmdv.data.datasource

import com.samuraicmdv.domain.model.CreateProductResponseModel
import com.samuraicmdv.domain.model.GetProductDetailsResponseModel
import com.samuraicmdv.domain.util.ResponseWrapper

interface ProductDataSource {

    suspend fun getProductDetails(
        productId: Int,
        storeId: Int? = null,
    ): ResponseWrapper<GetProductDetailsResponseModel>

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
        selling: Double? = null,
        cost: Double? = null,
        currencyId: Int? = null,
        storeId: Int? = null,
        preferredMargin: Int? = null,
    ): ResponseWrapper<CreateProductResponseModel>
}