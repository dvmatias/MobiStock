package com.samuraicmdv.featureproductdetails.state

import com.samuraicmdv.featureproductdetails.data.BrandUiData
import com.samuraicmdv.featureproductdetails.data.CategoryUiData
import com.samuraicmdv.featureproductdetails.data.ProductUiData

/**
 * Represents the state of the product details screen.
 *
 * @param screenMode The mode of the product details screen.
 * @param isLoading Indicates if the screen is loading.
 * @param product The product details to display.
 * @param categories The list of product categories to display. This is needed for editing or creating a product.
 * @param brands The list of product brands to display. This is needed for editing or creating a product.
 */
data class ProductDetailsUiState(
    val screenMode: ProductDetailsUiMode = ProductDetailsUiMode.VIEW,
    val isLoading: Boolean = false,
    val product: ProductUiData? = null,
    val categories: List<CategoryUiData>? = null,
    val brands: List<BrandUiData>? = null,
)
