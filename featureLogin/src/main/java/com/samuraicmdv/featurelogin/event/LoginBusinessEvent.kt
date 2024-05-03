package com.samuraicmdv.featurelogin.event

/**
 * Declares all the business events in Login flow. A business event is finally handled in the DOMAIN
 * layer (i.e. a use case).
 */
sealed class LoginBusinessEvent: LoginEvent {
    data class Login(val username: String, val password: String) : LoginBusinessEvent()
    data object ForgotPassword : LoginBusinessEvent()
    data object SignUp : LoginBusinessEvent()
}