package com.samuraicmdv.featurecategory.dagger

import com.samuraicmdv.featurecategory.transformer.CategoryUiDataTransformer
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object CategoryModule {
    @Provides
    fun provideCategoryUiDataTransformer(): CategoryUiDataTransformer = CategoryUiDataTransformer
}