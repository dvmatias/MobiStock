package com.samuraicmdv.domain.usecase

import com.samuraicmdv.domain.repository.LoginRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val loginRepository: LoginRepository,
) {

    operator fun invoke() {
        loginRepository.loginWithCredentials()
    }

}