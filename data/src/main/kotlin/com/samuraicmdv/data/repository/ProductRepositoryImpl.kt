package com.samuraicmdv.data.repository

import com.samuraicmdv.data.datasource.ProductDataSource
import com.samuraicmdv.domain.model.CreateProductResponseModel
import com.samuraicmdv.domain.repository.ProductRepository
import com.samuraicmdv.domain.util.ResponseWrapper
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val productDataSource: ProductDataSource
) : ProductRepository {
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
        preferredMargin: Int?
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