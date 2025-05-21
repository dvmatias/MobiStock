package com.samuraicmdv.data.entity

import com.google.gson.annotations.SerializedName

data class ProductSubcategoryEntity(
    @SerializedName("id") val id: Int? = null,
    @SerializedName("name") val name: String? = null,
    @SerializedName("description") val description: String? = null,
    @SerializedName("logo_url") val logoUrl: String? = null,
    @SerializedName("image_url") val imageUrl: String? = null,
    @SerializedName("products_quantity") val productsQuantity: Int? = null,
)
