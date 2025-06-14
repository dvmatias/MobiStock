package com.samuraicmdv.data.datasource

import com.samuraicmdv.data.entity.GetDaySalesLedgerResponseEntity
import com.samuraicmdv.domain.util.ResponseWrapper

interface SalesLedgerDataSource {
    suspend fun getDaySalesLedger(
        storeId: Int,
        day: Int,
        month: Int,
        year: Int
    ): ResponseWrapper<GetDaySalesLedgerResponseEntity>
}