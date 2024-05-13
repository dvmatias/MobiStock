package com.samuraicmdv.data.entity

import com.google.gson.annotations.SerializedName

data class ProductCategoriesResponseEntity(
    @SerializedName("categories") val productCategories: List<ProductCategoryEntity>? = null,
)

data class ProductCategoryEntity(
    @SerializedName("id") val id: Int? = null,
    @SerializedName("name") val name: String? = null,
    @SerializedName("logo_url") val logoUrl: String? = null,
    @SerializedName("image_url") val imageUrl: String? = null,
    @SerializedName("products_count") val productsCount: Int? = null,
    @SerializedName("products_quantity") val productsQuantity: Int? = null,
)
