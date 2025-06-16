package com.samuraicmdv.domain.repository

import com.samuraicmdv.domain.model.CreateProductResponseModel
import com.samuraicmdv.domain.model.ItemSummaryResponseModel
import com.samuraicmdv.domain.model.ProductDetailsResponseModel
import com.samuraicmdv.domain.util.ResponseWrapper

interface ItemRepository {
    /**
     * TODO
     *
     * @param itemId The ID of the item to retrieve details for.
     * @param storeId The ID of the store for which to retrieve item details.
     */
    suspend fun getItemSummary(
        itemId: Int? = null,
        itemCode: String? = null,
        storeId: Int? = null
    ): ItemSummaryResponseModel?

    /**
     * Fetch the item details in general using the item ID. The difference with
     * [ItemRepository.getItemSummary] lays in that the item information in this case doesn't
     * includes stock information data.
     *
     * @param productId The ID of the item to retrieve details for.
     */
    suspend fun getProductDetailsByIdGeneral(productId: Int): ProductDetailsResponseModel?

    /**
     * Fetch the item details for a specific store using the item code. The difference with
     * [ItemRepository.getProductDetailsByCodeGeneral] lays in that the item information includes stock information
     * data.
     *
     * @param productCode The code of the item to retrieve details for.
     * @param storeId The ID of the store for which to retrieve item details.
     */
    suspend fun getProductDetailsByCodeForStore(
        productCode: String,
        storeId: Int,
    ): ProductDetailsResponseModel?

    /**
     * Fetch the item details in general using the item code. The difference with
     * [ItemRepository.getProductDetailsByIdGeneral] lays in that the item information in this case doesn't
     * includes stock information data.
     *
     * @param productCode The code of the item to retrieve details for.
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