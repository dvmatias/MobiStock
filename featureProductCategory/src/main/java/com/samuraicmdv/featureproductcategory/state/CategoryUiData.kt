package com.samuraicmdv.featureproductcategory.state

data class CategoryUiData(
    val id: Int,
    val name: String,
    val description: String,
    val logoUrl: String,
    val imageUrl: String,
    val productsCount: Int,
    val productsQuantity: Int,
)
