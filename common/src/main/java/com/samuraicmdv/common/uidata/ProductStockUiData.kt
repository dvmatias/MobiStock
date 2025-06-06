package com.samuraicmdv.common.uidata

data class ProductStockUiData(
    val quantity: Int? = null,
    val low: Int? = null,
    val min: Int? = null,
    // TODO add isAvailable property
)