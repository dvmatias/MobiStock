package com.samuraicmdv.featuredashboard.state

/**
 * State class for managing the item categories in the dashboard.
 *
 * @param categories List of [ProductCategoryUiData] representing the item categories.
 */
data class ProductCategoriesState(
    val categories: List<ProductCategoryUiData>? = null,
    val isLoading: Boolean = false,
)
