package com.samuraicmdv.data.mapper

import com.samuraicmdv.data.entity.GetProductDetailsResponseEntity
import com.samuraicmdv.domain.base.DataMapper
import com.samuraicmdv.domain.model.GetProductDetailsResponseModel
import com.samuraicmdv.domain.model.ProductDetailsModel

object GetProductDetailsDataMapper :
    DataMapper<GetProductDetailsResponseEntity, GetProductDetailsResponseModel> {
    override fun entityToModel(entity: GetProductDetailsResponseEntity?): GetProductDetailsResponseModel? {
        return GetProductDetailsResponseModel(
            productDetails = ProductDetailsModel(
                id = entity?.product?.id,
                name = entity?.product?.name,
                shortDescription = entity?.product?.shortDescription,
                longDescription = entity?.product?.longDescription,
                model = entity?.product?.model,
                code = entity?.product?.code,
                sku = entity?.product?.sku,
                thumbnailUrl = entity?.imageUrls?.firstOrNull(),
                imageUrls = entity?.imageUrls,
                category = entity?.category?.toModel(),
                stock = entity?.stock?.toModel(),
                productPrice = entity?.price?.toModel(),
                brand = entity?.brand?.toModel()
            )
        )
    }
}