package com.samuraicmdv.data.entity

import com.google.gson.annotations.SerializedName

data class LoginResponseEntity(
    @SerializedName("meta")
    val meta: MetaEntity? = null,
    @SerializedName("userId")
    val userId: Int? = null
)

data class MetaEntity(
    @SerializedName("hasError")
    val hasError: Boolean? = null,
    @SerializedName("errors")
    val errors: List<ErrorEntity>? = null,
)

data class ErrorEntity(
    @SerializedName("code")
    val code: Int? = null,
    @SerializedName("description")
    val description: String? = null,
)
