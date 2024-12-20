package com.samuraicmdv.data.entity

import com.google.gson.annotations.SerializedName
import com.samuraicmdv.domain.model.CategoryModel

/**
 * Data class that models a Category in the API response.
 */
data class CategoryEntity(
    @SerializedName("id") val id: Int? = null,
    @SerializedName("name") val name: String? = null,
    @SerializedName("description") val description: String? = null,
    @SerializedName("logo_url") val logoUrl: String? = null,
    @SerializedName("image_url") val imageUrl: String? = null,
    @SerializedName("products_count") val productsCount: Int? = null,
    @SerializedName("products_quantity") val productsQuantity: Int? = null,
) {
    fun toModel(): CategoryModel {
        return CategoryModel(
            id = id,
            name = name,
            description = description,
            logoUrl = logoUrl,
            imageUrl = imageUrl,
            productsCount = productsCount,
            productsQuantity = productsQuantity
        )
    }
}