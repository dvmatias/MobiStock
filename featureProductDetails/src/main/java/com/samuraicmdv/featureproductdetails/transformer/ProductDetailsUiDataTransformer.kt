package com.samuraicmdv.featureproductdetails.transformer

import com.samuraicmdv.common.uidata.CategoryUiData
import com.samuraicmdv.common.uidata.ProductBrandUiData
import com.samuraicmdv.common.uidata.ProductUiData
import com.samuraicmdv.common.utils.getNameResId
import com.samuraicmdv.domain.model.GetBrandsResponseModel
import com.samuraicmdv.domain.model.GetCategoriesResponseModel
import com.samuraicmdv.domain.model.ProductDetailsResponseModel

object ProductDetailsUiDataTransformer {

    // TODO extract this out is also used in home transformer
    fun transformCategories(
        productCategoriesModel: GetCategoriesResponseModel,
    ): List<CategoryUiData>? =
        productCategoriesModel.productCategories?.map { category ->
            CategoryUiData(
                id = category.id ?: -1,
                nameResId = category.type.getNameResId(),
                description = ""
            )
        }

    fun transformBrands(
        productBrandsModel: GetBrandsResponseModel
    ): List<ProductBrandUiData>? =
        productBrandsModel.brands?.map {
            ProductBrandUiData(
                id = it.id ?: -1,
                name = it.name ?: "",
                logoUrl = it.logoUrl ?: "",
            )
        }

    fun transformProduct(model: ProductDetailsResponseModel?): ProductUiData {
//        val item = model?.item
//        val brand = model?.brand
//        val category = model?.category
//        return ProductUiData(
//            id = item?.id ?: -1,
//            name = item?.name ?: "",
//            shortDescription = item?.shortDescription ?: "",
//            longDescription = item?.longDescription ?: "",
//            model = item?.model ?: "",
//            code = item?.code ?: "",
//            sku = item?.sku ?: "",
//            thumbnailUrl = item?.thumbnailUrl ?: "",
//            imageUrls = item?.imageUrls ?: emptyList(),
//            price = item?.productPrice?.let {
//                ProductPriceUiData(
//                    sellingPrice = it.selling,
//                    costPrice = it.cost,
////                    preferredMargin = it.preferredMargin, /TODO
//                )
//            },
//            brand = brand?.let {
//                ProductBrandUiData(
//                    id = it.id ?: -1,
//                    name = it.name ?: "",
//                    logoUrl = it.logoUrl ?: "",
//                )
//            },
//            category = category?.let {
//                CategoryUiData(
//                    id = it.id ?: -1,
//                    nameResId = it.type.getNameResId(),
//                    description = it.description ?: "",
//                )
//            },
//        )
        TODO()
    }
}