package com.samuraicmdv.data.mapper

import com.samuraicmdv.common.utils.ProductCategoryType
import com.samuraicmdv.common.utils.ProductSubcategoryType
import com.samuraicmdv.data.entity.GetCategoriesResponseEntity
import com.samuraicmdv.data.entity.ProductCategoryEntity
import com.samuraicmdv.domain.base.DataMapper
import com.samuraicmdv.domain.model.ProductCategoriesResponseModel
import com.samuraicmdv.domain.model.ProductCategoryModel
import com.samuraicmdv.domain.model.ProductSubcategoryModel

object ProductCategoryMapper :
    DataMapper<GetCategoriesResponseEntity, ProductCategoriesResponseModel> {
    override fun entityToModel(
        entity: GetCategoriesResponseEntity?,
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
                productsQuantity = it.productsQuantity,
                subcategories = it.subcategories?.map { subcategory ->
                    ProductSubcategoryModel(
                        id = subcategory.id,
                        type = getProductSubcategoryType(subcategory.name),
                        logoUrl = subcategory.logoUrl,
                        imageUrl = subcategory.imageUrl,
                        productsQuantity = subcategory.productsQuantity
                    )
                }
            )
        }.orEmpty()

    private fun getProductCategoryType(productCategoryName: String?): ProductCategoryType =
        ProductCategoryType.entries.find {
            it.name == productCategoryName
        } ?: run {
            ProductCategoryType.UNKNOWN
        }

    private fun getProductSubcategoryType(productSubcategoryName: String?): ProductSubcategoryType =
        ProductSubcategoryType.entries.find {
            it.name == productSubcategoryName
        } ?: run {
            ProductSubcategoryType.UNKNOWN
        }

}