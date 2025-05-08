package com.samuraicmdv.data.datasource.retrofit

import com.samuraicmdv.data.api.SalesLedgeApi
import com.samuraicmdv.data.datasource.SalesLedgeDataSource
import com.samuraicmdv.data.mapper.SalesLedgeDataMapper
import com.samuraicmdv.domain.model.GetDailySalesLedgeResponseModel
import com.samuraicmdv.domain.util.ResponseFailure
import com.samuraicmdv.domain.util.ResponseWrapper
import javax.inject.Inject

class SalesLedgeDataSourceRetrofitImpl @Inject constructor(
    private val salesLedgeApi: SalesLedgeApi,
    private val salesLedgeDataMapper: SalesLedgeDataMapper
) : SalesLedgeDataSource {

    override suspend fun getDailySalesLedge(
        storeId: Int,
        day: Int,
        month: Int,
        year: Int
    ): ResponseWrapper<GetDailySalesLedgeResponseModel> {
        val response = salesLedgeApi.getDailySalesLedge(storeId, day, month, year)
        val body = response.body()

        return if (response.isSuccessful && body != null) {
            ResponseWrapper.success(salesLedgeDataMapper.entityToModel(body))
        } else {
            ResponseWrapper.error(
                null,
                ResponseFailure.ServerError("Get daily sales ledge response failure.")
            )
        }
    }

}