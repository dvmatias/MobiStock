package com.samuraicmdv.domain.model

data class UserProfileResponseModel(
    val user: UserModel? = null
)

data class UserModel(
    val address: UserAddressModel? = null,
    val email: String? = null,
    val id: Int? = null,
    val logoUrl: String? = null,
    val name: String? = null,
    val relatedUsers: List<UserModel>? = null,
)

data class UserAddressModel(
    val city: String? = null,
    val country: String? = null,
    val line: String? = null,
    val province: String? = null,
    val zipCode: String? = null,
)