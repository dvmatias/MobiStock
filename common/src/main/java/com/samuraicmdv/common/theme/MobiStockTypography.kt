package com.samuraicmdv.common.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.samuraicmdv.common.R

@Immutable
data class MobiTypography(
    val labelSmall: TextStyle,
    val labelSmallBold: TextStyle,
    val labelMedium: TextStyle,
    val labelMediumBold: TextStyle,
    val labelMediumBlack: TextStyle,
    val labelLarge: TextStyle,
    val labelLargeBold: TextStyle,
    val bodySmall: TextStyle,
    val bodySmallBold: TextStyle,
    val bodyMedium: TextStyle,
    val bodyMediumBold: TextStyle,
    val bodyLarge: TextStyle,
    val bodyLargeBold: TextStyle,
    val titleSmall: TextStyle,
    val titleSmallBold: TextStyle,
    val titleMedium: TextStyle,
    val titleMediumBold: TextStyle,
    val titleLarge: TextStyle,
    val titleLargeBold: TextStyle,
    val headlineSmall: TextStyle,
    val headlineSmallBold: TextStyle,
    val headlineMedium: TextStyle,
    val headlineLarge: TextStyle,
    val displaySmall: TextStyle,
    val displayMedium: TextStyle,
    val displayLarge: TextStyle,
    val buttonLabel: TextStyle
) {
}

@Immutable
private data class MobiTypographyFontSizes(
    val smallest: TextUnit = 10.sp,
    val small: TextUnit = 11.sp,
    val regular1: TextUnit = 12.sp,
    val regular2: TextUnit = 14.sp,
    val medium1: TextUnit = 16.sp,
    val medium2: TextUnit = 18.sp,
    val large1: TextUnit = 22.sp,
    val large2: TextUnit = 24.sp,
    val large3: TextUnit = 28.sp,
    val giant1: TextUnit = 32.sp,
    val giant2: TextUnit = 36.sp,
    val giant3: TextUnit = 45.sp,
    val giant4: TextUnit = 57.sp,
)

@Immutable
private data class MobiTypographyLineHeight(
    val smallest: TextUnit = 12.sp,
    val small: TextUnit = 14.sp,
    val regular1: TextUnit = 16.sp,
    val regular2: TextUnit = 18.sp,
    val medium1: TextUnit = 20.sp,
    val medium2: TextUnit = 26.sp,
    val large1: TextUnit = 30.sp,
    val large2: TextUnit = 32.sp,
    val large3: TextUnit = 36.sp,
    val giant1: TextUnit = 42.sp,
    val giant2: TextUnit = 46.sp,
    val giant3: TextUnit = 56.sp,
    val giant4: TextUnit = 66.sp,
)

val LocalMobiTypography = staticCompositionLocalOf {
    defaultMobiTypography()
}

val provider = GoogleFont.Provider(
    providerAuthority = "com.google.android.gms.fonts",
    providerPackage = "com.google.android.gms",
    certificates = R.array.com_google_android_gms_fonts_certs
)

val bodyFontFamily = FontFamily(
    Font(
        googleFont = GoogleFont("Open Sans"),
        fontProvider = provider,
    )
)

val displayFontFamily = FontFamily(
    Font(
        googleFont = GoogleFont("Rubik"),
        fontProvider = provider,
    )
)

fun defaultMobiTypography() = mobiTypography()

