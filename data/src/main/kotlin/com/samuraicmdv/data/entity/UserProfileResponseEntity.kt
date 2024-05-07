package com.samuraicmdv.data.entity

import com.google.gson.annotations.SerializedName

data class UserProfileResponseEntity(
    @SerializedName("meta")
    val meta: MetaEntity? = null,
    @SerializedName("userId")
    val user: UserEntity? = null
)
