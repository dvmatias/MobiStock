package com.samuraicmdv.data.mapper

import com.samuraicmdv.data.entity.ProductCategoriesResponseEntity
import com.samuraicmdv.data.entity.ProductCategoryEntity
import com.samuraicmdv.domain.base.DataMapper
import com.samuraicmdv.domain.model.ProductCategoriesResponseModel
import com.samuraicmdv.common.utils.ProductCategory
import com.samuraicmdv.domain.model.ProductCategoryModel

object ProductCategoryMapper :
    DataMapper<ProductCategoriesResponseEntity, ProductCategoriesResponseModel> {
    override fun entityToModel(
        entity: ProductCategoriesResponseEntity?,
    ): ProductCategoriesResponseModel =
        ProductCategoriesResponseModel(
            productCategories = transformProductCategories(entity?.productCategories)
        )

    private fun transformProductCategories(
        productCategories: List<ProductCategoryEntity>?,
    ): List<ProductCategoryModel> =
        productCategories?.map {
            ProductCategoryModel(
                id = it.id,
                type = getProductCategoryType(it.name),
                logoUrl = it.logoUrl,
                imageUrl = it.imageUrl,
                productsCount = it.productsCount,
                productsQuantity = it.productsQuantity,
            )
        }.orEmpty()

    private fun getProductCategoryType(productCategoryName: String?): ProductCategory =
        ProductCategory.entries.find {
            it.name == productCategoryName
        } ?: run {
            ProductCategory.UNKNOWN
        }

}