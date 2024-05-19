package com.samuraicmdv.featureproductcategory.state

data class CategoryUiData(
    val id: Int,
    val nameResId: Int,
    val description: String,
    val logoUrl: String,
    val imageUrl: String,
    val productsCount: Int,
    val productsQuantity: Int,
)
