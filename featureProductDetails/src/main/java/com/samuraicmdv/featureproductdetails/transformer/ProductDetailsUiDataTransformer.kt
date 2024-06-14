package com.samuraicmdv.featureproductdetails.transformer

import com.samuraicmdv.common.R
import com.samuraicmdv.common.utils.ProductCategory
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
                nameResId = getProductCategoryNameResource(category.type),
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
                    nameResId = getProductCategoryNameResource(it.type),
                    description = it.description ?: "",
                    logoUrl = it.logoUrl ?: "",
                )
            },
        )

    private fun getProductCategoryNameResource(productCategory: ProductCategory?): Int =
        when (productCategory) {
            ProductCategory.UNKNOWN -> R.string.product_category_unknown_name
            ProductCategory.HEADPHONE -> R.string.product_category_headphone_name
            ProductCategory.CHARGER_PHONE -> R.string.product_category_charger_phone_name
            ProductCategory.CHARGER_CAR -> R.string.product_category_charger_car_name
            ProductCategory.ARMBAND -> R.string.product_category_armband_name
            ProductCategory.HEADPHONE_BT -> R.string.product_category_headphone_bt_name
            ProductCategory.HEADSET -> R.string.product_category_headset_name
            ProductCategory.CABLE_USB -> R.string.product_category_cable_usb_name
            ProductCategory.CABLE_DATA -> R.string.product_category_cable_data_name
            ProductCategory.CABLE_AUXILIARY -> R.string.product_category_cable_auxiliary_name
            ProductCategory.CABLE_ADAPTER -> R.string.product_category_cable_adapter_name
            ProductCategory.PHONE_HOLDER_CAR -> R.string.product_category_phone_holder_car_name
            ProductCategory.PHONE_HOLDER_DESKTOP -> R.string.product_category_phone_holder_desktop_name
            ProductCategory.PHONE_HOLDER_CASE -> R.string.product_category_phone_holder_case_name
            ProductCategory.TRIPOD -> R.string.product_category_tripod_name
            ProductCategory.CABLE_PROTECTOR -> R.string.product_category_cable_protector_name
            ProductCategory.CHARGER_PROTECTOR -> R.string.product_category_charger_protector_name
            ProductCategory.STORAGE -> R.string.product_category_storage_name
            ProductCategory.INFORMATICS -> R.string.product_category_informatics_name
            ProductCategory.SPEAKER -> R.string.product_category_speaker_name
            ProductCategory.CHARGER_PORTABLE -> R.string.product_category_charger_portable_name
            ProductCategory.STICK -> R.string.product_category_stick_name
            ProductCategory.LIGHT -> R.string.product_category_light_name
            ProductCategory.SCREEN_PROTECTOR -> R.string.product_category_screen_protector_name
            ProductCategory.CAMERA_PROTECTOR -> R.string.product_category_camera_protector_name
            ProductCategory.STRAP -> R.string.product_category_strap_name
            ProductCategory.BATTERY -> R.string.product_category_battery_name
            ProductCategory.MICROPHONE -> R.string.product_category_microphone_name
            ProductCategory.HOME -> R.string.product_category_home_name
            ProductCategory.GAME -> R.string.product_category_game_name
            ProductCategory.OTHER -> R.string.product_category_other_name
            null -> R.string.product_category_unknown_name
        }
}