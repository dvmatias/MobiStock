package com.samuraicmdv.featureproductdetails.state

import com.samuraicmdv.featureproductdetails.data.ProductDetailsUiData

/**
 * Represents the state of the product details screen.
 *
 * @param screenMode The mode of the product details screen.
 * @param isLoading Indicates if the screen is loading.
 * @param productDetails The product details to display.
 */
data class ProductDetailsScreenState(
    val screenMode: ProductDetailsScreenMode = ProductDetailsScreenMode.VIEW,
    val isLoading: Boolean = false,
    val productDetails: ProductDetailsUiData? = null,
)
