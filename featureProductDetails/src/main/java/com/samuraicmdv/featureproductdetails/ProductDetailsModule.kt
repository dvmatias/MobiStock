package com.samuraicmdv.featureproductdetails

import com.samuraicmdv.featureproductdetails.transformer.ProductDetailsUiDataTransformer
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object ProductDetailsModule {
    @Provides
    fun provideProductDetailsUiDataTransformer(): ProductDetailsUiDataTransformer = ProductDetailsUiDataTransformer
}