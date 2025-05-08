package com.samuraicmdv.featuredashboard.dagger

import com.samuraicmdv.featuredashboard.transformer.DashboardUiDataTransformer
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DashboardModule {
    @Provides
    fun provideHomeUiDataTransformer(): DashboardUiDataTransformer = DashboardUiDataTransformer
}