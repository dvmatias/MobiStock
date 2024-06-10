package com.samuraicmdv.data.entity

import com.google.gson.annotations.SerializedName

data class CreateProductRequestEntity(
    @SerializedName("name") val name: String,
    @SerializedName("short_description") val shortDescription: String,
    @SerializedName("long_description") val longDescription: String,
    @SerializedName("code") val code: String? = null,
    @SerializedName("model") val model: String? = null,
    @SerializedName("category_id") val categoryId: Int,
    @SerializedName("brand_id") val brandId: Int,
    @SerializedName("sku") val sku: String? = null,
    @SerializedName("price") val price: PriceEntity,
)