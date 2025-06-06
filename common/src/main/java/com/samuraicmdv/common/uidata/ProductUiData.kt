package com.samuraicmdv.common.uidata

data class ProductUiData(
    val id: Int,
    val brand: ProductBrandUiData? = null,
    val code: String? = null,
    val imageUrls: List<String>? = null,
    val isFavorite: Boolean? = null,
    val longDescription: String? = null,
    val model: String? = null,
    val name: String? = null,
    val price: ProductPriceUiData? = null,
    val productCategoryName: String? = null,
    val productSubcategoryName: String? = null,
    val rating: Double? = null,
    val reviews: Int? = null,
    val shortDescription: String? = null,
    val sku: String? = null,
    val stock: ProductStockUiData? = null,
    val thumbnailUrl: String? = null,
)
