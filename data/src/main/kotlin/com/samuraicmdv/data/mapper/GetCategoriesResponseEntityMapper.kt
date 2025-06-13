package com.samuraicmdv.data.mapper

import com.samuraicmdv.common.utils.ProductCategoryType
import com.samuraicmdv.common.utils.ProductSubcategoryType
import com.samuraicmdv.data.entity.GetCategoriesResponseEntity
import com.samuraicmdv.data.entity.ProductCategoryEntity
import com.samuraicmdv.domain.base.EntityMapper
import com.samuraicmdv.domain.model.GetCategoriesResponseModel
import com.samuraicmdv.domain.model.ProductCategoryModel
import com.samuraicmdv.domain.model.ProductSubcategoryModel

object GetCategoriesResponseEntityMapper :
    EntityMapper<GetCategoriesResponseEntity, GetCategoriesResponseModel> {
    override fun map(
        entity: GetCategoriesResponseEntity?,
    ): GetCategoriesResponseModel =
        GetCategoriesResponseModel(
            productCategories = transformProductCategories(entity?.productCategories)
        )

    private fun transformProductCategories(
        productCategories: List<ProductCategoryEntity>?,
    ): List<ProductCategoryModel> =
        productCategories?.map {
            ProductCategoryModel(
                id = it.id,
                type = getProductCategoryType(it.name),
                productsQuantity = null,
                subcategories = it.subcategories?.map { subcategory ->
                    ProductSubcategoryModel(
                        id = subcategory.id,
                        type = getProductSubcategoryType(subcategory.name),
                        name = subcategory.name,
                        description = subcategory.description,
                    )
                },
                description = it.description,
                name = it.name
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