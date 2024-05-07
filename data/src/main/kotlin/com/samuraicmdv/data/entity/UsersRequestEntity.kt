package com.samuraicmdv.data.entity

import com.google.gson.annotations.SerializedName

data class UsersRequestEntity(
    @SerializedName("userId")
    val userId: Int? = null,
)
