package com.samuraicmdv.data.mapper

import com.samuraicmdv.data.entity.GetProductDetailsResponseEntity
import com.samuraicmdv.domain.base.DataMapper
import com.samuraicmdv.domain.model.GetProductDetailsResponseModel

object GetProductDetailsDataMapper :
    DataMapper<GetProductDetailsResponseEntity, GetProductDetailsResponseModel> {
    override fun entityToModel(entity: GetProductDetailsResponseEntity?): GetProductDetailsResponseModel? {
        return GetProductDetailsResponseModel(
            product = entity?.productEntity?.toModel()
        )
    }
}