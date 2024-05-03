package com.samuraicmdv.featurelogin.event

/**
 * Declares all the navigation events in Login flow. A navigation event ends in the launch of a new
 * Activity (internal or external to this module). All the events declared in here are finally
 * handled by a implementation of [com.samuraicmdv.common.navigation.Navigator].
 */
sealed interface LoginNavigationEvent : LoginEvent {
    data class NavigateHome(val userId: Int) : LoginNavigationEvent
}