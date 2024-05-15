package com.samuraicmdv.common.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable

object MobiStockTheme {
    val elevations: MobiStockElevations
        @Composable
        @ReadOnlyComposable
        get() = LocalMobiStockElevations.current
    val colors: MobiStockColors
        @Composable
        @ReadOnlyComposable
        get() = LocalMobiStockColors.current

    val typography: MobiStockTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalMobiStockTypography.current
    
    val spaces: MobiStockSpaces
        @Composable
        @ReadOnlyComposable
        get() = LocalMobiStockSpaces.current
}