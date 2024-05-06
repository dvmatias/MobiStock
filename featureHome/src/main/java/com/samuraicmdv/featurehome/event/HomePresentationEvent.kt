package com.samuraicmdv.featurehome.event

/**
 * Declares all the ui events in Home flow. An ui event is finally handled in the PRESENTATION layer
 * (i.e. a viewModel, a composable function, an Activity).
 */
sealed class HomePresentationEvent: HomeEvent {
    data class HandleUsersBottomSheetState(val show: Boolean): HomePresentationEvent()
}