package com.samuraicmdv.featurebarcodescanner.transformer

import com.samuraicmdv.domain.model.ProductDetailsResponseModel
import com.samuraicmdv.featurebarcodescanner.state.ItemDetailsUiData

interface ItemDetailsUiDataTransformer {
    fun transform(model: ProductDetailsResponseModel?): ItemDetailsUiData
}