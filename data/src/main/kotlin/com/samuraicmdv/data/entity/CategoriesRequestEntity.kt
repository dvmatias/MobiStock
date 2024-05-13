package com.samuraicmdv.data.entity

import com.google.gson.annotations.SerializedName

data class CategoriesRequestEntity(
    @SerializedName("store_id") val storeId: Int,
    @SerializedName("all") val all: Boolean = true,
)
