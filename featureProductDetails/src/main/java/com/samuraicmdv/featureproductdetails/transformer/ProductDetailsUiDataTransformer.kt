package com.samuraicmdv.featureproductdetails.transformer

import com.samuraicmdv.common.utils.getNameResId
import com.samuraicmdv.domain.model.GetBrandsResponseModel
import com.samuraicmdv.domain.model.ProductCategoriesResponseModel
import com.samuraicmdv.domain.model.ProductDetailsModel
import com.samuraicmdv.featureproductdetails.data.BrandUiData
import com.samuraicmdv.featureproductdetails.data.CategoryUiData
import com.samuraicmdv.featureproductdetails.data.ProductPriceUiData
import com.samuraicmdv.featureproductdetails.data.ProductUiData

object ProductDetailsUiDataTransformer {

    // TODO extract this out is also used in home transformer
    fun transformCategories(
        productCategoriesModel: ProductCategoriesResponseModel,
    ): List<CategoryUiData>? =
        productCategoriesModel.productCategories?.map { category ->
            CategoryUiData(
                id = category.id ?: -1,
                nameResId = category.type.getNameResId(),
                description = category.imageUrl ?: "",
                logoUrl = category.logoUrl ?: "",
            )
        }

    fun transformBrands(
        productBrandsModel: GetBrandsResponseModel
    ): List<BrandUiData>? =
        productBrandsModel.brands?.map {
            BrandUiData(
                id = it.id ?: -1,
                name = it.name ?: "",
                logoUrl = it.logoUrl ?: "",
            )
        }

    fun transformProduct(model: ProductDetailsModel?): ProductUiData =
        ProductUiData(
            id = model?.id ?: -1,
            name = model?.name ?: "",
            shortDescription = model?.shortDescription ?: "",
            longDescription = model?.longDescription ?: "",
            model = model?.model ?: "",
            code = model?.code ?: "",
            sku = model?.sku ?: "",
            thumbnailUrl = model?.thumbnailUrl ?: "",
            imageUrls = model?.imageUrls ?: emptyList(),
            price = model?.productPrice?.let {
                ProductPriceUiData(
                    sellingPrice = it.selling,
                    costPrice = it.cost,
                    preferredMargin = it.preferredMargin,
                )
            },
            brand = model?.brand?.let {
                BrandUiData(
                    id = it.id ?: -1,
                    name = it.name ?: "",
                    logoUrl = it.logoUrl ?: "",
                )
            },
            category = model?.category?.let {
                CategoryUiData(
                    id = it.id ?: -1,
                    nameResId = it.type.getNameResId(),
                    description = it.description ?: "",
                    logoUrl = it.logoUrl ?: "",
                )
            },
        )

}