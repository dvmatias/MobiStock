package com.samuraicmdv.domain.model

import com.samuraicmdv.common.utils.ProductCategory

data class CategoryModel(
    val id: Int?,
    val type: ProductCategory? = null,
    val name: String?,
    val description: String? = null,
    val logoUrl: String? = null,
    val imageUrl: String? = null,
    val productsCount: Int? = null,
    val productsQuantity: Int? = null,
)