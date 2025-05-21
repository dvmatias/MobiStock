package com.samuraicmdv.domain.model

import com.samuraicmdv.common.utils.ProductCategoryType
import com.samuraicmdv.common.utils.ProductSubcategoryType

data class ProductCategoriesResponseModel(
    val productCategories: List<ProductCategoryModel>? = null,
)

data class ProductCategoryModel(
    val id: Int? = null,
    val type: ProductCategoryType? = null,
    val logoUrl: String? = null,
    val imageUrl: String? = null,
    val productsCount: Int? = null,
    val productsQuantity: Int? = null,
    val subcategories: List<ProductSubcategoryModel>? = null,
)

data class ProductSubcategoryModel(
    val id: Int? = null,
    val type: ProductSubcategoryType? = null,
    val logoUrl: String? = null,
    val imageUrl: String? = null,
    val productsQuantity: Int? = null,
)
