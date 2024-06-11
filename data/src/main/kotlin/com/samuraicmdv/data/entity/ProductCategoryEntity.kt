package com.samuraicmdv.data.entity

import com.google.gson.annotations.SerializedName
import com.samuraicmdv.domain.model.CategoryModel

/**
 * Data class that models a specific Product Category in the API response.
 */
data class ProductCategoryEntity(
    @SerializedName("id") val id: Int? = null,
    @SerializedName("name") val name: String? = null,
    @SerializedName("description") val description: String? = null,
    @SerializedName("logo_url") val logoUrl: String? = null,
    @SerializedName("image_url") val imageUrl: String? = null,
) {
    fun toModel(): CategoryModel {
        return CategoryModel(
            id = id,
            name = name,
            description = description,
            logoUrl = logoUrl,
            imageUrl = imageUrl
        )
    }
}
