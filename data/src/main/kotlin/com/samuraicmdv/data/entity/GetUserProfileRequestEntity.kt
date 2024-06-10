package com.samuraicmdv.data.entity

import com.google.gson.annotations.SerializedName

data class GetUserProfileRequestEntity(
    @SerializedName("userId") val userId: Int? = null,
)
