package com.samuraicmdv.featuredashboard.transformer

import com.samuraicmdv.domain.model.GetDaySalesLedgerResponseModel
import com.samuraicmdv.featuredashboard.state.DailySaleUiData

/**
 * TODO
 */
interface DaySalesLedgerUiDataTransformer {
    /**
     * TODO
     */
    fun transform(model: GetDaySalesLedgerResponseModel): DailySaleUiData
}