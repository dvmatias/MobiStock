package com.samuraicmdv.data.repository

import com.samuraicmdv.data.datasource.CategoryDataSource
import com.samuraicmdv.domain.model.CategoryResponseModel
import com.samuraicmdv.domain.repository.CategoryRepository
import com.samuraicmdv.domain.util.ResponseWrapper
import javax.inject.Inject

class CategoryRepositoryImpl @Inject constructor(
    private val categoryDataSource: CategoryDataSource
) : CategoryRepository {
    override suspend fun getCategory(storeId: Int, categoryId: Int): ResponseWrapper<CategoryResponseModel> =
        categoryDataSource.getCategory(storeId, categoryId)
}