package com.samuraicmdv.featurecategory.state

import com.samuraicmdv.common.ALPHA_FULL
import com.samuraicmdv.common.ALPHA_ZERO

data class CategoryScreenState(
    val isLoading: Boolean = false,
    val category: CategoryUiData? = null,
    val brands: List<ProductBrandUiData>? = null,
    val products: List<ProductUiData>? = null,
    val selectedProduct: ProductUiData? = null,
    val showProductDetailsBottomSheet: Boolean = false,
    val topAppBarTitleAlpha: Float = ALPHA_ZERO,
    val categoryTitleAlpha: Float = ALPHA_FULL,
    val isStickyHeaderPinned: Boolean = false,
)
