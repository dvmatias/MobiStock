@file:Suppress("MemberVisibilityCanBePrivate")

package com.samuraicmdv.common.theme

import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Stable
class MobiStockColors(
    brandPrimary: Color,

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
    foregroundTertiary: Color,
    foregroundDisabled: Color,
    foregroundAccent: Color,
    foregroundAttention: Color,
    foregroundSuccess: Color,
    foregroundOnColor: Color,
    foregroundVisited: Color,
    foregroundError: Color,

    linkEnabled: Color,
    linkDisabled: Color,
    linkVisited: Color,

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
    var brandPrimary by mutableStateOf(brandPrimary)
        private set

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
    var foregroundTertiary by mutableStateOf(foregroundTertiary)
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
    var foregroundError by mutableStateOf(foregroundError)
        private set

    var linkEnabled by mutableStateOf(linkEnabled)
        private set
    var linkDisabled by mutableStateOf(linkDisabled)
        private set
    var linkVisited by mutableStateOf(linkVisited)
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
        brandPrimary = brandPrimary,

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
        foregroundTertiary = foregroundTertiary,
        foregroundDisabled = foregroundDisabled,
        foregroundAccent = foregroundAccent,
        foregroundAttention = foregroundAttention,
        foregroundSuccess = foregroundSuccess,
        foregroundOnColor = foregroundOnColor,
        foregroundVisited = foregroundVisited,
        foregroundError = foregroundError,

        linkEnabled = linkEnabled,
        linkDisabled = linkDisabled,
        linkVisited = linkVisited,

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
            brandPrimary = brandPrimary,

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
            foregroundTertiary = foregroundTertiary,
            foregroundDisabled = foregroundDisabled,
            foregroundAccent = foregroundAccent,
            foregroundAttention = foregroundAttention,
            foregroundSuccess = foregroundSuccess,
            foregroundOnColor = foregroundOnColor,
            foregroundVisited = foregroundVisited,
            foregroundError = foregroundError,

            linkEnabled = linkEnabled,
            linkDisabled = linkDisabled,
            linkVisited = linkVisited,

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

val LocalMobiStockColors = staticCompositionLocalOf<MobiStockColors> {
    error("No MobiStockColors provided")
}