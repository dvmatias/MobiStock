package com.samuraicmdv.domain.model

data class LoginResponseModel(
    val userId: Int? = null,
    val errors: List<LoginErrorModel>? = null,
) {
    val hasErrors: Boolean = !errors.isNullOrEmpty()
}

data class LoginErrorModel(
    val code: Int? = null,
    val description: String? = null,
)
