package com.samuraicmdv.data.entity

import com.google.gson.annotations.SerializedName
import com.samuraicmdv.domain.model.StockModel

data class StockEntity(
    @SerializedName("quantity") val quantity: Int? = null,
    @SerializedName("low_flag") val low: Int? = null,
    @SerializedName("min_flag") val min: Int? = null,
) {
    fun toModel(): StockModel {
        return StockModel(
            quantity = quantity ?: 0,
            low = low ?: 0,
            min = min ?: 0,
        )
    }
}