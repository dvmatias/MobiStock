package com.samuraicmdv.data.entity

import com.google.gson.annotations.SerializedName

data class GetCategoriesResponseEntity(
    @SerializedName("categories") val productCategories: List<CategoryEntity>? = null,
)

