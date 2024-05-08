package com.samuraicmdv.data.mapper

import com.samuraicmdv.data.entity.UserAddressEntity
import com.samuraicmdv.data.entity.UserEntity
import com.samuraicmdv.data.entity.UserProfileResponseEntity
import com.samuraicmdv.domain.base.DataMapper
import com.samuraicmdv.domain.model.UserAddressModel
import com.samuraicmdv.domain.model.UserModel
import com.samuraicmdv.domain.model.UserProfileResponseModel

object UserProfileDataMapper : DataMapper<UserProfileResponseEntity, UserProfileResponseModel> {

    override fun entityToModel(entity: UserProfileResponseEntity?): UserProfileResponseModel =
        UserProfileResponseModel(
            user = transformUser(entity?.user)
        )

    private fun transformUser(userEntity: UserEntity?): UserModel? {
        val relatedUsers = userEntity?.relatedUsers?.mapNotNull {
            transformUser(it)
        }
        return userEntity?.id?.let { userId ->
            UserModel(
                id = userId,
                address = transformAddress(userEntity.address),
                email = userEntity.email,
                logoUrl = userEntity.logoUrl,
                name = userEntity.name,
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