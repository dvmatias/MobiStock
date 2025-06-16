package com.samuraicmdv.featuredashboard.dagger

import android.content.Context
import com.samuraicmdv.featuredashboard.transformer.CategoriesUiDataTransformer
import com.samuraicmdv.featuredashboard.transformer.CategoriesUiDataTransformerImpl
import com.samuraicmdv.featuredashboard.transformer.DaySalesLedgerUiDataTransformer
import com.samuraicmdv.featuredashboard.transformer.DaySalesLedgerUiDataTransformerImpl
import com.samuraicmdv.featuredashboard.transformer.UserProfileUiDataTransformer
import com.samuraicmdv.featuredashboard.transformer.UserProfileUiDataTransformerImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DashboardModule {
    @Provides
    fun provideCategoriesUiDataTransformer(
        @ApplicationContext context: Context
    ): CategoriesUiDataTransformer = CategoriesUiDataTransformerImpl(context)

    @Provides
    fun provideUserProfileUiDataTransformer(): UserProfileUiDataTransformer = UserProfileUiDataTransformerImpl()

    @Provides
    fun provideDaySalesLedgerUiDataTransformer(): DaySalesLedgerUiDataTransformer = DaySalesLedgerUiDataTransformerImpl()
}