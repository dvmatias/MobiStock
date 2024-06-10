package com.samuraicmdv.data.entity

import com.google.gson.annotations.SerializedName

/**
 * Data class that models a product price in the API response.
 */
data class PriceEntity(
    @SerializedName("selling") val selling: Double? = null,
    @SerializedName("cost") val cost: Double? = null,
    @SerializedName("f_currency_id") val currencyId: Int? = null,
    @SerializedName("f_store_id") val storeId: Int? = null,
    @SerializedName("preferred_margin") val preferredMargin: Int? = null,
)