package com.samuraicmdv.featuredashboard.transformer

import com.samuraicmdv.domain.model.GetDaySalesLedgerResponseModel
import com.samuraicmdv.featuredashboard.state.DailySaleUiData
import javax.inject.Inject

class DaySalesLedgerUiDataTransformerImpl @Inject constructor() : DaySalesLedgerUiDataTransformer {
    override fun transform(model: GetDaySalesLedgerResponseModel): DailySaleUiData {
        // TODO
        return DailySaleUiData(
            isLoading = false
        )
    }
}