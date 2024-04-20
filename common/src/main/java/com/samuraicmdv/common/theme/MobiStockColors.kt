package com.samuraicmdv.common.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color

@Stable
class MobiStockColors(
    backgroundPrimary: Color,
    backgroundSecondary: Color,
    backgroundDisabled: Color,
    backgroundInverse: Color,
    backgroundAccent: Color,
    backgroundAttention: Color,
    backgroundSuccess: Color,

    // foreground colors
    foregroundPrimary: Color,
    foregroundSecondary: Color,
    foregroundDisabled: Color,
    foregroundAccent: Color,
    foregroundAttention: Color,
    foregroundSuccess: Color,
    foregroundOnColor: Color,
    foregroundVisited: Color,

    // border colors
    borderDefault: Color,
    borderSubtle: Color,
    borderStrong: Color,
    borderInverse: Color,
    borderDisabled: Color,
    borderOnColor: Color,
    borderAccent: Color,
    borderAttention: Color,
    borderSuccess: Color,

    // scrim colors
    scrim: Color,

    // loading colors
    loadingFill: Color,
    loadingShimmer0: Color,
    loadingShimmer1: Color,
    loadingShimmer2: Color,
    loadingShimmer3: Color,
    loadingFillElevated: Color,
    loadingShimmerElevated0: Color,
    loadingShimmerElevated1: Color,
    loadingShimmerElevated2: Color,
) {
    var backgroundPrimary by mutableStateOf(backgroundPrimary)
        private set
    var backgroundSecondary by mutableStateOf(backgroundSecondary)
        private set
    var backgroundDisabled by mutableStateOf(backgroundDisabled)
        private set
    var backgroundInverse by mutableStateOf(backgroundInverse)
        private set
    var backgroundAccent by mutableStateOf(backgroundAccent)
        private set
    var backgroundAttention by mutableStateOf(backgroundAttention)
        private set
    var backgroundSuccess by mutableStateOf(backgroundSuccess)
        private set
    var foregroundPrimary by mutableStateOf(foregroundPrimary)
        private set
    var foregroundSecondary by mutableStateOf(foregroundSecondary)
        private set
    var foregroundDisabled by mutableStateOf(foregroundDisabled)
        private set
    var foregroundAccent by mutableStateOf(foregroundAccent)
        private set
    var foregroundAttention by mutableStateOf(foregroundAttention)
        private set
    var foregroundSuccess by mutableStateOf(foregroundSuccess)
        private set
    var foregroundOnColor by mutableStateOf(foregroundOnColor)
        private set
    var foregroundVisited by mutableStateOf(foregroundVisited)
        private set

    // border colors
    var borderDefault by mutableStateOf(borderDefault)
        private set
    var borderSubtle by mutableStateOf(borderSubtle)
        private set
    var borderStrong by mutableStateOf(borderStrong)
        private set
    var borderInverse by mutableStateOf(borderInverse)
        private set
    var borderDisabled by mutableStateOf(borderDisabled)
        private set
    var borderOnColor by mutableStateOf(borderOnColor)
        private set
    var borderAccent by mutableStateOf(borderAccent)
        private set
    var borderAttention by mutableStateOf(borderAttention)
        private set
    var borderSuccess by mutableStateOf(borderSuccess)
        private set

    // scrim colors
    var scrim by mutableStateOf(scrim)
        private set

    // loading colors
    var loadingFill by mutableStateOf(loadingFill)
        private set
    var loadingShimmer0 by mutableStateOf(loadingShimmer0)
        private set
    var loadingShimmer1 by mutableStateOf(loadingShimmer1)
        private set
    var loadingShimmer2 by mutableStateOf(loadingShimmer2)
        private set
    var loadingShimmer3 by mutableStateOf(loadingShimmer3)
        private set
    var loadingFillElevated by mutableStateOf(loadingFillElevated)
        private set
    var loadingShimmerElevated0 by mutableStateOf(loadingShimmerElevated0)
        private set
    var loadingShimmerElevated1 by mutableStateOf(loadingShimmerElevated1)
        private set
    var loadingShimmerElevated2 by mutableStateOf(loadingShimmerElevated2)
        private set

    fun copy() = MobiStockColors(
        // background
        backgroundPrimary = backgroundPrimary,
        backgroundSecondary = backgroundSecondary,
        backgroundDisabled = backgroundDisabled,
        backgroundInverse = backgroundInverse,
        backgroundAccent = backgroundAccent,
        backgroundAttention = backgroundAttention,
        backgroundSuccess = backgroundSuccess,

        // foreground
        foregroundPrimary = foregroundPrimary,
        foregroundSecondary = foregroundSecondary,
        foregroundDisabled = foregroundDisabled,
        foregroundAccent = foregroundAccent,
        foregroundAttention = foregroundAttention,
        foregroundSuccess = foregroundSuccess,
        foregroundOnColor = foregroundOnColor,
        foregroundVisited = foregroundVisited,

        borderDefault = borderDefault,
        borderSubtle = borderSubtle,
        borderStrong,
        borderInverse,
        borderDisabled,
        borderOnColor,
        borderAccent,
        borderAttention,
        borderSuccess,
        scrim,
        loadingFill,
        loadingShimmer0,
        loadingShimmer1,
        loadingShimmer2,
        loadingShimmer3,
        loadingFillElevated,
        loadingShimmerElevated0,
        loadingShimmerElevated1,
        loadingShimmerElevated2

    )

    fun update(other: MobiStockColors) = other.also {
        MobiStockColors(
            backgroundPrimary = backgroundPrimary,
            backgroundSecondary = backgroundSecondary,
            backgroundDisabled = backgroundDisabled,
            backgroundInverse = backgroundInverse,
            backgroundAccent = backgroundAccent,
            backgroundAttention = backgroundAttention,
            backgroundSuccess = backgroundSuccess,
            foregroundPrimary = foregroundPrimary,
            foregroundSecondary = foregroundSecondary,
            foregroundDisabled = foregroundDisabled,
            foregroundAccent = foregroundAccent,
            foregroundAttention = foregroundAttention,
            foregroundSuccess = foregroundSuccess
        )
    }
}

