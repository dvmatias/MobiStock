package com.samuraicmdv.data.mapper

import com.samuraicmdv.data.entity.GetSalesLedgeResponseEntity
import com.samuraicmdv.domain.base.EntityMapper
import com.samuraicmdv.domain.model.GetDailySalesLedgeResponseModel
import com.samuraicmdv.domain.model.SalesLedgeModel

object SalesLedgeEntityMapper : EntityMapper<GetSalesLedgeResponseEntity, GetDailySalesLedgeResponseModel> {
    override fun map(entity: GetSalesLedgeResponseEntity?): GetDailySalesLedgeResponseModel? {
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