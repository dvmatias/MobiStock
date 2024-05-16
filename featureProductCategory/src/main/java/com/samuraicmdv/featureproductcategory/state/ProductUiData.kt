package com.samuraicmdv.featureproductcategory.state

data class ProductUiData(
    val id: String,
    val name: String,
    val description: String,
    val imageUrl: String,
    val sellingPrice: Double,
    val costPrice: Double,
    val currency: String,
    val stock: Int,
    val rating: Double,
    val reviews: Int,
    val isFavorite: Boolean,
    val brand: ProductBrandUiData
)
