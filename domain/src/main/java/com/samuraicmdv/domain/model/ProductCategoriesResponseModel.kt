package com.samuraicmdv.domain.model

import com.samuraicmdv.common.utils.ProductCategory

data class ProductCategoriesResponseModel(
    val productCategories: List<ProductCategoryModel>? = null,
)

data class ProductCategoryModel(
    val id: Int? = null,
    val type: ProductCategory? = null,
    val logoUrl: String? = null,
    val imageUrl: String? = null,
    val productsCount: Int? = null,
    val productsQuantity: Int? = null,
)
