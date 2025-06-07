package com.samuraicmdv.data.datasource

import com.samuraicmdv.data.entity.GetProductDetailsResponseEntity
import com.samuraicmdv.domain.model.CreateProductResponseModel
import com.samuraicmdv.domain.util.ResponseWrapper

interface ProductDataSource {
    /**
     * Triggers the service call to get product details for a specific store  using the product ID. The difference with
     * [ProductDataSource.getProductDetailsByIdGeneral] lays in that the product information includes stock information data.
     *
     * @param productId The ID of the product to retrieve details for.
     * @param storeId The ID of the store for which to retrieve product details.
     */
    suspend fun getProductDetailsByIdForStore(
        productId: Int,
        storeId: Int,
    ): ResponseWrapper<GetProductDetailsResponseEntity>

    /**
     * Triggers the service call to get product details in general using the product ID. The difference with
     * [ProductDataSource.getProductDetailsByIdForStore] lays in that the product information doesn't includes stock
     * information data since the call is not tied to any store.
     *
     * @param productId The ID of the product to retrieve details for.
     */
    suspend fun getProductDetailsByIdGeneral(productId: Int, ): ResponseWrapper<GetProductDetailsResponseEntity>

    /**
     * Triggers the service call to get product details for a specific store  using the product code. The difference with
     * [ProductDataSource.getProductDetailsByCodeGeneral] lays in that the product information includes stock information data.
     *
     * @param productCode The code of the product to retrieve details for.
     * @param storeId The ID of the store for which to retrieve product details.
     */
    suspend fun getProductDetailsByCodeForStore(
        productCode: String,
        storeId: Int,
    ): ResponseWrapper<GetProductDetailsResponseEntity>

    /**
     * Triggers the service call to get product details in general using the product code. The difference with
     * [ProductDataSource.getProductDetailsByCodeForStore] lays in that the product information doesn't includes stock
     * information data since the call is not tied to any store.
     *
     * @param productCode The code of the product to retrieve details for.
     */
    suspend fun getProductDetailsByCodeGeneral(productCode: String): ResponseWrapper<GetProductDetailsResponseEntity>

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