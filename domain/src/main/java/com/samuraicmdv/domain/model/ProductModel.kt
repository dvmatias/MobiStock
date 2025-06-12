package com.samuraicmdv.domain.model

data class ProductModel(
    val id: Int? = null,
    val brandId: Int? = null,
    val categoryId: Int? = null,
    val code: String? = null,
    val imageUrls: List<String>? = null,
    val longDescription: String? = null,
    val model: String? = null,
    val name: String? = null,
    val productPrice: PriceModel? = null,
    val shortDescription: String? = null,
    val sku: String? = null,
    val stock: StockModel? = null,
    val subcategoryId: Int? = null,
    val thumbnailUrl: String? = null,
)