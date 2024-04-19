package com.samuraicmdv.common.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

object MobiStockTheme {
    val colors: MobiStockColors
        @Composable
        @ReadOnlyComposable
        get() = localMobiStockColors.current
    val dimens: MobiStockDimens
        @Composable
        @ReadOnlyComposable
        get() = localMobiStockDimens.current
}

private val localMobiStockColors = staticCompositionLocalOf<MobiStockColors> {
    error("No MobiSalesColors provided")
}

private val localMobiStockDimens = staticCompositionLocalOf<MobiStockDimens> {
    error("No MobiSalesDimens provided")
}

@Composable
fun MobiStockTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    isPreview: Boolean = true,
    content: @Composable () -> Unit
) {
    val dimens = mobiStockDimens()
    val colors = if (darkTheme) darkMobiStockColors else lightMobiStockColors
    val mobiSalesColors = remember { colors.copy() }.apply { update(colors) }

    val view = LocalView.current
    if (!view.isInEditMode && !isPreview) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colors.backgroundPrimary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = getColorScheme(colors),
        typography = Typography
    ) {
        CompositionLocalProvider(
            localMobiStockDimens provides dimens,
            localMobiStockColors provides mobiSalesColors,
            content = content,
        )
    }
}