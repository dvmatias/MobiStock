package com.samuraicmdv.domain.model

data class UserProfileResponseModel(
    val user: UserModel? = null
)

data class UserModel(
    val id: Int,
    val address: UserAddressModel? = null,
    val email: String? = null,
    val logoUrl: String? = null,
    val name: String? = null,
    val isCurrentSelected: Boolean? = null,
    val relatedUsers: List<UserModel>? = null,
)

data class UserAddressModel(
    val city: String? = null,
    val country: String? = null,
    val line: String? = null,
    val province: String? = null,
    val zipCode: String? = null,
)
