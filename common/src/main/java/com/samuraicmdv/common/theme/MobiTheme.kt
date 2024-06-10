package com.samuraicmdv.common.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable

object MobiTheme {
    val elevations: MobiElevations
        @Composable
        @ReadOnlyComposable
        get() = LocalMobiElevations.current

    val colors: MobiColors
        @Composable
        @ReadOnlyComposable
        get() = LocalMobiColors.current

    val typography: MobiTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalMobiTypography.current

    val dimens: MobiDimens
        @Composable
        @ReadOnlyComposable
        get() = LocalMobiDimens.current
}