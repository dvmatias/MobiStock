package com.samuraicmdv.domain.usecase

import com.samuraicmdv.domain.model.UserProfileResponseModel
import com.samuraicmdv.domain.repository.HomeRepository
import javax.inject.Inject

class GetUserProfileUseCase @Inject constructor(
    private val homeRepository: HomeRepository
) {

    suspend operator fun invoke(params: Params): UserProfileResponseModel {
        return homeRepository.getProfile(params.userId).let { response ->
            response.getOrNull() ?: UserProfileResponseModel() // TODO handle failure scenario
        }
    }

    data class Params(val userId: Int)

}