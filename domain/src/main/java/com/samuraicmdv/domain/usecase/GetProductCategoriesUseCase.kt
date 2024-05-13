package com.samuraicmdv.domain.usecase

import com.samuraicmdv.domain.model.ProductCategoriesResponseModel
import com.samuraicmdv.domain.repository.HomeRepository
import javax.inject.Inject

class GetProductCategoriesUseCase @Inject constructor(
    private val homeRepository: HomeRepository,
) {

    suspend operator fun invoke(params: Params): ProductCategoriesResponseModel {
        return homeRepository.getProductCategories(params.storeId, params.all)
            .let { responseWrapper ->
                responseWrapper.getOrNull()
                    ?: ProductCategoriesResponseModel() // TODO handle failure scenario
            }
    }

    data class Params(
        val storeId: Int,
        val all: Boolean = true,
    )
}