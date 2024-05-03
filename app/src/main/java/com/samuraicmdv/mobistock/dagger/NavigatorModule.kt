package com.samuraicmdv.mobistock.dagger

import com.samuraicmdv.common.navigation.Navigator
import com.samuraicmdv.mobistock.navigation.NavigatorImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object NavigatorModule {
    @Provides
    fun provideNavigator(): Navigator = NavigatorImpl()
}