internal val lightMobiStockColors = MobiStockColors(
    backgroundPrimary = B0,
    backgroundSecondary = B1,
    backgroundDisabled = B3,
    backgroundInverse = B6,
    backgroundAccent = MOBI_1,
    backgroundAttention = Color(0xFFFF9800),
    backgroundSuccess = Color(0xFFFF9800),
    foregroundPrimary = B7,
    foregroundSecondary = B5,
    foregroundDisabled = B3,
    foregroundAccent = Color(0xFFFF9800),
    foregroundAttention = Color(0xFFFF9800),
    foregroundSuccess = Color(0xFFFF9800)
)

internal val darkMobiStockColors = MobiStockColors(
    backgroundPrimary = B8,
    backgroundSecondary = B7,
    backgroundDisabled = B5,
    backgroundInverse = B2,
    backgroundAccent = MOBI_1,
    backgroundAttention = Color(0xFFFF9800),
    backgroundSuccess = Color(0xFFFF9800),
    foregroundPrimary = B1,
    foregroundSecondary = B4,
    foregroundDisabled = B5,
    foregroundAccent = Color(0xFFFF9800),
    foregroundAttention = Color(0xFFFF9800),
    foregroundSuccess = Color(0xFFFF9800)
)

internal fun getColorScheme(colorScheme: MobiStockColors): ColorScheme =
    ColorScheme(
        primary = colorScheme.backgroundPrimary,
        onPrimary = colorScheme.backgroundPrimary,
        primaryContainer = colorScheme.backgroundPrimary,
        onPrimaryContainer = colorScheme.backgroundPrimary,
        inversePrimary = colorScheme.backgroundPrimary,
        secondary = colorScheme.backgroundPrimary,
        onSecondary = colorScheme.backgroundPrimary,
        secondaryContainer = colorScheme.backgroundPrimary,
        onSecondaryContainer = colorScheme.backgroundPrimary,
        tertiary = colorScheme.backgroundPrimary,
        onTertiary = colorScheme.backgroundPrimary,
        tertiaryContainer = colorScheme.backgroundPrimary,
        onTertiaryContainer = colorScheme.backgroundPrimary,
        background = colorScheme.backgroundPrimary,
        onBackground = colorScheme.backgroundPrimary,
        surface = colorScheme.backgroundPrimary,
        onSurface = colorScheme.backgroundPrimary,
        surfaceVariant = colorScheme.backgroundPrimary,
        onSurfaceVariant = colorScheme.backgroundPrimary,
        surfaceTint = colorScheme.backgroundPrimary,
        inverseSurface = colorScheme.backgroundPrimary,
        inverseOnSurface = colorScheme.backgroundPrimary,
        error = colorScheme.backgroundPrimary,
        onError = colorScheme.backgroundPrimary,
        errorContainer = colorScheme.backgroundPrimary,
        onErrorContainer = colorScheme.backgroundPrimary,
        outline = colorScheme.backgroundPrimary,
        outlineVariant = colorScheme.backgroundPrimary,
        scrim = colorScheme.backgroundPrimary,
    )