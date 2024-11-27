package com.samuraicmdv.data.entity

import com.google.gson.annotations.SerializedName
import com.samuraicmdv.domain.model.BrandModel

/**
 * Data class that models a product brand in the API response.
 */
data class BrandEntity(
    @SerializedName("id") val id: Int? = null,
    @SerializedName("name") val name: String? = null,
    @SerializedName("logo_url") val logoUrl: String? = null,
) {
    fun toModel(): BrandModel =
        BrandModel(
            id = id ?: 0,
            name = name ?: "",
            logoUrl = logoUrl ?: "",
        )
}