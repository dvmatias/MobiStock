package com.samuraicmdv.data.mapper

import com.samuraicmdv.data.entity.BrandEntity
import com.samuraicmdv.data.entity.GetBrandsResponseEntity
import com.samuraicmdv.domain.base.DataMapper
import com.samuraicmdv.domain.model.BrandModel
import com.samuraicmdv.domain.model.GetBrandsResponseModel

object BrandDataMapper : DataMapper<GetBrandsResponseEntity?, GetBrandsResponseModel?> {

    override fun entityToModel(entity: GetBrandsResponseEntity?): GetBrandsResponseModel? =
        entity?.let { e ->
            GetBrandsResponseModel(
                brands = e.brands?.map { transformBrand(it) }.orEmpty()
            )
        }

    private fun transformBrand(brand: BrandEntity): BrandModel =
        BrandModel(
            id = brand.id,
            name = brand.name,
            logoUrl = brand.logoUrl
        )
}