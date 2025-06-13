package com.samuraicmdv.featuredashboard.state

import android.graphics.drawable.Drawable

/**
 * Data class for modeling a product subcategory.
 *
 * @param id Unique identifier for the product subcategory.
 * @param name Name of the product subcategory.
 * @param iconDrawable Drawable resource for the product subcategory icon.
 * @param productsQuantity Number of products in the subcategory.
 */
data class ProductSubcategoryUiData(
    val id: Int,
    val name: String? = null,
    val iconDrawable: Drawable? = null,
    val productsQuantity: Int? = null,
)