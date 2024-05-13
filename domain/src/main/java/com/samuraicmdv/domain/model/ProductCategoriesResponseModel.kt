package com.samuraicmdv.domain.model

data class ProductCategoriesResponseModel(
    val productCategories: List<ProductCategoryModel>,
)

data class ProductCategoryModel(
    val id: Int? = null,
    val type: ProductCategory? = null,
    val logoUrl: String? = null,
    val imageUrl: String? = null,
    val productsCount: Int? = null,
    val productsQuantity: Int? = null,
)
