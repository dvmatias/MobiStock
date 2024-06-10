package com.samuraicmdv.data.entity

import com.google.gson.annotations.SerializedName

/**
 * Data class that models the API response for getting a Category.
 */
data class GetCategoryResponseEntity(
    @SerializedName("category") val category: CategoryEntity? = null,
    @SerializedName("brands") val brands: List<BrandEntity>? = null,
    @SerializedName("products") val products: List<ProductEntity>? = null,
)

