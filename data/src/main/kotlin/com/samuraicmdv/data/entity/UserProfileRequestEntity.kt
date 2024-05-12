package com.samuraicmdv.data.entity

import com.google.gson.annotations.SerializedName

data class UserProfileRequestEntity(
    @SerializedName("userId") val userId: Int? = null,
)
