package com.samuraicmdv.domain.repository

import com.samuraicmdv.domain.model.CategoryResponseModel
import com.samuraicmdv.domain.model.GetCategoriesResponseModel
import com.samuraicmdv.domain.util.ResponseWrapper

interface CategoryRepository {
    suspend fun getProductCategory(
        storeId: Int,
        categoryId: Int
    ): ResponseWrapper<CategoryResponseModel>


    /**
     * Gets the item categories.
     *
     * @param storeId Store's unique identifier.
     * @param all Boolean flag to get all categories.
     */
    suspend fun getProductCategories(
        storeId: Int,
        all: Boolean,
    ): ResponseWrapper<GetCategoriesResponseModel>
}
