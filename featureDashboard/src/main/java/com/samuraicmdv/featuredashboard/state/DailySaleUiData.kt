package com.samuraicmdv.featuredashboard.state

import java.util.Date

data class DailySaleUiData(
    val isDailySalesLedgeOpen: Boolean = false,
    val currentDayDate: Date? = null,
    val summary: String? = null,
    val isLoading: Boolean? = false
)
