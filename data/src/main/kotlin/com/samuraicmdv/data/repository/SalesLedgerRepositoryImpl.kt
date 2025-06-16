package com.samuraicmdv.data.repository

import com.samuraicmdv.data.datasource.SalesLedgerDataSource
import com.samuraicmdv.data.mapper.DaySalesLedgerEntityMapper
import com.samuraicmdv.domain.model.GetDaySalesLedgerResponseModel
import com.samuraicmdv.domain.repository.SalesLedgerRepository
import com.samuraicmdv.domain.util.ResponseFailure
import com.samuraicmdv.domain.util.ResponseStatus
import com.samuraicmdv.domain.util.ResponseWrapper
import javax.inject.Inject

class SalesLedgerRepositoryImpl @Inject constructor(
    private val dataSource: SalesLedgerDataSource,
    private val daySalesLedgeDataMapper: DaySalesLedgerEntityMapper
) : SalesLedgerRepository {
    override suspend fun getDaySalesLedger(
        storeId: Int,
        day: Int,
        month: Int,
        year: Int
    ): ResponseWrapper<GetDaySalesLedgerResponseModel> {
        val response = dataSource.getDaySalesLedger(storeId, day, month, year)
        return when (response.status) {
            ResponseStatus.SUCCESS -> ResponseWrapper.success(data = daySalesLedgeDataMapper.map(response.getOrNull()))
            ResponseStatus.ERROR -> {
                ResponseWrapper.error(
                    data = null,
                    responseFailure = response.failure
                        ?: ResponseFailure.ServerError("Failed to get daily sales ledge.")
                )
            }
        }
    }
}