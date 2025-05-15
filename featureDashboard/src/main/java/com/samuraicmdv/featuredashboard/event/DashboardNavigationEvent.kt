package com.samuraicmdv.featuredashboard.event

/**
 * Declares all the navigation events in Home flow. A navigation event ends in the launch of a new
 * Activity (internal or external to this module). All the events declared in here are finally
 * handled by a implementation of [com.samuraicmdv.common.navigation.Navigator].
 */
sealed interface DashboardNavigationEvent : DashboardEvent {
    data class NavigateProductCategory(val categoryId: Int) : DashboardNavigationEvent
    data object NavigateBarcodeScanner : DashboardNavigationEvent
}