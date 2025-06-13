package com.samuraicmdv.common.uidata

data class ProductPriceUiData(
    val sellingPrice: Double? = null,
    val costPrice: Double? = null,
    val currency: String? = null,
    val preferredMargin: Int? = null,
)