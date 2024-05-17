package com.samuraicmdv.data.mapper

import com.samuraicmdv.data.entity.CategoryEntity
import com.samuraicmdv.data.entity.CategoryResponseEntity
import com.samuraicmdv.data.entity.ErrorEntity
import com.samuraicmdv.data.entity.LoginResponseEntity
import com.samuraicmdv.data.entity.ProductBrandEntity
import com.samuraicmdv.data.entity.ProductEntity
import com.samuraicmdv.domain.base.DataMapper
import com.samuraicmdv.domain.model.CategoryModel
import com.samuraicmdv.domain.model.CategoryResponseModel
import com.samuraicmdv.domain.model.LoginErrorModel
import com.samuraicmdv.domain.model.LoginResponseModel
import com.samuraicmdv.domain.model.ProductBrandModel
import com.samuraicmdv.domain.model.ProductModel

object CategoryDataMapper : DataMapper<CategoryResponseEntity?, CategoryResponseModel?> {
    override fun entityToModel(entity: CategoryResponseEntity?): CategoryResponseModel? {
        return entity?.let { e ->
            CategoryResponseModel(
                category = transformCategory(e.category),
                brands = transformBrands(entity.brands),
                products = transformProducts(entity.products)
            )
        }
    }

    private fun transformCategory(category: CategoryEntity?): CategoryModel =
        CategoryModel(
            id = category?.id,
            name = category?.name,
            description = category?.description,
            logoUrl = category?.logoUrl,
            imageUrl = category?.imageUrl,
            productsCount = category?.productsCount,
            productsQuantity = category?.productsQuantity
        )

    private fun transformBrands(brands: List<ProductBrandEntity>?): List<ProductBrandModel> =
        brands?.map {
            ProductBrandModel(
                id = it.id,
                name = it.name,
                logoUrl = it.logoUrl
            )
        }.orEmpty()

    private fun transformProducts(products: List<ProductEntity>?): List<ProductModel> =
        products?.map {
            ProductModel(
                id = it.id,
                name = it.name,
                description = it.description,
                model = it.model,
                code = it.code,
                categoryId = it.categoryId,
                stock = it.stock,
                sellingPrice = it.productPrice?.selling,
                costPrice = it.productPrice?.cost,
                currencyId = it.productPrice?.currencyId,
                brandName = it.brand?.name,
                brandLogoUrl = it.brand?.logoUrl
            )
        }.orEmpty()

}

