package com.samuraicmdv.domain.repository

import com.samuraicmdv.domain.model.CategoryResponseModel
import com.samuraicmdv.domain.util.ResponseWrapper

interface CategoryRepository {
    suspend fun getCategory(
        storeId: Int,
        categoryId: Int
    ): ResponseWrapper<CategoryResponseModel>
}
