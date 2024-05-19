package com.samuraicmdv.domain.usecase

import com.samuraicmdv.domain.model.CategoryResponseModel
import com.samuraicmdv.domain.repository.CategoryRepository
import javax.inject.Inject

class GetCategoryUseCase @Inject constructor(
    private val repository: CategoryRepository
) {

    suspend operator fun invoke(storeId: Int, categoryId: Int): CategoryResponseModel {
        return repository.getCategory(storeId, categoryId)
            .let { responseWrapper ->
                responseWrapper.getOrNull()
                    ?: CategoryResponseModel() // TODO handle failure scenario
            }
    }

}
