package com.samuraicmdv.domain.model

import com.samuraicmdv.common.utils.ProductSubcategoryType

data class ProductSubcategoryModel(
    val id: Int?,
    val type: ProductSubcategoryType? = null,
    val name: String?,
    val description: String? = null
)