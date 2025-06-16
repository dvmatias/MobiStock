package com.samuraicmdv.featurebarcodescanner

import com.samuraicmdv.featurebarcodescanner.transformer.ItemSummaryUiDataTransformer
import com.samuraicmdv.featurebarcodescanner.transformer.ItemSummaryUiDataTransformerImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object BarcodeScannerModule {
    @Provides
    fun provideItemSummaryUiDataTransformer(): ItemSummaryUiDataTransformer = ItemSummaryUiDataTransformerImpl()
}