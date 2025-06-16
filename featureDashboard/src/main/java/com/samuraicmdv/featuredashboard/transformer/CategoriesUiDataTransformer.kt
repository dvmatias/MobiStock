package com.samuraicmdv.featuredashboard.transformer

import com.samuraicmdv.domain.model.GetCategoriesResponseModel
import com.samuraicmdv.featuredashboard.state.ProductCategoriesState

interface CategoriesUiDataTransformer {
    fun transform(model: GetCategoriesResponseModel): ProductCategoriesState
}