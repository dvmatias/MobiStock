package com.samuraicmdv.data.entity

import com.google.gson.annotations.SerializedName

data class GetBrandsResponseEntity(
    @SerializedName("brands") val brands: List<BrandEntity>? = null,
)
