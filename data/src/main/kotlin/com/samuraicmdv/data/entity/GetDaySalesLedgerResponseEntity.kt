package com.samuraicmdv.data.entity

import com.google.gson.annotations.SerializedName

data class GetDaySalesLedgerResponseEntity (
    @SerializedName("meta")
    val meta: MetaEntity? = null,
    @SerializedName("sales_record")
    val salesLedger: SalesLedgeEntity? = null
)
