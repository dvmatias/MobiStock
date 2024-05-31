package com.samuraicmdv.domain.usecase

import com.samuraicmdv.domain.model.ProductBrandsResponseModel
import com.samuraicmdv.domain.repository.BrandRepository
import javax.inject.Inject

class GetProductBrandsUseCase @Inject constructor(
    private val repository: BrandRepository,
) {

    suspend operator fun invoke(params: Params): ProductBrandsResponseModel {
        return repository.getProductBrands(params.storeId)
            .let { responseWrapper ->
                responseWrapper.getOrNull()
                    ?: ProductBrandsResponseModel() // TODO handle failure scenario
            }
    }

    data class Params(val storeId: Int)
}