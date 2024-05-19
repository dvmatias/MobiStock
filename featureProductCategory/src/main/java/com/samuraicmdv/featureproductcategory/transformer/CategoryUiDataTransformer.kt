package com.samuraicmdv.featureproductcategory.transformer

import com.samuraicmdv.common.utils.ProductCategory
import com.samuraicmdv.domain.model.CategoryModel
import com.samuraicmdv.domain.model.CategoryResponseModel
import com.samuraicmdv.domain.model.ProductModel
import com.samuraicmdv.common.R
import com.samuraicmdv.domain.model.ProductBrandModel
import com.samuraicmdv.featureproductcategory.state.CategoryScreenState
import com.samuraicmdv.featureproductcategory.state.CategoryUiData
import com.samuraicmdv.featureproductcategory.state.ProductBrandUiData
import com.samuraicmdv.featureproductcategory.state.ProductPriceUiData
import com.samuraicmdv.featureproductcategory.state.ProductUiData

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
                nameResId = getCategoryNameResId(it.type),
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
                imageUrl = "",
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
                    id = it.brand?.id ?: -1,
                    name = it.brand?.name ?: "",
                    logoUrl = it.brand?.logoUrl ?: ""
                )
            )
        }.orEmpty()

    private fun getCategoryNameResId(name: ProductCategory?): Int =
        when(name) {
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

    private fun transformBrands(brands: List<ProductBrandModel>?): List<ProductBrandUiData>? =
        brands?.map {
            ProductBrandUiData(
                id = it.id ?: -1,
                name = it.name ?: "",
                logoUrl = it.logoUrl ?: ""
            )
        }


}