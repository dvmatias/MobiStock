package com.samuraicmdv.data.mapper

import com.samuraicmdv.common.utils.ProductCategoryType
import com.samuraicmdv.common.utils.ProductSubcategoryType
import com.samuraicmdv.data.entity.BrandEntity
import com.samuraicmdv.data.entity.GetCategoryResponseEntity
import com.samuraicmdv.data.entity.ProductCategoryEntity
import com.samuraicmdv.data.entity.ProductEntity
import com.samuraicmdv.domain.base.EntityMapper
import com.samuraicmdv.domain.model.BrandModel
import com.samuraicmdv.domain.model.CategoryResponseModel
import com.samuraicmdv.domain.model.ProductCategoryModel
import com.samuraicmdv.domain.model.ProductModel
import com.samuraicmdv.domain.model.StockModel

object CategoryEntityMapper : EntityMapper<GetCategoryResponseEntity?, CategoryResponseModel?> {
    override fun map(entity: GetCategoryResponseEntity?): CategoryResponseModel? {
        return entity?.let { e ->
            CategoryResponseModel(
                category = transformCategory(e.category),
                brands = transformBrands(entity.brands),
                products = transformProducts(entity.products)
            )
        }
    }

    private fun transformCategory(category: ProductCategoryEntity?): ProductCategoryModel =
        ProductCategoryModel(
            id = category?.id,
            type = getProductCategoryType(category?.name),
            name = category?.name,
            description = category?.description,
            productsQuantity = null
        )

    private fun transformBrands(brands: List<BrandEntity>?): List<BrandModel> =
        brands?.map {
            transformBrand(it)
        }.orEmpty()

    private fun transformBrand(brand: BrandEntity): BrandModel =
        BrandModel(
            id = brand.id,
            name = brand.name,
            logoUrl = brand.logoUrl
        )

    private fun transformProducts(products: List<ProductEntity>?): List<ProductModel> =
        products?.map {
            ProductModel(
                id = it.id,
                name = it.name,
                shortDescription = it.shortDescription,
                longDescription = it.longDescription,
                model = it.model,
                code = it.code,
                thumbnailUrl = it.thumbnailUrl,
                sku = it.sku,
                imageUrls = it.imageUrls,
                categoryId = it.categoryId,
                stock = StockModel(
                    quantity = it.stock?.quantity,
                    low = it.stock?.low,
                    min = it.stock?.min
                ),
                productPrice = it.price?.toModel(),
                brandId = it.brandId
            )
        }.orEmpty()

    fun getProductCategoryType(productCategoryName: String?): ProductCategoryType =
        ProductCategoryType.entries.find {
            it.name == productCategoryName
        } ?: run {
            ProductCategoryType.UNKNOWN
        }

    fun getProductSubcategoryType(productSubcategoryName: String?): ProductSubcategoryType =
        ProductSubcategoryType.entries.find {
            it.name == productSubcategoryName
        } ?: run {
            ProductSubcategoryType.UNKNOWN
        }
}

