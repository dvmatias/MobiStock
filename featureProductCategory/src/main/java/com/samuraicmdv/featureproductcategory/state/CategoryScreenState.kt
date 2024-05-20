package com.samuraicmdv.featureproductcategory.state

data class CategoryScreenState(
    val isLoading: Boolean = false,
    val category: CategoryUiData? = null,
    val brands: List<ProductBrandUiData>? = null,
    val products: List<ProductUiData>? = null,
    val showProductDetailsBottomSheet: Boolean = false,
) {
}
