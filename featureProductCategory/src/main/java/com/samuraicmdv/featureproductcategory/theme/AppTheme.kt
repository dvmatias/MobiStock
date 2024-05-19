package com.samuraicmdv.featureproductcategory.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable

object AppTheme {
    val dimens: AppDimens
        @Composable
        @ReadOnlyComposable
        get() = LocalAppDimens.current

    val colors: AppColors
        @Composable
        @ReadOnlyComposable
        get() = LocalAppColors.current

    val typography: AppTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalAppTypography.current
}