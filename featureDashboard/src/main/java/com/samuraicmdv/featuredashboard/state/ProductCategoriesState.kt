package com.samuraicmdv.featuredashboard.state

/**
 * State class for managing the product categories in the dashboard.
 *
 * @param categories List of [ProductCategoryUiData] representing the product categories.
 */
data class ProductCategoriesState(
    val categories: List<ProductCategoryUiData>? = null,
)
