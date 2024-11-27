package com.samuraicmdv.data.entity

import com.google.gson.annotations.SerializedName
import com.samuraicmdv.domain.model.PriceModel

/**
 * Data class that models a product price in the API response.
 */
data class PriceEntity(
    @SerializedName("selling") val selling: Double? = null,
    @SerializedName("cost") val cost: Double? = null,
    @SerializedName("f_currency_id") val currencyId: Int? = null,
    @SerializedName("f_store_id") val storeId: Int? = null,
    @SerializedName("preferred_margin") val preferredMargin: Int? = null,
) {
    fun toModel(): PriceModel {
        return PriceModel(
            selling = selling ?: 0.0,
            cost = cost ?: 0.0,
            currencyId = currencyId ?: 0,
            storeId = storeId ?: 0,
            preferredMargin = preferredMargin ?: 0,
        )
    }
}