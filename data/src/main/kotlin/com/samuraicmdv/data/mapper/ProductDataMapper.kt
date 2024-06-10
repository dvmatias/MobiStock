package com.samuraicmdv.data.mapper

import com.samuraicmdv.data.entity.CreateProductResponseEntity
import com.samuraicmdv.domain.base.DataMapper
import com.samuraicmdv.domain.model.CreateProductResponseModel

object ProductDataMapper : DataMapper<CreateProductResponseEntity, CreateProductResponseModel> {
    override fun entityToModel(entity: CreateProductResponseEntity?): CreateProductResponseModel? {
        return CreateProductResponseModel(
            id = entity?.id ?: -1,
        )
    }
}