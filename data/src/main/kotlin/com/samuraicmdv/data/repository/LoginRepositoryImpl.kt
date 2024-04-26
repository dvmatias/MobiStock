package com.samuraicmdv.data.repository

import com.samuraicmdv.domain.model.LoginScreenModel
import com.samuraicmdv.domain.model.UserCredentialsModel
import com.samuraicmdv.domain.repository.LoginRepository
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor() : LoginRepository {
    override fun loginWithCredentials(userCredentialsModel: UserCredentialsModel): LoginScreenModel {
        TODO()
    }
}