package com.samuraicmdv.data.entity

import com.google.gson.annotations.SerializedName
import java.math.BigDecimal
import java.util.Date

data class SalesLedgeEntity(
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("f_store_id")
    val storeId: Int? = null,
    @SerializedName("date")
    val date: Date? = null,
    @SerializedName("opening_time")
    val openingTime: Date? = null,
    @SerializedName("closing_time")
    val closingTime: Int? = null,
    @SerializedName("f_open_seller_id")
    val openSellerId: Int? = null,
    @SerializedName("f_close_seller_id")
    val closeSellerId: Int? = null,
    @SerializedName("total")
    val total: BigDecimal? = null,
    @SerializedName("discount")
    val discount: BigDecimal? = null,
    @SerializedName("sales")
    val sales: List<SaleEntity>? = null,
)
