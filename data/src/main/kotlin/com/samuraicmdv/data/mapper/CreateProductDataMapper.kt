package com.samuraicmdv.data.mapper

import com.samuraicmdv.data.entity.CreateProductResponseEntity
import com.samuraicmdv.domain.base.DataMapper
import com.samuraicmdv.domain.model.CreateProductResponseModel

object CreateProductDataMapper :
    DataMapper<CreateProductResponseEntity, CreateProductResponseModel> {
    override fun entityToModel(entity: CreateProductResponseEntity?): CreateProductResponseModel? =
        entity?.let {
            CreateProductResponseModel(
                id = it.id,
            )
        }

}