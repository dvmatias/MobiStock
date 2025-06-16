package com.samuraicmdv.domain.model

import java.util.Date

data class DaySalesLedgerModel(
    val id: Int? = null,
    val storeId: Int? = null,
    val date: Date? = null,
    val openingTime: Date? = null,
    val closingTime: Date? = null,
    val openSellerId: Int? = null,
    val closeSellerId: Int? = null,
)
