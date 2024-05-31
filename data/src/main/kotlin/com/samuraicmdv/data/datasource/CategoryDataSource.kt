package com.samuraicmdv.data.datasource

import com.samuraicmdv.domain.model.CategoryResponseModel
import com.samuraicmdv.domain.model.ProductCategoriesResponseModel
import com.samuraicmdv.domain.util.ResponseWrapper

/**
 * TODO
 */
interface CategoryDataSource {
    /**
     * TODO
     */
    suspend fun getCategory(storeId: Int, categoryId: Int): ResponseWrapper<CategoryResponseModel>

    /**
     * Gets the current user profile
     *
     * @param storeId Store unique identifier.
     * @param all When 'true' fetches all categories including categories without stock for the
     * current store. When 'false' it will only fetch product categories with product in stock
     */
    suspend fun getProductCategories(
        storeId: Int,
        all: Boolean,
    ): ResponseWrapper<ProductCategoriesResponseModel>
}