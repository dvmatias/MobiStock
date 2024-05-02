package com.samuraicmdv.domain.model

/**
 * Model data object - Models the login request.
 *
 * @param username Account email or user name.
 * @param password Account password.
 */
data class UserCredentialsModel(
    val username: String? = null,
    val password: String? = null
)
