package com.samuraicmdv.data.entity

import com.google.gson.annotations.SerializedName

data class LoginRequestEntity(
    @SerializedName("username") val username: String? = null,
    @SerializedName("password") val password: String? = null,
)
