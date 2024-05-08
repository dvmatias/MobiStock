package com.samuraicmdv.data.entity

import com.google.gson.annotations.SerializedName

data class UserEntity(
    @SerializedName("address")
    val address: UserAddressEntity? = null,
    @SerializedName("email")
    val email: String? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("logoUrl")
    val logoUrl: String? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("relatedUsers")
    val relatedUsers: List<UserEntity>? = null,
)
