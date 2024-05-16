package com.samuraicmdv.featureproductcategory.state

data class CategoryUiData(
    val id: String,
    val name: String,
    val description: String,
    val imageUrl: String,
    val productsCount: Int,
    val productsQuantity: Int,
)
