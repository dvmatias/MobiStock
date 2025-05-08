package com.samuraicmdv.data.repository

import com.samuraicmdv.data.datasource.SalesLedgeDataSource
import com.samuraicmdv.domain.model.GetDailySalesLedgeResponseModel
import com.samuraicmdv.domain.repository.SalesLedgeRepository
import com.samuraicmdv.domain.util.ResponseWrapper
import javax.inject.Inject

class SalesLedgeRepositoryImpl @Inject constructor(
    private val dataSource: SalesLedgeDataSource
) : SalesLedgeRepository {
    override suspend fun getDailySalesLedge(
        storeId: Int,
        day: Int,
        month: Int,
        year: Int
    ): ResponseWrapper<GetDailySalesLedgeResponseModel> {
        TODO("Not yet implemented")
    }
}