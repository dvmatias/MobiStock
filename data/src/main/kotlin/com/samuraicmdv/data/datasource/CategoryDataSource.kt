package com.samuraicmdv.data.datasource

import com.samuraicmdv.domain.model.CategoryResponseModel
import com.samuraicmdv.domain.util.ResponseWrapper

/**
 * TODO
 */
interface CategoryDataSource {
    /**
     * TODO
     */
    suspend fun getCategory(storeId: Int, categoryId: Int): ResponseWrapper<CategoryResponseModel>
}