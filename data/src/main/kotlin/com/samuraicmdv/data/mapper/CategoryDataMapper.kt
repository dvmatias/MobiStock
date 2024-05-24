package com.samuraicmdv.data.mapper

import com.samuraicmdv.common.utils.ProductCategory
import com.samuraicmdv.data.entity.CategoryEntity
import com.samuraicmdv.data.entity.CategoryResponseEntity
import com.samuraicmdv.data.entity.ProductBrandEntity
import com.samuraicmdv.data.entity.ProductEntity
import com.samuraicmdv.domain.base.DataMapper
import com.samuraicmdv.domain.model.CategoryModel
import com.samuraicmdv.domain.model.CategoryResponseModel
import com.samuraicmdv.domain.model.ProductBrandModel
import com.samuraicmdv.domain.model.ProductModel
import com.samuraicmdv.domain.model.ProductStockModel

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
            type = getProductCategoryType(category?.name),
            name = category?.name,
            description = category?.description,
            logoUrl = category?.logoUrl,
            imageUrl = category?.imageUrl,
            productsCount = category?.productsCount,
            productsQuantity = category?.productsQuantity
        )

    private fun transformBrands(brands: List<ProductBrandEntity>?): List<ProductBrandModel> =
        brands?.map {
            transformBrand(it)
        }.orEmpty()

    private fun transformBrand(brand: ProductBrandEntity): ProductBrandModel =
        ProductBrandModel(
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
                stock = ProductStockModel(
                    quantity = it.stock?.quantity,
                    low = it.stock?.low,
                    min = it.stock?.min
                ),
                sellingPrice = it.productPrice?.selling,
                costPrice = it.productPrice?.cost,
                currencyId = it.productPrice?.currencyId,
                brand = it.brand?.let { brand ->
                    transformBrand(brand)
                }
            )
        }.orEmpty()

    private fun getProductCategoryType(productCategoryName: String?): ProductCategory =
        ProductCategory.entries.find {
            it.name == productCategoryName
        } ?: run {
            ProductCategory.UNKNOWN
        }
}

