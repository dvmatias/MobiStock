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
    backgroundTertiary: Color,
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
) {
    var backgroundPrimary by mutableStateOf(backgroundPrimary)
        private set
    var backgroundSecondary by mutableStateOf(backgroundSecondary)
        private set
    var backgroundTertiary by mutableStateOf(backgroundTertiary)
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

    fun copy() = MobiStockColors(
        // background
        backgroundPrimary = backgroundPrimary,
        backgroundSecondary = backgroundSecondary,
        backgroundTertiary = backgroundTertiary,
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

        // border
        borderDefault = borderDefault,
        borderSubtle = borderSubtle,
        borderStrong = borderStrong,
        borderInverse = borderInverse,
        borderDisabled = borderDisabled,
        borderOnColor = borderOnColor,
        borderAccent = borderAccent,
        borderAttention = borderAttention,
        borderSuccess = borderSuccess,

        // scrim
        scrim = scrim,

        // loading
        loadingFill = loadingFill
    )

    fun update(other: MobiStockColors) = other.also {
        MobiStockColors(
            backgroundPrimary = backgroundPrimary,
            backgroundSecondary = backgroundSecondary,
            backgroundDisabled = backgroundDisabled,
            backgroundTertiary = backgroundTertiary,
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
            borderStrong = borderStrong,
            borderInverse = borderInverse,
            borderDisabled = borderDisabled,
            borderOnColor = borderOnColor,
            borderAccent = borderAccent,
            borderAttention = borderAttention,
            borderSuccess = borderSuccess,


            scrim = scrim,


            loadingFill = loadingFill
        )
    }
}

internal val lightMobiStockColors = MobiStockColors(
    // background colors
    backgroundPrimary = NEUTRAL_100,
    backgroundSecondary = NEUTRAL_200,
    backgroundTertiary = NEUTRAL_300,
    backgroundDisabled = NEUTRAL_400,
    backgroundInverse = NEUTRAL_700,
    backgroundAccent = BLUE_500,
    backgroundAttention = RED_600,
    backgroundSuccess = KIWI_600,

    // foreground colors
    foregroundPrimary = NEUTRAL_800,
    foregroundSecondary = NEUTRAL_600,
    foregroundDisabled = NEUTRAL_400,
    foregroundAccent = BLUE_500,
    foregroundAttention = RED_600,
    foregroundSuccess = KIWI_600,
    foregroundOnColor = NEUTRAL_100,
    foregroundVisited = PINK_600,

    // border colors
    borderDefault = NEUTRAL_500,
    borderSubtle = NEUTRAL_300,
    borderStrong = NEUTRAL_800,
    borderInverse = NEUTRAL_100,
    borderDisabled = NEUTRAL_400,
    borderOnColor = NEUTRAL_100,
    borderAccent = BLUE_500,
    borderAttention = RED_600,
    borderSuccess = KIWI_600,

    // scrim
    scrim = NEUTRAL_900,

    // loading
    loadingFill = Color(0xFFF2F2F2)
)

internal val darkMobiStockColors = MobiStockColors(
    // background
    backgroundPrimary = NEUTRAL_900,
    backgroundSecondary = NEUTRAL_800,
    backgroundTertiary = NEUTRAL_700,
    backgroundDisabled = NEUTRAL_500,
    backgroundInverse = NEUTRAL_300,
    backgroundAccent = BLUE_400,
    backgroundAttention = RED_400,
    backgroundSuccess = KIWI_500,

    // foreground
    foregroundPrimary = NEUTRAL_200,
    foregroundSecondary = NEUTRAL_500,
    foregroundDisabled = NEUTRAL_600,
    foregroundAccent = BLUE_400,
    foregroundAttention = RED_400,
    foregroundSuccess = KIWI_500,
    foregroundOnColor = NEUTRAL_800,
    foregroundVisited = PINK_400,

    // border
    borderDefault = NEUTRAL_600,
    borderSubtle = NEUTRAL_700,
    borderStrong = NEUTRAL_100,
    borderInverse = NEUTRAL_100,
    borderDisabled = NEUTRAL_500,
    borderOnColor = NEUTRAL_800,
    borderAccent = BLUE_300,
    borderAttention = RED_400,
    borderSuccess = KIWI_500,

    // scrim
    scrim = NEUTRAL_900,

    // loading
    loadingFill = Color(0xFF1B1B1B)
)

internal fun getColorScheme(colorScheme: MobiStockColors): ColorScheme =
    ColorScheme(
        primary = colorScheme.backgroundPrimary,
        onPrimary = colorScheme.foregroundPrimary,
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