package com.samuraicmdv.featurecategory.state

data class ProductUiData(
    val id: Int,
    val name: String? = null,
    val shortDescription: String? = null,
    val longDescription: String? = null,
    val model: String? = null,
    val code: String? = null,
    val sku: String? = null,
    val imageUrl: String? = null,
    val price: ProductPriceUiData? = null,
    val stock: ProductStockUiData? = null,
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

data class ProductStockUiData(
    val quantity: Int? = null,
    val low: Int? = null,
    val min: Int? = null,
)
