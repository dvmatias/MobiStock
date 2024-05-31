package com.samuraicmdv.domain.model

/**
 * Data class that models the API response for getting a Category in the domain layer.
 */
data class CategoryResponseModel(
    val category: CategoryModel? = null,
    val brands: List<ProductBrandModel>? = null,
    val products: List<ProductModel>? = null,
)