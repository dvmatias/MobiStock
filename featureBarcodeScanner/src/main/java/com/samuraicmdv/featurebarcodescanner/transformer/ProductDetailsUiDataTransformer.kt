package com.samuraicmdv.featurebarcodescanner.transformer

import com.samuraicmdv.common.uidata.CategoryUiData
import com.samuraicmdv.common.uidata.ProductBrandUiData
import com.samuraicmdv.common.uidata.ProductPriceUiData
import com.samuraicmdv.common.uidata.ProductUiData
import com.samuraicmdv.common.utils.getNameResId
import com.samuraicmdv.domain.model.ProductDetailsResponseModel

object ProductDetailsUiDataTransformer {

    fun transformProduct(model: ProductDetailsResponseModel?): ProductUiData {
        val product = model?.product
        val brand = model?.brand
        val category = model?.category
        return ProductUiData(
            id = product?.id ?: -1,
            brand = brand?.let {
                ProductBrandUiData(
                    id = it.id ?: -1,
                    name = it.name ?: "",
                    logoUrl = it.logoUrl ?: "",
                )
            },
            category = category?.let {
                CategoryUiData(
                    id = it.id ?: -1,
                    nameResId = it.type.getNameResId(),
                    description = it.description ?: "",
                )
            },
            code = product?.code ?: "",
            imageUrls = product?.imageUrls ?: emptyList(),
            longDescription = product?.longDescription ?: "",
            model = product?.model ?: "",
            name = product?.name ?: "",
            price = product?.productPrice?.let {
                ProductPriceUiData(
                    sellingPrice = it.selling,
                    costPrice = it.cost,
                    preferredMargin = it.preferredMargin
                )
            },
            shortDescription = product?.shortDescription ?: "",
            sku = product?.sku ?: "",
            stock = product?.stock?.let {
                com.samuraicmdv.common.uidata.ProductStockUiData(
                    quantity = it.quantity ?: 0
                )
            },
            thumbnailUrl = product?.thumbnailUrl ?: "",
        )
    }

}