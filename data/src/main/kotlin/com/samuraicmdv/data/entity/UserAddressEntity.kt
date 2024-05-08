package com.samuraicmdv.data.entity

import com.google.gson.annotations.SerializedName

data class UserAddressEntity(
    @SerializedName("line")
    val line: String? = null,
    @SerializedName("city")
    val city: String? = null,
    @SerializedName("province")
    val province: String? = null,
    @SerializedName("country")
    val country: String? = null,
    @SerializedName("zipCode")
    val zipCode: String? = null,
)