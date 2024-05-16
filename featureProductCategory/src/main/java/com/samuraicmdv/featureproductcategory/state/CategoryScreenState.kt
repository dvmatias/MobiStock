package com.samuraicmdv.featureproductcategory.state

data class CategoryScreenState(
    val isLoading: Boolean = false,
    val productCategory: CategoryUiData? = null,
    val brands: List<ProductBrandUiData>? = null,
    val products: List<ProductUiData>? = null,
)
