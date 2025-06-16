package com.samuraicmdv.data.mapper

import com.samuraicmdv.data.entity.GetDaySalesLedgerResponseEntity
import com.samuraicmdv.domain.base.EntityMapper
import com.samuraicmdv.domain.model.DaySalesLedgerModel
import com.samuraicmdv.domain.model.GetDaySalesLedgerResponseModel

object DaySalesLedgerEntityMapper : EntityMapper<GetDaySalesLedgerResponseEntity, GetDaySalesLedgerResponseModel> {
    override fun map(entity: GetDaySalesLedgerResponseEntity?): GetDaySalesLedgerResponseModel? {
        return entity?.salesLedger?.let { salesLedge ->
            GetDaySalesLedgerResponseModel(
                errorMessage = null,
                daySalesLedger = DaySalesLedgerModel(
                    id = salesLedge.id
                )
            )
        }
    }
}