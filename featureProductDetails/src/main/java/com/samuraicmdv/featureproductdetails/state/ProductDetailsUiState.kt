package com.samuraicmdv.featureproductdetails.state

import com.samuraicmdv.common.uidata.CategoryUiData
import com.samuraicmdv.common.uidata.ProductBrandUiData
import com.samuraicmdv.common.uidata.ProductUiData

/**
 * Represents the state of the item details screen.
 *
 * @param screenMode The mode of the item details screen.
 * @param isLoading Indicates if the screen is loading.
 * @param product The item details to display.
 * @param categories The list of item categories to display. This is needed for editing or creating a item.
 * @param brands The list of item brands to display. This is needed for editing or creating a item.
 */
data class ProductDetailsUiState(
    val screenMode: ProductDetailsUiMode = ProductDetailsUiMode.VIEW,
    val isLoading: Boolean = false,
    val product: ProductUiData? = null,
    val categories: List<CategoryUiData>? = null,
    val brands: List<ProductBrandUiData>? = null,
)