fun mobiTypography(): MobiTypography {
    val fontSizes = MobiTypographyFontSizes()
    val lineHeights = MobiTypographyLineHeight()
    val blackBody = TextStyle(
        fontFamily = bodyFontFamily,
        fontWeight = FontWeight.Black
    )
    val boldBody = TextStyle(
        fontFamily = bodyFontFamily,
        fontWeight = FontWeight.Bold
    )
    val boldDisplay = TextStyle(
        fontFamily = displayFontFamily,
        fontWeight = FontWeight.Bold
    )
    val regularBody = TextStyle(
        fontFamily = bodyFontFamily,
        fontWeight = FontWeight.Normal
    )
    val regularDisplay = TextStyle(
        fontFamily = displayFontFamily,
        fontWeight = FontWeight.Normal
    )

    return MobiTypography(
        labelSmall = regularBody.copy(
            fontSize = fontSizes.small,
            lineHeight = lineHeights.small
        ),
        labelSmallBold = boldBody.copy(
            fontSize = fontSizes.small,
            lineHeight = lineHeights.small
        ),
        labelMedium = regularBody.copy(
            fontSize = fontSizes.regular1,
            lineHeight = lineHeights.regular1
        ),
        labelMediumBold = boldBody.copy(
            fontSize = fontSizes.regular1,
            lineHeight = lineHeights.regular1
        ),
        labelMediumBlack = blackBody.copy(
            fontSize = fontSizes.regular1,
            lineHeight = lineHeights.regular1
        ),
        labelLarge = regularBody.copy(
            fontSize = fontSizes.medium1,
            lineHeight = lineHeights.medium1
        ),
        labelLargeBold = boldBody.copy(
            fontSize = fontSizes.medium1,
            lineHeight = lineHeights.medium1
        ),
        bodySmall = regularBody.copy(
            fontSize = fontSizes.regular1,
            lineHeight = lineHeights.regular1
        ),
        bodySmallBold = boldBody.copy(
            fontSize = fontSizes.regular1,
            lineHeight = lineHeights.regular1
        ),
        bodyMedium = regularBody.copy(
            fontSize = fontSizes.regular2,
            lineHeight = lineHeights.regular2
        ),
        bodyMediumBold = boldBody.copy(
            fontSize = fontSizes.regular2,
            lineHeight = lineHeights.regular2
        ),
        bodyLarge = regularBody.copy(
            fontSize = fontSizes.medium1,
            lineHeight = lineHeights.medium1
        ),
        bodyLargeBold = boldBody.copy(
            fontSize = fontSizes.medium1,
            lineHeight = lineHeights.medium1
        ),
        titleSmall = regularDisplay.copy(
            fontSize = fontSizes.medium1,
            lineHeight = lineHeights.medium1
        ),
        titleSmallBold = boldDisplay.copy(
            fontSize = fontSizes.medium1,
            lineHeight = lineHeights.medium1
        ),
        titleMedium = regularDisplay.copy(
            fontSize = fontSizes.medium2,
            lineHeight = lineHeights.medium2
        ),
        titleMediumBold = boldDisplay.copy(
            fontSize = fontSizes.medium2,
            lineHeight = lineHeights.medium2
        ),
        titleLarge = regularDisplay.copy(
            fontSize = fontSizes.large1,
            lineHeight = lineHeights.large2
        ),
        titleLargeBold = boldDisplay.copy(
            fontSize = fontSizes.large1,
            lineHeight = lineHeights.large2
        ),
        headlineSmall = regularDisplay.copy(
            fontSize = fontSizes.large2,
            lineHeight = lineHeights.large2
        ),
        headlineSmallBold = boldDisplay.copy(
            fontSize = fontSizes.large2,
            lineHeight = lineHeights.large2
        ),
        headlineMedium = boldDisplay.copy(
            fontSize = fontSizes.large3,
            lineHeight = lineHeights.large3
        ),
        headlineLarge = regularDisplay.copy(
            fontSize = fontSizes.giant1,
            lineHeight = lineHeights.giant1
        ),
        displaySmall = regularDisplay.copy(
            fontSize = fontSizes.giant2,
            lineHeight = lineHeights.giant2
        ),
        displayMedium = regularDisplay.copy(
            fontSize = fontSizes.giant3,
            lineHeight = lineHeights.giant3
        ),
        displayLarge = regularDisplay.copy(
            fontSize = fontSizes.giant4,
            lineHeight = lineHeights.giant4
        ),
        buttonLabel = boldBody.copy(
            fontSize = fontSizes.medium1,
            lineHeight = lineHeights.medium1,
        )
    )
}


