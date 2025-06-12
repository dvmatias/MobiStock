package com.samuraicmdv.data.mapper

import com.samuraicmdv.data.entity.ProductDetailsResponseEntity
import com.samuraicmdv.domain.base.EntityMapper
import com.samuraicmdv.domain.model.ProductDetailsResponseModel
import com.samuraicmdv.domain.model.ProductModel
import javax.inject.Inject

class ProductDetailsResponseEntityMapper @Inject constructor() :
    EntityMapper<ProductDetailsResponseEntity?, ProductDetailsResponseModel?> {

    override fun map(entity: ProductDetailsResponseEntity?): ProductDetailsResponseModel? {
        if (entity == null) {
            return null
        }
        return ProductDetailsResponseModel(
            product = ProductModel(
                id = entity.product?.id,
                brandId = entity.product?.brandId,
                categoryId = entity.category?.id,
                code = entity.product?.code,
                imageUrls = entity.product?.imageUrls,
                longDescription = entity.product?.longDescription,
                model = entity.product?.model,
                name = entity.product?.name,
                productPrice = entity.product?.price?.toModel(),
                shortDescription = entity.product?.shortDescription,
                sku = entity.product?.sku,
                stock = entity.product?.stock?.toModel(),
                subcategoryId = entity.subcategory?.id,
                thumbnailUrl = entity.product?.thumbnailUrl
            ),
            brand = entity.brand?.toModel(),
            category = entity.category?.toModel(),
            subcategory = entity.subcategory?.toModel(),
        )
    }
}