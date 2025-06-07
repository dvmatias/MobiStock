package com.samuraicmdv.data.mapper

import com.samuraicmdv.data.entity.GetProductDetailsResponseEntity
import com.samuraicmdv.domain.base.EntityMapper
import com.samuraicmdv.domain.model.GetProductDetailsResponseModel
import com.samuraicmdv.domain.model.ProductDetailsModel
import javax.inject.Inject

class GetProductDetailsEntityMapper @Inject constructor() :
    EntityMapper<GetProductDetailsResponseEntity?, GetProductDetailsResponseModel?> {

    override fun map(entity: GetProductDetailsResponseEntity?): GetProductDetailsResponseModel? {
        if (entity == null) {
            return null
        }
        return GetProductDetailsResponseModel(
            productDetails = ProductDetailsModel(
                id = entity.product?.id,
                name = entity.product?.name,
                shortDescription = entity.product?.shortDescription,
                longDescription = entity.product?.longDescription,
                model = entity.product?.model,
                code = entity.product?.code,
                sku = entity.product?.sku,
                thumbnailUrl = entity.imageUrls?.firstOrNull(),
                imageUrls = entity.imageUrls,
                category = entity.category?.toModel(),
                stock = entity.stock?.toModel(),
                productPrice = entity.price?.toModel(),
                brand = entity.brand?.toModel()
            )
        )
    }
}