package com.samuraicmdv.data.entity

import com.google.gson.annotations.SerializedName

data class GetSalesLedgeResponseEntity (
    @SerializedName("meta")
    val meta: MetaEntity? = null,
    @SerializedName("sales_record")
    val salesLedge: SalesLedgeEntity? = null
)
