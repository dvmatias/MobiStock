package com.samuraicmdv.domain.model

data class PriceModel(
    val selling: Double,
    val cost: Double,
    val currencyId: Int,
    val storeId: Int,
    val preferredMargin: Int,
)