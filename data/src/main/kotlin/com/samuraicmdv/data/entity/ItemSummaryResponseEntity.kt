package com.samuraicmdv.data.entity

import com.google.gson.annotations.SerializedName

data class ItemSummaryResponseEntity(
    @SerializedName("meta") val meta: MetaEntity? = null,
    @SerializedName("item") val item: ItemSummaryEntity? = null,
)
