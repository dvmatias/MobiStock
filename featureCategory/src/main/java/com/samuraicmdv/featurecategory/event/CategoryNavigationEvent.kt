package com.samuraicmdv.featurecategory.event

sealed interface CategoryNavigationEvent : CategoryEvent {
    data class NavigateProductDetails(val isEditMode: Boolean, val productId: Int) : CategoryNavigationEvent
}