package com.samuraicmdv.data.repository

import com.samuraicmdv.data.datasource.CategoryDataSource
import com.samuraicmdv.domain.model.CategoryResponseModel
import com.samuraicmdv.domain.model.ProductCategoriesResponseModel
import com.samuraicmdv.domain.repository.CategoryRepository
import com.samuraicmdv.domain.util.ResponseWrapper
import javax.inject.Inject

class CategoryRepositoryImpl @Inject constructor(
    private val categoryDataSource: CategoryDataSource
) : CategoryRepository {
    override suspend fun getProductCategory(storeId: Int, categoryId: Int): ResponseWrapper<CategoryResponseModel> =
        categoryDataSource.getCategory(storeId, categoryId)

    override suspend fun getProductCategories(
        storeId: Int,
        all: Boolean,
    ): ResponseWrapper<ProductCategoriesResponseModel> =
        categoryDataSource.getProductCategories(storeId, all)
}