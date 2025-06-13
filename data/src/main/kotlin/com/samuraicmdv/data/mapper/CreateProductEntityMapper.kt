package com.samuraicmdv.data.mapper

import com.samuraicmdv.data.entity.CreateProductResponseEntity
import com.samuraicmdv.domain.base.EntityMapper
import com.samuraicmdv.domain.model.CreateProductResponseModel

object CreateProductEntityMapper :
    EntityMapper<CreateProductResponseEntity, CreateProductResponseModel> {
    override fun map(entity: CreateProductResponseEntity?): CreateProductResponseModel? =
        entity?.let {
            CreateProductResponseModel(
                id = it.id,
            )
        }

}