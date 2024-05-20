package com.samuraicmdv.featureproductcategory.state

data class ProductUiData(
    val id: Int,
    val name: String,
    val description: String,
    val model: String,
    val code: String,
    val sku: String,
    val imageUrl: String,
    val price: ProductPriceUiData,
    val stock: Int,
    val rating: Double,
    val reviews: Int,
    val isFavorite: Boolean,
    val brand: ProductBrandUiData
)

data class ProductPriceUiData(
    val sellingPrice: Double,
    val costPrice: Double,
    val currency: String,
)
