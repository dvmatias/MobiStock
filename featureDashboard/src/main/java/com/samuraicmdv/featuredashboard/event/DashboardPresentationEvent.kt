package com.samuraicmdv.featuredashboard.event

/**
 * Declares all the ui events in Home flow. An ui event is finally handled in the PRESENTATION layer
 * (i.e. a viewModel, a composable function, an Activity).
 */
sealed class DashboardPresentationEvent : DashboardEvent {
    /**
     * Event to handle the visibility of the users bottom sheet.
     *
     * @param show Boolean indicating whether to show or hide the bottom sheet.
     */
    data class HandleUsersBottomSheetState(val show: Boolean) : DashboardPresentationEvent()

    /**
     * Event to toggle the expanded status of a specific item category.
     *
     * @param id The ID of the item category to toggle.
     * @param isExpanded Boolean indicating whether the category should be expanded or collapsed.
     */
    data class ToggleProductCategoryExpandedStatus(
        val id: Int,
        val isExpanded: Boolean
    ) : DashboardEvent

    /**
     * Event to toggle the expanded status of all item categories.
     *
     * @param areAllCategoriesExpanded Boolean indicating whether all categories should be expanded or collapsed.
     */
    data class ToggleAllProductCategoriesExpandedStatus(val areAllCategoriesExpanded: Boolean) : DashboardEvent
}