package com.samuraicmdv.data.mapper

import com.samuraicmdv.data.entity.GetDaySalesLedgerResponseEntity
import com.samuraicmdv.domain.base.EntityMapper
import com.samuraicmdv.domain.model.GetDaySalesLedgerResponseModel
import com.samuraicmdv.domain.model.SalesLedgeModel

object DaySalesLedgerEntityMapper : EntityMapper<GetDaySalesLedgerResponseEntity, GetDaySalesLedgerResponseModel> {
    override fun map(entity: GetDaySalesLedgerResponseEntity?): GetDaySalesLedgerResponseModel? {
        return entity?.salesLedger?.let { salesLedge ->
            GetDaySalesLedgerResponseModel(
                salesLedge = salesLedge.id?.let {
                    SalesLedgeModel(
                        id = it
                    )
                }
            )
        }
    }
}