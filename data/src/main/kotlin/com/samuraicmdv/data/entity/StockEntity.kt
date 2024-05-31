package com.samuraicmdv.data.entity

import com.google.gson.annotations.SerializedName

data class StockEntity(
    @SerializedName("quantity") val quantity: Int? = null,
    @SerializedName("low") val low: Int? = null,
    @SerializedName("min") val min: Int? = null,
)