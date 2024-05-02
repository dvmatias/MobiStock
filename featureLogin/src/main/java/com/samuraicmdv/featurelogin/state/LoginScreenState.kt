package com.samuraicmdv.featurelogin.state

data class LoginScreenState(
    val isLoading: Boolean = false,
    val userError: Int? = null,
    val passwordError: Int? = null,
)
