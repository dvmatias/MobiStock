package com.samuraicmdv.featuredashboard.transformer

import com.samuraicmdv.domain.model.UserProfileResponseModel
import com.samuraicmdv.featuredashboard.state.UserProfileUiData

/**
 * Transformer interface for converting UserProfileResponseModel to UserProfileUiData.
 */
interface UserProfileUiDataTransformer {
    fun transform(userProfile: UserProfileResponseModel): UserProfileUiData
}