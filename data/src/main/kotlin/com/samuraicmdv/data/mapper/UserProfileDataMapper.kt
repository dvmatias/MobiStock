package com.samuraicmdv.data.mapper

import com.samuraicmdv.data.entity.UserAddressEntity
import com.samuraicmdv.data.entity.UserEntity
import com.samuraicmdv.data.entity.GetUserProfileResponseEntity
import com.samuraicmdv.domain.base.DataMapper
import com.samuraicmdv.domain.model.UserAddressModel
import com.samuraicmdv.domain.model.UserModel
import com.samuraicmdv.domain.model.UserProfileResponseModel

object UserProfileDataMapper : DataMapper<GetUserProfileResponseEntity, UserProfileResponseModel> {

    override fun entityToModel(entity: GetUserProfileResponseEntity?): UserProfileResponseModel =
        UserProfileResponseModel(
            user = transformUser(entity?.user, entity?.user?.id)
        )

    private fun transformUser(userEntity: UserEntity?, currentSelectedUserId: Int?): UserModel? {
        val relatedUsers = userEntity?.relatedUsers?.mapNotNull {
            transformUser(it, userEntity.id)
        }
        return userEntity?.id?.let { userId ->
            UserModel(
                id = userId,
                address = transformAddress(userEntity.address),
                email = userEntity.email,
                logoUrl = userEntity.logoUrl,
                branchType = userEntity.branchType,
                name = userEntity.name,
                isCurrentSelected = currentSelectedUserId == userId,
                isAdmin = userEntity.isAdmin,
                relatedUsers = relatedUsers
            )
        }
    }


    private fun transformAddress(addressEntity: UserAddressEntity?): UserAddressModel? =
        addressEntity?.let { address ->
            UserAddressModel(
                city = address.city,
                country = address.country,
                line = address.line,
                province = address.province,
                zipCode = address.zipCode,
            )
        }
}