package com.samuraicmdv.data.mapper

import com.samuraicmdv.data.entity.ProductBrandEntity
import com.samuraicmdv.data.entity.ProductBrandsResponseEntity
import com.samuraicmdv.domain.base.DataMapper
import com.samuraicmdv.domain.model.ProductBrandModel
import com.samuraicmdv.domain.model.ProductBrandsResponseModel

object BrandDataMapper : DataMapper<ProductBrandsResponseEntity?, ProductBrandsResponseModel?> {

    override fun entityToModel(entity: ProductBrandsResponseEntity?): ProductBrandsResponseModel? =
        entity?.let { e ->
            ProductBrandsResponseModel(
                brands = e.brands?.map { transformBrand(it) }.orEmpty()
            )
        }

    private fun transformBrand(brand: ProductBrandEntity): ProductBrandModel =
        ProductBrandModel(
            id = brand.id,
            name = brand.name,
            logoUrl = brand.logoUrl
        )
}