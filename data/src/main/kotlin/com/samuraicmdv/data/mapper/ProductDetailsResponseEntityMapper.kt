package com.samuraicmdv.data.mapper

import com.samuraicmdv.data.entity.ProductDetailsResponseEntity
import com.samuraicmdv.domain.base.EntityMapper
import com.samuraicmdv.domain.model.ProductDetailsResponseModel
import javax.inject.Inject

class ProductDetailsResponseEntityMapper @Inject constructor() :
    EntityMapper<ProductDetailsResponseEntity?, ProductDetailsResponseModel?> {

    override fun map(entity: ProductDetailsResponseEntity?): ProductDetailsResponseModel? {
        if (entity == null) {
            return null
        }
        return ProductDetailsResponseModel(
//            item = ItemModel(
//                id = entity.item?.id,
//                brandId = entity.item?.brandId,
//                categoryId = entity.category?.id,
//                code = entity.item?.code,
//                imageUrls = entity.item?.imageUrls,
//                longDescription = entity.item?.longDescription,
//                model = entity.item?.model,
//                name = entity.item?.name,
//                productPrice = entity.item?.price?.toModel(),
//                shortDescription = entity.item?.shortDescription,
//                sku = entity.item?.sku,
//                stock = entity.item?.stock,
//                subcategoryId = entity.subcategory?.id,
//                thumbnailUrl = entity.item?.thumbnailUrl
//            ),
//            brand = entity.brand?.toModel(),
//            category = entity.category?.toModel(),
//            subcategory = entity.subcategory?.toModel(),
            TODO()
        )
    }
}