package com.samuraicmdv.domain.model

import com.samuraicmdv.common.utils.ProductCategoryType

data class ProductCategoryModel(
    val id: Int?,
    val description: String? = null,
    val name: String?,
    val productsQuantity: Int? = null,
    val subcategories: List<ProductSubcategoryModel>? = null,
    val type: ProductCategoryType? = null,
)