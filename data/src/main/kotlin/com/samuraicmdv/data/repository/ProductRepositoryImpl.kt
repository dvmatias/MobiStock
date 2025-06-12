package com.samuraicmdv.data.repository

import com.samuraicmdv.data.datasource.ProductDataSource
import com.samuraicmdv.data.mapper.ProductDetailsResponseEntityMapper
import com.samuraicmdv.domain.model.CreateProductResponseModel
import com.samuraicmdv.domain.model.ProductDetailsResponseModel
import com.samuraicmdv.domain.repository.ProductRepository
import com.samuraicmdv.domain.util.ResponseWrapper
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val productDataSource: ProductDataSource,
    private val getProductDetailsDataMapper: ProductDetailsResponseEntityMapper
) : ProductRepository {

    override suspend fun getProductDetailsByIdForStore(
        productId: Int,
        storeId: Int,
    ): ProductDetailsResponseModel?{
        val responseEntity = productDataSource.getProductDetailsByIdForStore(productId, storeId)
        return getProductDetailsDataMapper.map(responseEntity.getOrNull())
    }

    override suspend fun getProductDetailsByIdGeneral(
        productId: Int
    ): ProductDetailsResponseModel?{
        val responseEntity = productDataSource.getProductDetailsByIdGeneral(productId)
        return getProductDetailsDataMapper.map(responseEntity.getOrNull())
    }

    override suspend fun getProductDetailsByCodeForStore(
        productCode: String,
        storeId: Int
    ): ProductDetailsResponseModel? {
        val responseEntity = productDataSource.getProductDetailsByCodeForStore(productCode, storeId)
        return getProductDetailsDataMapper.map(responseEntity.getOrNull())
    }

    override suspend fun getProductDetailsByCodeGeneral(
        productCode: String
    ): ProductDetailsResponseModel? {
        val responseEntity = productDataSource.getProductDetailsByCodeGeneral(productCode)
        return getProductDetailsDataMapper.map(responseEntity.getOrNull())
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
        productDataSource.createProduct(
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