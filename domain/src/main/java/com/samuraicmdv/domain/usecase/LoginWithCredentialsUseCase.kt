package com.samuraicmdv.domain.usecase

import com.samuraicmdv.common.ERROR_LOGIN_PASSWORD_EMPTY
import com.samuraicmdv.common.ERROR_LOGIN_UNKNOWN
import com.samuraicmdv.common.ERROR_LOGIN_USER_EMPTY
import com.samuraicmdv.domain.model.LoginErrorModel
import com.samuraicmdv.domain.model.LoginResponseModel
import com.samuraicmdv.domain.repository.LoginRepository
import javax.inject.Inject

class LoginWithCredentialsUseCase @Inject constructor(
    private val loginRepository: LoginRepository,
) {

    suspend operator fun invoke(params: Params): LoginResponseModel {
        val username = params.username
        val password = params.password
        return if (username.isNotEmpty() && password.isNotEmpty()) {
            val response = loginRepository.loginWithCredentials(username, password)
            if (response.isSuccess) {
                response.getOrNull() ?: LoginResponseModel(
                    errors = listOf(LoginErrorModel(ERROR_LOGIN_UNKNOWN))
                )
            } else {
                LoginResponseModel(errors = listOf(LoginErrorModel(ERROR_LOGIN_UNKNOWN)))
            }
        } else {
            mutableListOf<LoginErrorModel>().apply {
                if (!isValidCredential(username)) add(LoginErrorModel(ERROR_LOGIN_USER_EMPTY))
                if (!isValidCredential(password)) add(LoginErrorModel(ERROR_LOGIN_PASSWORD_EMPTY))
            }.run {
                LoginResponseModel(errors = this)
            }
        }
    }

    /**
     * [LoginWithCredentialsUseCase] use case class params
     */
    data class Params(val username: String, val password: String)

    private fun isValidCredential(credential: String): Boolean = credential.isNotEmpty()

}