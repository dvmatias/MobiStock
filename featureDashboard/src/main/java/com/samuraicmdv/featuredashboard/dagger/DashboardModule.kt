package com.samuraicmdv.featuredashboard.dagger

import android.content.Context
import com.samuraicmdv.featuredashboard.transformer.DashboardUiDataTransformer
import com.samuraicmdv.featuredashboard.transformer.DashboardUiDataTransformerImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DashboardModule {
    @Provides
    fun provideHomeUiDataTransformer(
        @ApplicationContext context: Context
    ): DashboardUiDataTransformer = DashboardUiDataTransformerImpl(context)
}