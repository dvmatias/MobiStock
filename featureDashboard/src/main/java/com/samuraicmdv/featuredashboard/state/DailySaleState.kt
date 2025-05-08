package com.samuraicmdv.featuredashboard.state

import java.util.Date

data class DailySaleState(
    val isDailySalesLedgeOpen: Boolean = false,
    val currentDayDate: Date? = null,
    val summary: String? = null,
    val isLoading: Boolean? = false
)
