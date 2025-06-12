package com.samuraicmdv.featurebarcodescanner

import com.samuraicmdv.featurebarcodescanner.transformer.ProductDetailsUiDataTransformer
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object BarcodeScannerModule {
    @Provides
    fun provideProductDetailsUiDataTransformer(): ProductDetailsUiDataTransformer = ProductDetailsUiDataTransformer
}