package com.samuraicmdv.featuredashboard.state

import android.graphics.drawable.Drawable

data class ProductCategoriesState(
    val categories: List<ProductCategoryUiData>? = null,
)

/**
 * Data class for modeling a product category.
 *
 * @param id Unique identifier for the product category.
 * @param name Name of the product category.
 * @param imageUrl URL of the image associated with the product category.
 * @param iconDrawable Drawable resource for the product category icon.
 * @param productsQuantity Number of products in the category.
 * @param subcategories List of [ProductSubcategoryUiData] under this product category.
 */
data class ProductCategoryUiData(
    val id: Int,
    val name: String? = null,
    val imageUrl: String? = null,
    val iconDrawable: Drawable? = null,
    val productsQuantity: Int? = null,
    val subcategories: List<ProductSubcategoryUiData>? = null,
)

/**
 * Data class for modeling a product subcategory.
 *
 * @param id Unique identifier for the product subcategory.
 * @param name Name of the product subcategory.
 * @param imageUrl URL of the image associated with the product subcategory.
 * @param iconDrawable Drawable resource for the product subcategory icon.
 * @param productsQuantity Number of products in the subcategory.
 */
data class ProductSubcategoryUiData(
    val id: Int,
    val name: String? = null,
    val imageUrl: String? = null,
    val iconDrawable: Drawable? = null,
    val productsQuantity: Int? = null,
)
