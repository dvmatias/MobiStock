package com.samuraicmdv.featurelogin.state

data class LoginScreenState(
    val isLoading: Boolean = false,
    val userError: String? = null,
    val passwordError: String? = null,
)
