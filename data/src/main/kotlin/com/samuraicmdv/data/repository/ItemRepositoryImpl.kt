package com.samuraicmdv.data.repository

import com.samuraicmdv.data.datasource.ItemDataSource
import com.samuraicmdv.data.mapper.ItemSummaryResponseEntityMapper
import com.samuraicmdv.data.mapper.ProductDetailsResponseEntityMapper
import com.samuraicmdv.domain.model.CreateProductResponseModel
import com.samuraicmdv.domain.model.ItemSummaryResponseModel
import com.samuraicmdv.domain.model.ProductDetailsResponseModel
import com.samuraicmdv.domain.repository.ItemRepository
import com.samuraicmdv.domain.util.ResponseWrapper
import javax.inject.Inject

class ItemRepositoryImpl @Inject constructor(
    private val itemDataSource: ItemDataSource,
    private val itemSummaryResponseEntityMapper: ItemSummaryResponseEntityMapper,
    private val getProductDetailsDataMapper: ProductDetailsResponseEntityMapper
) : ItemRepository {

    override suspend fun getItemSummary(
        itemId: Int?,
        itemCode: String?,
        storeId: Int?
    ): ItemSummaryResponseModel? {
        val responseEntity =
            itemDataSource.getProductSummary(itemId = itemId, itemCode = itemCode, storeId = storeId)
        return itemSummaryResponseEntityMapper.map(responseEntity.getOrNull())
    }

    override suspend fun getProductDetailsByIdGeneral(
        productId: Int
    ): ProductDetailsResponseModel? {
        TODO()
    }

    override suspend fun getProductDetailsByCodeForStore(
        productCode: String,
        storeId: Int
    ): ProductDetailsResponseModel? {
        TODO()
    }

    override suspend fun getProductDetailsByCodeGeneral(
        productCode: String
    ): ProductDetailsResponseModel? {
        TODO()
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
        itemDataSource.createProduct(
            name = name,
            shortDescription = shortDescription,
            longDescription = longDescription,
            code = code,
            model = model,
            categoryId = categoryId,
            brandId = brandId,
            sku = sku,
            selling = selling,
            cost = cost,
            currencyId = currencyId,
            storeId = storeId,
            preferredMargin = preferredMargin
        )
}