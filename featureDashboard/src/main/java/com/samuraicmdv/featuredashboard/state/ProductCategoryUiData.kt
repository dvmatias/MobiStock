package com.samuraicmdv.featuredashboard.state

import android.graphics.drawable.Drawable

/**
 * Data class for modeling a item category.
 *
 * @param id Unique identifier for the item category.
 * @param name Name of the item category.
 * @param iconDrawable Drawable resource for the item category icon.
 * @param isExpanded Indicates whether the category is expanded or not.
 * @param productsQuantity Number of products in the category.
 * @param subcategories List of [ProductSubcategoryUiData] under this item category.
 */
data class ProductCategoryUiData(
    val id: Int,
    val name: String? = null,
    val iconDrawable: Drawable? = null,
    val isExpanded: Boolean = false,
    val productsQuantity: Int? = null,
    val subcategories: List<ProductSubcategoryUiData>? = null,
)