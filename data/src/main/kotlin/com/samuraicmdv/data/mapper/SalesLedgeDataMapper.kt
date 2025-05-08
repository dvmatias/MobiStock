package com.samuraicmdv.data.mapper

import com.samuraicmdv.data.entity.GetSalesLedgeResponseEntity
import com.samuraicmdv.domain.base.DataMapper
import com.samuraicmdv.domain.model.GetDailySalesLedgeResponseModel
import com.samuraicmdv.domain.model.SalesLedgeModel

object SalesLedgeDataMapper : DataMapper<GetSalesLedgeResponseEntity, GetDailySalesLedgeResponseModel> {
    override fun entityToModel(entity: GetSalesLedgeResponseEntity?): GetDailySalesLedgeResponseModel? {
        return entity?.salesLedge?.let { salesLedge ->
            GetDailySalesLedgeResponseModel(
                salesLedge = salesLedge.id?.let {
                    SalesLedgeModel(
                        id = it
                    )
                }
            )
        }
    }
}