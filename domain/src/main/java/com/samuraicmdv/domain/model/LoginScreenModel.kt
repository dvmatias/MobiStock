package com.samuraicmdv.domain.model

data class LoginScreenModel(
    val isLoading: Boolean,
    val userError: String? = null,
    val passwordError: String? = null
)
