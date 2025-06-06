package com.samuraicmdv.domain.repository

import com.samuraicmdv.domain.model.CreateProductResponseModel
import com.samuraicmdv.domain.model.GetProductDetailsResponseModel
import com.samuraicmdv.domain.util.ResponseWrapper

interface ProductRepository {
    /**
     * Fetch the product details for a specific store. The difference with [ProductRepository.getProductDetailsGeneral]
     * lays in that the product information includes stock information data.
     *
     * @param productId The ID of the product to retrieve details for.
     * @param storeId The ID of the store for which to retrieve product details.
     */
    suspend fun getProductDetailsForStore(
        productId: Int,
        storeId: Int,
    ): ResponseWrapper<GetProductDetailsResponseModel>

    /**
     * Fetch the product details for a specific store. The difference with [ProductRepository.getProductDetailsForStore]
     * lays in that the product information in this case doesn't includes stock information data.
     *
     * @param productId The ID of the product to retrieve details for.
     */
    suspend fun getProductDetailsGeneral(productId: Int): ResponseWrapper<GetProductDetailsResponseModel>

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