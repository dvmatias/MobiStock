package com.samuraicmdv.featuredashboard.transformer

import com.samuraicmdv.domain.model.ProductCategoriesResponseModel
import com.samuraicmdv.common.utils.ProductCategory
import com.samuraicmdv.common.utils.ProductCategory.*
import com.samuraicmdv.domain.model.UserModel
import com.samuraicmdv.domain.model.UserProfileResponseModel
import com.samuraicmdv.common.R
import com.samuraicmdv.featuredashboard.data.BranchType
import com.samuraicmdv.featuredashboard.data.UserUiData
import com.samuraicmdv.featuredashboard.state.DailySaleState
import com.samuraicmdv.featuredashboard.state.ProductCategoriesState
import com.samuraicmdv.featuredashboard.state.ProductCategoryUiData
import com.samuraicmdv.featuredashboard.state.UserProfileUiData

object DashboardUiDataTransformer {

    fun transformUserProfile(userProfile: UserProfileResponseModel): UserProfileUiData {
        val user = transformUser(userProfile.user)
        val relatedUsers = user?.let {
            listOf(it)
        }?.let { list ->
            list.plus(
                userProfile.user?.relatedUsers?.mapNotNull {
                    transformUser(it)
                } ?: emptyList()
            )
        }
        return UserProfileUiData(
            user = user,
            relatedUsers = relatedUsers
        )
    }

    private fun transformUser(user: UserModel?): UserUiData? =
        user?.run {
            UserUiData(
                id = id,
                name = name ?: "",
                address = "${address?.line}, ${address?.city}, ${address?.province}",
                logoUrl = logoUrl ?: "",
                branchType = getBranchType(branchType),
                isAdmin = isAdmin ?: false,
                isCurrentSelected = isCurrentSelected ?: false,
            )
        }

    private fun getBranchType(branchType: String?): BranchType =
        when (branchType) {
            BranchType.SALES_BRANCH.name -> BranchType.SALES_BRANCH
            BranchType.DEPOSIT.name -> BranchType.DEPOSIT
            else -> BranchType.UNKNOWN
        }

    fun transformProductCategories(
        productCategories: ProductCategoriesResponseModel,
    ): ProductCategoriesState? =
        productCategories.productCategories?.let { categories ->
            ProductCategoriesState(
                categories = categories.map {
                    ProductCategoryUiData(
                        id = it.id ?: -1,
                        nameResId = getProductCategoryNameResource(it.type),
                        imageUrl = it.imageUrl ?: "",
                        productsCount = it.productsCount ?: 0
                    )
                }
            )
        }

    fun transformDailySales(dailySales: Any?): DailySaleState? {
        // TODO
        return DailySaleState()
    }
    
    private fun getProductCategoryNameResource(productCategory: ProductCategory?): Int =
        when(productCategory) {
            UNKNOWN -> R.string.product_category_unknown_name
            HEADPHONE-> R.string.product_category_headphone_name
            CHARGER_PHONE-> R.string.product_category_charger_phone_name
            CHARGER_CAR-> R.string.product_category_charger_car_name
            ARMBAND-> R.string.product_category_armband_name
            HEADPHONE_BT-> R.string.product_category_headphone_bt_name
            HEADSET-> R.string.product_category_headset_name
            CABLE_USB-> R.string.product_category_cable_usb_name
            CABLE_DATA-> R.string.product_category_cable_data_name
            CABLE_AUXILIARY-> R.string.product_category_cable_auxiliary_name
            CABLE_ADAPTER-> R.string.product_category_cable_adapter_name
            PHONE_HOLDER_CAR-> R.string.product_category_phone_holder_car_name
            PHONE_HOLDER_DESKTOP-> R.string.product_category_phone_holder_desktop_name
            PHONE_HOLDER_CASE-> R.string.product_category_phone_holder_case_name
            TRIPOD-> R.string.product_category_tripod_name
            CABLE_PROTECTOR-> R.string.product_category_cable_protector_name
            CHARGER_PROTECTOR-> R.string.product_category_charger_protector_name
            STORAGE-> R.string.product_category_storage_name
            INFORMATICS-> R.string.product_category_informatics_name
            SPEAKER-> R.string.product_category_speaker_name
            CHARGER_PORTABLE-> R.string.product_category_charger_portable_name
            STICK-> R.string.product_category_stick_name
            LIGHT-> R.string.product_category_light_name
            SCREEN_PROTECTOR-> R.string.product_category_screen_protector_name
            CAMERA_PROTECTOR-> R.string.product_category_camera_protector_name
            STRAP-> R.string.product_category_strap_name
            BATTERY-> R.string.product_category_battery_name
            MICROPHONE-> R.string.product_category_microphone_name
            HOME-> R.string.product_category_home_name
            GAME-> R.string.product_category_game_name
            OTHER-> R.string.product_category_other_name
            null -> R.string.product_category_unknown_name
        }

}
