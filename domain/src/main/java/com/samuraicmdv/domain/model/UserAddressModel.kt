package com.samuraicmdv.domain.model

data class UserAddressModel(
    val city: String? = null,
    val country: String? = null,
    val line: String? = null,
    val province: String? = null,
    val zipCode: String? = null,
)