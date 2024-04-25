package com.samuraicmdv.featurelogin.compose

sealed class PresentationEvent {
    data object Login: PresentationEvent()
    data object ForgotPassword: PresentationEvent()
    data object SignUp: PresentationEvent()
}