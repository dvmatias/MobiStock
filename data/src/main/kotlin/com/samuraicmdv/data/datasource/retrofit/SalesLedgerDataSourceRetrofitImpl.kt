package com.samuraicmdv.data.datasource.retrofit

import com.samuraicmdv.data.api.SalesLedgeApi
import com.samuraicmdv.data.datasource.SalesLedgerDataSource
import com.samuraicmdv.data.entity.GetDaySalesLedgerResponseEntity
import com.samuraicmdv.domain.util.ResponseFailure
import com.samuraicmdv.domain.util.ResponseWrapper
import javax.inject.Inject

class SalesLedgerDataSourceRetrofitImpl @Inject constructor(
    private val salesLedgeApi: SalesLedgeApi
) : SalesLedgerDataSource {

    override suspend fun getDaySalesLedger(
        storeId: Int,
        day: Int,
        month: Int,
        year: Int
    ): ResponseWrapper<GetDaySalesLedgerResponseEntity> {
        val response = salesLedgeApi.getDaySalesLedger(storeId, day, month, year)
        val body = response.body()

        return if (response.isSuccessful && body != null) {
            ResponseWrapper.success(body)
        } else {
            ResponseWrapper.error(
                null,
                ResponseFailure.ServerError("Get daily sales ledge response failure.")
            )
        }
    }
}