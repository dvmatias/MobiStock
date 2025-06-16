package com.samuraicmdv.data.entity

import com.google.gson.annotations.SerializedName

/**
 * Data class that models a item in the API response.
 */
data class ItemSummaryEntity(
    @SerializedName("id") val id: Int? = null,
    @SerializedName("name") val name: String? = null,
    @SerializedName("code") val code: String? = null,
    @SerializedName("code_description") val codeDescription: String? = null,
    @SerializedName("model") val model: String? = null,
    @SerializedName("short_description") val shortDescription: String? = null,
    @SerializedName("selling_price") val price: Double? = null,
    @SerializedName("thumbnail_url") val thumbnailUrl: String? = null,
    @SerializedName("brand_name") val brandName: String? = null,
    @SerializedName("brand_logo_url") val brandLogoUrl: String? = null,
    @SerializedName("category_name") val categoryName: String? = null,
    @SerializedName("subcategory_name") val subcategoryName: String? = null,
    @SerializedName("stock") val stock: Int? = null,
)