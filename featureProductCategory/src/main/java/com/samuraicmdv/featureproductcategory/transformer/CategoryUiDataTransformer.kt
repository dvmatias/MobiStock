package com.samuraicmdv.featureproductcategory.transformer

import com.samuraicmdv.domain.model.CategoryModel
import com.samuraicmdv.domain.model.CategoryResponseModel
import com.samuraicmdv.domain.model.ProductModel
import com.samuraicmdv.featureproductcategory.state.CategoryScreenState
import com.samuraicmdv.featureproductcategory.state.CategoryUiData
import com.samuraicmdv.featureproductcategory.state.ProductBrandUiData
import com.samuraicmdv.featureproductcategory.state.ProductPriceUiData
import com.samuraicmdv.featureproductcategory.state.ProductUiData

object CategoryUiDataTransformer {
    fun transform(model: CategoryResponseModel): CategoryScreenState {

        return CategoryScreenState(
            category = transformCategory(model.category),
            products = transformProducts(model.products)
        )
    }

    private fun transformCategory(category: CategoryModel?): CategoryUiData? =
        category?.let {
            CategoryUiData(
                id = it.id ?: -1,
                name = it.name ?: "",
                description = it.description ?: "",
                logoUrl = it.logoUrl ?: "",
                imageUrl = it.imageUrl ?: "",
                productsCount = it.productsCount ?: 0,
                productsQuantity = it.productsQuantity ?: 0
            )
        }

    private fun transformProducts(products: List<ProductModel>?): List<ProductUiData> =
        products?.map {
            ProductUiData(
                id = it.id ?: -1,
                name = it.name ?: "",
                description = it.description ?: "",
                model = it.model ?: "",
                code = it.code ?: "",
                imageUrl = it.brandLogoUrl ?: "",
                price = ProductPriceUiData(
                    sellingPrice = it.sellingPrice?.toDouble() ?: 0.0,
                    costPrice = it.costPrice?.toDouble() ?: 0.0,
                    currency = it.currencyId ?: ""
                ),
                stock = it.stock ?: 0,
                rating = 0.0,
                reviews = 0,
                isFavorite = false,
                brand = ProductBrandUiData(
                    id = it.id ?: -1,
                    name = it.brandName ?: "",
                    logoUrl = it.brandLogoUrl ?: ""
                )
            )
        }.orEmpty()

}