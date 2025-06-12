package com.samuraicmdv.domain.repository

import com.samuraicmdv.domain.model.CreateProductResponseModel
import com.samuraicmdv.domain.model.ProductDetailsResponseModel
import com.samuraicmdv.domain.util.ResponseWrapper

interface ProductRepository {
    /**
     * Fetch the product details for a specific store using the product ID. The difference with
     * [ProductRepository.getProductDetailsByIdGeneral] lays in that the product information includes stock information
     * data.
     *
     * @param productId The ID of the product to retrieve details for.
     * @param storeId The ID of the store for which to retrieve product details.
     */
    suspend fun getProductDetailsByIdForStore(
        productId: Int,
        storeId: Int,
    ): ProductDetailsResponseModel?

    /**
     * Fetch the product details in general using the product ID. The difference with
     * [ProductRepository.getProductDetailsByIdForStore] lays in that the product information in this case doesn't
     * includes stock information data.
     *
     * @param productId The ID of the product to retrieve details for.
     */
    suspend fun getProductDetailsByIdGeneral(productId: Int): ProductDetailsResponseModel?

    /**
     * Fetch the product details for a specific store using the product code. The difference with
     * [ProductRepository.getProductDetailsByCodeGeneral] lays in that the product information includes stock information
     * data.
     *
     * @param productCode The code of the product to retrieve details for.
     * @param storeId The ID of the store for which to retrieve product details.
     */
    suspend fun getProductDetailsByCodeForStore(
        productCode: String,
        storeId: Int,
    ): ProductDetailsResponseModel?

    /**
     * Fetch the product details in general using the product code. The difference with
     * [ProductRepository.getProductDetailsByIdGeneral] lays in that the product information in this case doesn't
     * includes stock information data.
     *
     * @param productCode The code of the product to retrieve details for.
     */
    suspend fun getProductDetailsByCodeGeneral(productCode: String): ProductDetailsResponseModel?

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