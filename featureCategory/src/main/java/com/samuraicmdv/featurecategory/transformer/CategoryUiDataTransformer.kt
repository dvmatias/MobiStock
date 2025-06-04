package com.samuraicmdv.featurecategory.transformer

import com.samuraicmdv.common.uidata.ProductBrandUiData
import com.samuraicmdv.common.uidata.ProductPriceUiData
import com.samuraicmdv.common.uidata.ProductStockUiData
import com.samuraicmdv.common.uidata.ProductUiData
import com.samuraicmdv.common.utils.getNameResId
import com.samuraicmdv.domain.model.BrandModel
import com.samuraicmdv.domain.model.CategoryModel
import com.samuraicmdv.domain.model.CategoryResponseModel
import com.samuraicmdv.domain.model.ProductModel
import com.samuraicmdv.featurecategory.state.CategoryScreenState
import com.samuraicmdv.featurecategory.state.CategoryUiData

object CategoryUiDataTransformer {
    fun transform(model: CategoryResponseModel): CategoryScreenState {

        return CategoryScreenState(
            category = transformCategory(model.category),
            products = transformProducts(model.products),
            brands = transformBrands(model.brands)
        )
    }

    private fun transformCategory(category: CategoryModel?): CategoryUiData? =
        category?.let {
            CategoryUiData(
                id = it.id ?: -1,
                nameResId = it.type.getNameResId(),
                description = it.description ?: "",
                logoUrl = it.logoUrl ?: "",
                imageUrl = it.imageUrl ?: "",
                productsQuantity = it.productsQuantity ?: 0
            )
        }

    private fun transformProducts(products: List<ProductModel>?): List<ProductUiData> =
        products?.map {
            ProductUiData(
                id = it.id ?: -1,
                name = it.name ?: "",
                shortDescription = it.shortDescription ?: "",
                longDescription = it.longDescription ?: "",
                model = it.model ?: "-",
                code = it.code ?: "-",
                sku = it.sku ?: "-",
                thumbnailUrl = it.thumbnailUrl,
                imageUrls = it.imageUrls ?: emptyList(),
                price = ProductPriceUiData(
                    sellingPrice = it.productPrice?.selling ?: 0.0,
                    costPrice = it.productPrice?.cost ?: 0.0,
                    currency = (it.productPrice?.currencyId ?: 1).toString() // TODO transform currency ID into currency name/symbol
                ),
                stock = ProductStockUiData(
                    quantity = it.stock?.quantity,
                    low = it.stock?.low,
                    min = it.stock?.min
                ),
                rating = 0.0,
                reviews = 0,
                isFavorite = false,
                brand = ProductBrandUiData(
                    id = it.brand?.id ?: -1,
                    name = it.brand?.name ?: "",
                    logoUrl = it.brand?.logoUrl ?: ""
                )
            )
        }.orEmpty()

    private fun transformBrands(brands: List<BrandModel>?): List<ProductBrandUiData>? =
        brands?.map {
            ProductBrandUiData(
                id = it.id ?: -1,
                name = it.name ?: "",
                logoUrl = it.logoUrl ?: ""
            )
        }


}