package com.samuraicmdv.featurelogin

import com.samuraicmdv.featurelogin.data.UserCredentialsUiData

sealed class PresentationEvent {
    data class Login(val userCredentials: UserCredentialsUiData): PresentationEvent()
    data object ForgotPassword: PresentationEvent()
    data object SignUp: PresentationEvent()
}