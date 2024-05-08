package com.samuraicmdv.featurehome.dagger

import com.samuraicmdv.featurehome.transformer.HomeUiDataTransformer
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object HomeModule {
    @Provides
    fun provideHomeUiDataTransformer(): HomeUiDataTransformer = HomeUiDataTransformer
}