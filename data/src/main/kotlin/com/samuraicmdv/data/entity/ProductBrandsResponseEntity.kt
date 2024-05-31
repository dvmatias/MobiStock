package com.samuraicmdv.data.entity

import com.google.gson.annotations.SerializedName

data class ProductBrandsResponseEntity(
    @SerializedName("brands") val brands: List<ProductBrandEntity>? = null,
)
