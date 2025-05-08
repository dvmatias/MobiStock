package com.samuraicmdv.featuredashboard.event

/**
 * Declares all the ui events in Home flow. An ui event is finally handled in the PRESENTATION layer
 * (i.e. a viewModel, a composable function, an Activity).
 */
sealed class DashboardPresentationEvent: DashboardEvent {
    data class HandleUsersBottomSheetState(val show: Boolean): DashboardPresentationEvent()
}