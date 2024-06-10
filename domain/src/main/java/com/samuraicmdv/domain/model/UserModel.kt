package com.samuraicmdv.domain.model

data class UserModel(
    val id: Int,
    val address: UserAddressModel? = null,
    val email: String? = null,
    val logoUrl: String? = null,
    val branchType: String? = null,
    val name: String? = null,
    val isCurrentSelected: Boolean? = null,
    val isAdmin: Boolean? = null,
    val relatedUsers: List<UserModel>? = null,
)