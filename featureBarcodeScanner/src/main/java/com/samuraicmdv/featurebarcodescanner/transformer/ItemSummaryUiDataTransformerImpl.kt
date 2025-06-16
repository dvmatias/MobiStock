package com.samuraicmdv.featurebarcodescanner.transformer

import com.samuraicmdv.domain.model.ItemSummaryResponseModel
import com.samuraicmdv.domain.model.ProductDetailsResponseModel
import com.samuraicmdv.featurebarcodescanner.state.ItemDetailsUiData
import javax.inject.Inject

class ItemSummaryUiDataTransformerImpl @Inject constructor() : ItemSummaryUiDataTransformer {

    /**
     * Transforms a [ProductDetailsResponseModel] into an [ItemDetailsUiData].
     */
    override fun transform(model: ItemSummaryResponseModel?): ItemDetailsUiData {
        val product = model?.item

        return ItemDetailsUiData(
            id = product?.id ?: -1,
            brandLogoUrl = product?.brandLogoUrl ?: "",
            brandName =product?.brandName ?: "",
            categorySubcategory = product?.categoryName.let {
                buildString {
                    append(it)
                    product?.subcategoryName?.let { sub ->
                        append(" - ")
                        append(sub)
                    }
                }
            },
            code = product?.code ?: "",
            description = product?.description ?: "",
            price = product?.price ?: 0.0,
            stock = product?.stock,
            thumbnailUrl = product?.thumbnailUrl ?: "",
            title = product?.name ?: "",
        )
    }

}