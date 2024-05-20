package com.samuraicmdv.featureproductcategory.state

data class ProductUiData(
    val id: Int,
    val name: String? = null,
    val description: String? = null,
    val model: String? = null,
    val code: String? = null,
    val sku: String? = null,
    val imageUrl: String? = null,
    val price: ProductPriceUiData? = null,
    val stock: Int? = null,
    val rating: Double? = null,
    val reviews: Int? = null,
    val isFavorite: Boolean? = null,
    val brand: ProductBrandUiData? = null,
)

data class ProductPriceUiData(
    val sellingPrice: Double? = null,
    val costPrice: Double? = null,
    val currency: String? = null,
)
