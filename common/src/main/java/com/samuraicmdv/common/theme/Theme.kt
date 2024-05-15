package com.samuraicmdv.common.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

val lightScheme = lightColorScheme(
    primary = primaryLight,
    onPrimary = onPrimaryLight,
    primaryContainer = primaryContainerLight,
    onPrimaryContainer = onPrimaryContainerLight,
    secondary = secondaryLight,
    onSecondary = onSecondaryLight,
    secondaryContainer = secondaryContainerLight,
    onSecondaryContainer = onSecondaryContainerLight,
    tertiary = tertiaryLight,
    onTertiary = onTertiaryLight,
    tertiaryContainer = tertiaryContainerLight,
    onTertiaryContainer = onTertiaryContainerLight,
    error = errorLight,
    onError = onErrorLight,
    errorContainer = errorContainerLight,
    onErrorContainer = onErrorContainerLight,
    background = backgroundLight,
    onBackground = onBackgroundLight,
    surface = surfaceLight,
    onSurface = onSurfaceLight,
    surfaceVariant = surfaceVariantLight,
    onSurfaceVariant = onSurfaceVariantLight,
    outline = outlineLight,
    outlineVariant = outlineVariantLight,
    scrim = scrimLight,
    inverseSurface = inverseSurfaceLight,
    inverseOnSurface = inverseOnSurfaceLight,
    inversePrimary = inversePrimaryLight
)

val darkScheme = darkColorScheme( // TODO
    primary = Color(0xFFEC2B68),
    onPrimary = Color(0xFFEC2B68),
    primaryContainer = Color(0xFFEC2B68),
    onPrimaryContainer = Color(0xFFEC2B68),
    secondary = Color(0xFFEC2B68),
    onSecondary = Color(0xFFEC2B68),
    secondaryContainer = Color(0xFFEC2B68),
    onSecondaryContainer = Color(0xFFEC2B68),
    tertiary = Color(0xFFEC2B68),
    onTertiary = Color(0xFFEC2B68),
    tertiaryContainer = Color(0xFFEC2B68),
    onTertiaryContainer = Color(0xFFEC2B68),
    error = Color(0xFFEC2B68),
    onError = Color(0xFFEC2B68),
    errorContainer = Color(0xFFEC2B68),
    onErrorContainer = Color(0xFFEC2B68),
    background = Color(0xFFEC2B68),
    onBackground = Color(0xFFEC2B68),
    surface = Color(0xFFEC2B68),
    onSurface = Color(0xFFEC2B68),
    surfaceVariant = Color(0xFFEC2B68),
    onSurfaceVariant = Color(0xFFEC2B68),
    outline = Color(0xFFEC2B68),
    outlineVariant = Color(0xFFEC2B68),
    scrim = Color(0xFFEC2B68),
    inverseSurface = Color(0xFFEC2B68),
    inverseOnSurface = Color(0xFFEC2B68),
    inversePrimary = Color(0xFFEC2B68)
)

@Composable
fun MobiStockTheme(
    typography: MobiStockTypography = MobiStockTheme.typography,
    darkTheme: Boolean = isSystemInDarkTheme(),
    isPreview: Boolean = true,
    content: @Composable () -> Unit,
) {
    val dimens = mobiStockDimens()
    val colors = if (darkTheme) darkMobiStockColors else lightMobiStockColors
    val colorScheme: ColorScheme = when {
        darkTheme -> darkScheme
        else -> lightScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode && !isPreview) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }
    MaterialTheme(
        colorScheme = colorScheme
    ) {
        CompositionLocalProvider(
            LocalMobiStockColors provides colors,
            LocalMobiStockSpaces provides dimens,
            LocalMobiStockTypography provides typography
        ) {
            ProvideTextStyle(
                value = typography.bodyRegular.copy(color = MobiStockTheme.colors.foregroundPrimary),
                content = content
            )
        }
    }
}