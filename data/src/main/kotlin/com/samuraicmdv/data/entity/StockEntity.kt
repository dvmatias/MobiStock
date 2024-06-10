package com.samuraicmdv.data.entity

import com.google.gson.annotations.SerializedName
import com.samuraicmdv.domain.model.ProductStockModel

data class StockEntity(
    @SerializedName("quantity") val quantity: Int? = null,
    @SerializedName("low") val low: Int? = null,
    @SerializedName("min") val min: Int? = null,
) {
    fun toModel(): ProductStockModel? {
        return ProductStockModel(
            quantity = quantity ?: 0,
            low = low ?: 0,
            min = min ?: 0,
        )
    }
}