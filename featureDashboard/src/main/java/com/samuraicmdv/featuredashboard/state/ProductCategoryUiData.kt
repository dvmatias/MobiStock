package com.samuraicmdv.featuredashboard.state

import android.graphics.drawable.Drawable

/**
 * Data class for modeling a product category.
 *
 * @param id Unique identifier for the product category.
 * @param name Name of the product category.
 * @param imageUrl URL of the image associated with the product category.
 * @param iconDrawable Drawable resource for the product category icon.
 * @param isExpanded Indicates whether the category is expanded or not.
 * @param productsQuantity Number of products in the category.
 * @param subcategories List of [ProductSubcategoryUiData] under this product category.
 */
data class ProductCategoryUiData(
    val id: Int,
    val name: String? = null,
    val imageUrl: String? = null,
    val iconDrawable: Drawable? = null,
    val isExpanded: Boolean = false,
    val productsQuantity: Int? = null,
    val subcategories: List<ProductSubcategoryUiData>? = null,
)