package com.samuraicmdv.featurehome.transformer

import com.samuraicmdv.domain.model.UserModel
import com.samuraicmdv.domain.model.UserProfileResponseModel
import com.samuraicmdv.featurehome.data.BranchType
import com.samuraicmdv.featurehome.data.UserUiData
import com.samuraicmdv.featurehome.state.UserProfileUiData

object HomeUiDataTransformer {

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
                isAdmin = isAdmin ?: false, // TODO
                isCurrentSelected = isCurrentSelected ?: false,
            )
        }

    private fun getBranchType(branchType: String?): BranchType =
        when (branchType) {
            BranchType.SALES_BRANCH.name -> BranchType.SALES_BRANCH
            BranchType.DEPOSIT.name -> BranchType.DEPOSIT
            else -> BranchType.UNKNOWN
        }


}
