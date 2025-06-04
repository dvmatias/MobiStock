package com.samuraicmdv.common.uidata

data class ProductUiData(
    val id: Int,
    val name: String? = null,
    val shortDescription: String? = null,
    val longDescription: String? = null,
    val model: String? = null,
    val code: String? = null,
    val sku: String? = null,
    val thumbnailUrl: String? = null,
    val imageUrls: List<String>? = null,
    val price: ProductPriceUiData? = null,
    val stock: ProductStockUiData? = null,
    val rating: Double? = null,
    val reviews: Int? = null,
    val isFavorite: Boolean? = null,
    val brand: ProductBrandUiData? = null,
)
