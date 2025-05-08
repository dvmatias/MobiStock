package com.samuraicmdv.domain.repository

import com.samuraicmdv.domain.model.GetDailySalesLedgeResponseModel
import com.samuraicmdv.domain.util.ResponseWrapper

interface SalesLedgeRepository {
    suspend fun getDailySalesLedge(
        storeId: Int,
        day: Int,
        month: Int,
        year: Int
    ): ResponseWrapper<GetDailySalesLedgeResponseModel>
}