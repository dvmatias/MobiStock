package com.samuraicmdv.featurelogin.compose

import androidx.lifecycle.ViewModel
import com.samuraicmdv.domain.usecase.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
) : ViewModel() {

    fun doLogin() {
        loginUseCase()
    }

}