package com.samuraicmdv.domain.repository

import com.samuraicmdv.domain.model.CreateProductResponseModel
import com.samuraicmdv.domain.model.GetProductDetailsResponseModel
import com.samuraicmdv.domain.util.ResponseWrapper

interface ProductRepository {
    suspend fun getProductDetails(
        productId: Int,
        storeId: Int? = null,
    ): ResponseWrapper<GetProductDetailsResponseModel>

    suspend fun createProduct(
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
    ): ResponseWrapper<CreateProductResponseModel>
}