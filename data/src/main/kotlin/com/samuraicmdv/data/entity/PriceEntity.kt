package com.samuraicmdv.data.entity

import com.google.gson.annotations.SerializedName

/**
 * Data class that models a product price in the API response.
 */
data class PriceEntity(
    @SerializedName("selling") val selling: String? = null,
    @SerializedName("cost") val cost: String? = null,
    @SerializedName("f_currency_id") val currencyId: String? = null,
    @SerializedName("f_store_id") val storeId: String? = null,
    @SerializedName("preferred_margin") val preferredMargin: Int? = null,
)