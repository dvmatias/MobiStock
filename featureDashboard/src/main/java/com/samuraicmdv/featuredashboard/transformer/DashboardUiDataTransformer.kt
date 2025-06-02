package com.samuraicmdv.featuredashboard.transformer

import android.content.Context
import androidx.appcompat.content.res.AppCompatResources
import com.samuraicmdv.common.utils.getIconResId
import com.samuraicmdv.common.utils.getNameResId
import com.samuraicmdv.domain.model.ProductCategoriesResponseModel
import com.samuraicmdv.domain.model.UserModel
import com.samuraicmdv.domain.model.UserProfileResponseModel
import com.samuraicmdv.featuredashboard.data.BranchType
import com.samuraicmdv.featuredashboard.data.UserUiData
import com.samuraicmdv.featuredashboard.state.DailySaleState
import com.samuraicmdv.featuredashboard.state.ProductCategoriesState
import com.samuraicmdv.featuredashboard.state.ProductCategoryUiData
import com.samuraicmdv.featuredashboard.state.ProductSubcategoryUiData
import com.samuraicmdv.featuredashboard.state.UserProfileUiData
import javax.inject.Inject

class DashboardUiDataTransformer @Inject constructor(
    private val context: Context
) {

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
                        name = context.getString(it.type.getNameResId()),
                        imageUrl = it.imageUrl,
                        iconDrawable = AppCompatResources.getDrawable(context, it.type.getIconResId()),
                        productsQuantity = it.productsQuantity ?: 0,
                        subcategories = it.subcategories?.map { subcategory ->
                            ProductSubcategoryUiData(
                                id = subcategory.id ?: -1,
                                name = context.getString(subcategory.type.getNameResId()),
                                imageUrl = subcategory.imageUrl,
                                iconDrawable = AppCompatResources.getDrawable(context, subcategory.type.getIconResId()),
                                productsQuantity = subcategory.productsQuantity ?: 0
                            )
                        },
                    )
                },
                isLoading = false
            )
        }

    fun transformDailySales(dailySales: Any?): DailySaleState? {
        // TODO
        return DailySaleState()
    }

}
