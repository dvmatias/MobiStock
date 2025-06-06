package com.samuraicmdv.data.datasource

import com.samuraicmdv.domain.model.CreateProductResponseModel
import com.samuraicmdv.domain.model.GetProductDetailsResponseModel
import com.samuraicmdv.domain.util.ResponseWrapper

interface ProductDataSource {
    /**
     * Triggers the service call to get product details for a specific store. The difference with
     * [ProductDataSource.getProductDetailsGeneral] lays in that the product information includes stock information data.
     *
     * @param productId The ID of the product to retrieve details for.
     * @param storeId The ID of the store for which to retrieve product details.
     */
    suspend fun getProductDetailsForStore(
        productId: Int,
        storeId: Int,
    ): ResponseWrapper<GetProductDetailsResponseModel>

    /**
     * Triggers the service call to get product details for a specific store. The difference with
     * [ProductDataSource.getProductDetailsForStore] lays in that the product information doesn't includes stock
     * information data since the call is not tied to any store.
     *
     * @param productId The ID of the product to retrieve details for.
     */
    suspend fun getProductDetailsGeneral(
        productId: Int,
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