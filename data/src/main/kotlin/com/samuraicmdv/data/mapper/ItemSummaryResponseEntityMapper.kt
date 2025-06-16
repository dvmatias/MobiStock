package com.samuraicmdv.data.mapper

import com.samuraicmdv.data.entity.ItemSummaryResponseEntity
import com.samuraicmdv.domain.base.EntityMapper
import com.samuraicmdv.domain.model.ItemModel
import com.samuraicmdv.domain.model.ItemSummaryResponseModel
import javax.inject.Inject

class ItemSummaryResponseEntityMapper @Inject constructor() :
    EntityMapper<ItemSummaryResponseEntity?, ItemSummaryResponseModel?> {

    override fun map(entity: ItemSummaryResponseEntity?): ItemSummaryResponseModel? {
        if (entity == null) {
            return null
        }
        return ItemSummaryResponseModel(
            item = ItemModel.Summary(
                id = entity.item?.id,
                name = entity.item?.name,
                code = entity.item?.code,
                model = entity.item?.model,
                description = entity.item?.shortDescription,
                price = entity.item?.price,
                thumbnailUrl = entity.item?.thumbnailUrl,
                brandName = entity.item?.brandName,
                brandLogoUrl = entity.item?.brandLogoUrl,
                categoryName = entity.item?.categoryName,
                subcategoryName = entity.item?.subcategoryName,
                stock = entity.item?.stock,
            )
        )
    }
}