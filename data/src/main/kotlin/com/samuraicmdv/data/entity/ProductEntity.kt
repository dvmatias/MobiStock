package com.samuraicmdv.data.entity

import com.google.gson.annotations.SerializedName

/**
 * Data class that models a product in the API response.
 */
data class ProductEntity(
    @SerializedName("id") val id: Int? = null,
    @SerializedName("name") val name: String? = null,
    @SerializedName("short_description") val shortDescription: String? = null,
    @SerializedName("long_description") val longDescription: String? = null,
    @SerializedName("model") val model: String? = null,
    @SerializedName("code") val code: String? = null,
    @SerializedName("sku") val sku: String? = null,
    @SerializedName("thumbnail_url") val thumbnailUrl: String? = null,
    @SerializedName("image_urls") val imageUrls: List<String>? = null,
    @SerializedName("brand") val brand: BrandEntity? = null,
    @SerializedName("category_id") val categoryId: Int? = null,
    @SerializedName("stock") val stock: StockEntity? = null,
    @SerializedName("price") val productPrice: PriceEntity? = null,
)