package com.samuraicmdv.domain.usecase

import com.samuraicmdv.domain.model.LoginScreenModel
import com.samuraicmdv.domain.model.UserCredentialsModel
import com.samuraicmdv.domain.repository.LoginRepository
import kotlinx.coroutines.delay
import javax.inject.Inject

class LoginWithCredentialsUseCase @Inject constructor(
    private val loginRepository: LoginRepository,
) {

    suspend operator fun invoke(params: Params): LoginScreenModel {
        //loginRepository.loginWithCredentials(params.userCredentialsModel)
        delay(5000L)
        return LoginScreenModel(false)
    }

    data class Params(val userCredentialsModel: UserCredentialsModel)

}