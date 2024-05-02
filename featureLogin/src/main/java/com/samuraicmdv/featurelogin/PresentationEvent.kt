package com.samuraicmdv.featurelogin

sealed class PresentationEvent {
    data class Login(val username: String, val password: String) : PresentationEvent()
    data object ForgotPassword : PresentationEvent()
    data object SignUp : PresentationEvent()
}