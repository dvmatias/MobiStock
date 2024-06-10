package com.samuraicmdv.domain.usecase

import com.samuraicmdv.domain.model.GetBrandsResponseModel
import com.samuraicmdv.domain.repository.BrandRepository
import javax.inject.Inject

class GetBrandsUseCase @Inject constructor(
    private val repository: BrandRepository,
) {

    suspend operator fun invoke(params: Params): GetBrandsResponseModel {
        return repository.getBrands(params.storeId)
            .let { responseWrapper ->
                responseWrapper.getOrNull()
                    ?: GetBrandsResponseModel() // TODO handle failure scenario
            }
    }

    data class Params(val storeId: Int)
}