package com.samuraicmdv.featurehome.state

import androidx.annotation.StringRes

data class ProductCategoriesUiData(
    val categories: List<ProductCategoryUiData>? = null,
)

data class ProductCategoryUiData(
    val id: Int,
    @StringRes val nameResId: Int? = null,
    val imageUrl: String? = null,
    val productsCount: Int? = null,
)
