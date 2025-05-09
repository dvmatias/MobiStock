package com.samuraicmdv.domain.model

data class ProductModel(
    val id: Int? = null,
    val name: String? = null,
    val shortDescription: String? = null,
    val longDescription: String? = null,
    val model: String? = null,
    val code: String? = null,
    val sku: String? = null,
    val thumbnailUrl: String? = null,
    val imageUrls: List<String>? = null,
    val categoryId: Int? = null,
    val stock: StockModel? = null,
    val productPrice: PriceModel? = null,
    val brand: BrandModel? = null,
)