package com.samuraicmdv.featurelogin.event

/**
 * Interface - This class is the base class of every event that needs to be handled in the Login
 * flow. Every base class event must have 3 implementations on each module:
 *  - NavigationEvent: Declares all the NAVIGATION events.
 *  - BusinessEvent: Declares all the events handled by the DOMAIN layer.
 *  - PresentationEvent: Declares all the events handled by the PRESENTATION layer
 */
sealed interface LoginEvent