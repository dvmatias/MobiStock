package com.samuraicmdv.domain.repository

import com.samuraicmdv.domain.model.LoginScreenModel
import com.samuraicmdv.domain.model.UserCredentialsModel

interface LoginRepository {

    fun loginWithCredentials(userCredentialsModel: UserCredentialsModel): LoginScreenModel

}