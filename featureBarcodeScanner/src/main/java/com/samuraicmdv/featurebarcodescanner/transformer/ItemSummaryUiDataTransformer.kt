package com.samuraicmdv.featurebarcodescanner.transformer

import com.samuraicmdv.domain.model.ItemSummaryResponseModel
import com.samuraicmdv.featurebarcodescanner.state.ItemDetailsUiData

interface ItemSummaryUiDataTransformer {
    fun transform(model: ItemSummaryResponseModel?): ItemDetailsUiData
}