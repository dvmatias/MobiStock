package com.samuraicmdv.featurebarcodescanner.transformer

import com.samuraicmdv.domain.model.ProductDetailsResponseModel
import com.samuraicmdv.featurebarcodescanner.state.ItemDetailsUiData
import javax.inject.Inject

class ItemDetailsUiDataTransformerImpl @Inject constructor() : ItemDetailsUiDataTransformer {

    /**
     * Transforms a [ProductDetailsResponseModel] into an [ItemDetailsUiData].
     */
    override fun transform(model: ProductDetailsResponseModel?): ItemDetailsUiData {
        val product = model?.product
        val brand = model?.brand
        val category = model?.category
        val subcategory = model?.subcategory

        return ItemDetailsUiData(
            id = product?.id ?: -1,
            brandLogoUrl = brand?.logoUrl ?: "",
            brandName = brand?.name ?: "",
            categorySubcategory = category?.let {
                buildString {
                    append(it.name)
                    subcategory?.let { sub ->
                        append(" - ")
                        append(sub.name)
                    }
                }
            } ?: "",
            code = product?.code ?: "",
            description = product?.shortDescription ?: "",
            price = product?.productPrice?.selling ?: 0.0,
            stock = product?.stock,
            thumbnailUrl = product?.thumbnailUrl ?: "",
            title = product?.name ?: "",
        )
    }

}