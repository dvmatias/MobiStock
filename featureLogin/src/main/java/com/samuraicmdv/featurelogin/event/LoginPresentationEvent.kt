package com.samuraicmdv.featurelogin.event

/**
 * Declares all the ui events in Login flow. A ui event is finally handled in the PRESENTATION layer
 * (i.e. a viewModel, a composable function, an Activity).
 */
sealed class LoginPresentationEvent : LoginEvent