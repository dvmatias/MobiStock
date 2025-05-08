package com.samuraicmdv.data.datasource

import com.samuraicmdv.domain.model.GetDailySalesLedgeResponseModel
import com.samuraicmdv.domain.util.ResponseWrapper

interface SalesLedgeDataSource {
    suspend fun getDailySalesLedge(
        storeId: Int,
        day: Int,
        month: Int,
        year: Int
    ): ResponseWrapper<GetDailySalesLedgeResponseModel>
}