package com.samuraicmdv.data.entity

import com.google.gson.annotations.SerializedName

data class UserProfileResponseEntity(
    @SerializedName("meta")
    val meta: MetaEntity? = null,
    @SerializedName("user")
    val user: UserEntity? = null
)
