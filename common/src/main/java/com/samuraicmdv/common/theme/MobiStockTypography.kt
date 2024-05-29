package com.samuraicmdv.common.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
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
    defaultMobiTypography(lightMobiColors)
}

/*val provider = GoogleFont.Provider(
    providerAuthority = "com.google.android.gms.fonts",
    providerPackage = "com.google.android.gms",
    certificates = R.array.com_google_android_gms_fonts_certs
)

val bodyFontFamily = FontFamily(
    Font(
        googleFont = GoogleFont("Outfit"),
        fontProvider = provider,
    )
)

val displayFontFamily = FontFamily(
    Font(
        googleFont = GoogleFont("Outfit"),
        fontProvider = provider,
    )
)*/

val fonts = FontFamily(
    Font(R.font.gibson_light, weight = FontWeight.Light, style = FontStyle.Normal),
    Font(R.font.gibson_regular, weight = FontWeight.Normal, style = FontStyle.Normal),
    Font(R.font.gibson_bold, weight = FontWeight.Bold, style = FontStyle.Normal),
    Font(R.font.gibson_semi_bold, weight = FontWeight.SemiBold, style = FontStyle.Normal)
)


fun defaultMobiTypography(colors: MobiColors) = mobiTypography(colors)

fun mobiTypography(mobiColors: MobiColors): MobiTypography {
    val fontSizes = MobiTypographyFontSizes()

    val lineHeights = MobiTypographyLineHeight()

    val primaryFont = TextStyle(
        color = mobiColors.textPrimary
    )

    val boldFont = primaryFont.copy(
        fontFamily = fonts,
        fontWeight = FontWeight.SemiBold, // weight set as SEMI BOLD since Gibson Semi Bold is too thick and can act as Bold
        color = mobiColors.textPrimary
    )

    val regularFont = primaryFont.copy(
        fontFamily = fonts,
        fontWeight = FontWeight.Normal,
        color = mobiColors.textPrimary
    )

    return MobiTypography(
        labelSmall = regularFont.copy(
            fontSize = fontSizes.small,
            lineHeight = lineHeights.small
        ),
        labelSmallBold = boldFont.copy(
            fontSize = fontSizes.small,
            lineHeight = lineHeights.small
        ),
        labelMedium = regularFont.copy(
            fontSize = fontSizes.regular1,
            lineHeight = lineHeights.regular1
        ),
        labelMediumBold = boldFont.copy(
            fontSize = fontSizes.regular1,
            lineHeight = lineHeights.regular1
        ),
        labelMediumBlack = boldFont.copy(
            fontSize = fontSizes.regular1,
            lineHeight = lineHeights.regular1
        ),
        labelLarge = regularFont.copy(
            fontSize = fontSizes.medium1,
            lineHeight = lineHeights.medium1
        ),
        labelLargeBold = boldFont.copy(
            fontSize = fontSizes.medium1,
            lineHeight = lineHeights.medium1
        ),
        bodySmall = regularFont.copy(
            fontSize = fontSizes.regular1,
            lineHeight = lineHeights.regular1
        ),
        bodySmallBold = boldFont.copy(
            fontSize = fontSizes.regular1,
            lineHeight = lineHeights.regular1
        ),
        bodyMedium = regularFont.copy(
            fontSize = fontSizes.regular2,
            lineHeight = lineHeights.regular2
        ),
        bodyMediumBold = boldFont.copy(
            fontSize = fontSizes.regular2,
            lineHeight = lineHeights.regular2
        ),
        bodyLarge = regularFont.copy(
            fontSize = fontSizes.medium1,
            lineHeight = lineHeights.medium1
        ),
        bodyLargeBold = boldFont.copy(
            fontSize = fontSizes.medium1,
            lineHeight = lineHeights.medium1
        ),
        titleSmall = regularFont.copy(
            fontSize = fontSizes.medium1,
            lineHeight = lineHeights.medium1
        ),
        titleSmallBold = boldFont.copy(
            fontSize = fontSizes.medium1,
            lineHeight = lineHeights.medium1
        ),
        titleMedium = regularFont.copy(
            fontSize = fontSizes.medium2,
            lineHeight = lineHeights.medium2
        ),
        titleMediumBold = boldFont.copy(
            fontSize = fontSizes.medium2,
            lineHeight = lineHeights.medium2
        ),
        titleLarge = regularFont.copy(
            fontSize = fontSizes.large1,
            lineHeight = lineHeights.large2
        ),
        titleLargeBold = boldFont.copy(
            fontSize = fontSizes.large1,
            lineHeight = lineHeights.large2
        ),
        headlineSmall = regularFont.copy(
            fontSize = fontSizes.large2,
            lineHeight = lineHeights.large2
        ),
        headlineSmallBold = boldFont.copy(
            fontSize = fontSizes.large2,
            lineHeight = lineHeights.large2
        ),
        headlineMedium = boldFont.copy(
            fontSize = fontSizes.large3,
            lineHeight = lineHeights.large3
        ),
        headlineLarge = regularFont.copy(
            fontSize = fontSizes.giant1,
            lineHeight = lineHeights.giant1
        ),
        displaySmall = regularFont.copy(
            fontSize = fontSizes.giant2,
            lineHeight = lineHeights.giant2
        ),
        displayMedium = regularFont.copy(
            fontSize = fontSizes.giant3,
            lineHeight = lineHeights.giant3
        ),
        displayLarge = regularFont.copy(
            fontSize = fontSizes.giant4,
            lineHeight = lineHeights.giant4
        ),
        buttonLabel = boldFont.copy(
            fontSize = fontSizes.medium1,
            lineHeight = lineHeights.medium1,
            color = mobiColors.onPrimary
        )
    )
}


