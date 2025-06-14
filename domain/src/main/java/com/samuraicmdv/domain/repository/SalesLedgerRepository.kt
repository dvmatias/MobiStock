package com.samuraicmdv.domain.repository

import com.samuraicmdv.domain.model.GetDaySalesLedgerResponseModel
import com.samuraicmdv.domain.util.ResponseWrapper

interface SalesLedgerRepository {
    suspend fun getDaySalesLedger(
        storeId: Int,
        day: Int,
        month: Int,
        year: Int
    ): ResponseWrapper<GetDaySalesLedgerResponseModel>
}