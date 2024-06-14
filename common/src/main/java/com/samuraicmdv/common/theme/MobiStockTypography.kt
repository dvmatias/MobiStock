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
    val headlineMediumBold: TextStyle,
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

val fontsBody = FontFamily(
    Font(R.font.gibson_light, weight = FontWeight.Light, style = FontStyle.Normal),
    Font(R.font.gibson_regular, weight = FontWeight.Normal, style = FontStyle.Normal),
    Font(R.font.gibson_bold, weight = FontWeight.Black, style = FontStyle.Normal),
    Font(R.font.gibson_semi_bold, weight = FontWeight.Bold, style = FontStyle.Normal)
)

val fontsTitle = FontFamily(
    Font(R.font.cedora_regular, weight = FontWeight.Normal, style = FontStyle.Normal),
    Font(R.font.cedora_bold, weight = FontWeight.Bold, style = FontStyle.Normal),
)


fun defaultMobiTypography(colors: MobiColors) = mobiTypography(colors)

fun mobiTypography(mobiColors: MobiColors): MobiTypography {
    val fontSizes = MobiTypographyFontSizes()

    val lineHeights = MobiTypographyLineHeight()

    val primaryFont = TextStyle(
        color = mobiColors.textPrimary
    )

    val bodyFont = primaryFont.copy(
        fontFamily = fontsBody,
    )

    val titleFont = primaryFont.copy(
        fontFamily = fontsTitle,
    )

    val bodyBold = bodyFont.copy(
        fontWeight = FontWeight.Bold,
    )

    val bodyNormal = bodyFont.copy(
        fontWeight = FontWeight.Normal,
    )

    val titleBold = titleFont.copy(
        fontWeight = FontWeight.Bold,
    )

    val titleNormal = titleFont.copy(
        fontWeight = FontWeight.Normal,
    )

    return MobiTypography(
        labelSmall = titleNormal.copy(
            fontSize = fontSizes.small,
            lineHeight = lineHeights.small
        ),
        labelSmallBold = titleBold.copy(
            fontSize = fontSizes.small,
            lineHeight = lineHeights.small
        ),
        labelMedium = titleNormal.copy(
            fontSize = fontSizes.regular1,
            lineHeight = lineHeights.regular1
        ),
        labelMediumBold = titleBold.copy(
            fontSize = fontSizes.regular1,
            lineHeight = lineHeights.regular1
        ),
        labelMediumBlack = titleBold.copy(
            fontSize = fontSizes.regular1,
            lineHeight = lineHeights.regular1
        ),
        labelLarge = titleNormal.copy(
            fontSize = fontSizes.medium1,
            lineHeight = lineHeights.medium1
        ),
        labelLargeBold = titleBold.copy(
            fontSize = fontSizes.medium1,
            lineHeight = lineHeights.medium1
        ),
        bodySmall = bodyNormal.copy(
            fontSize = fontSizes.smallest,
            lineHeight = lineHeights.smallest
        ),
        bodyMedium = bodyNormal.copy(
            fontSize = fontSizes.medium1,
            lineHeight = lineHeights.medium1
        ),
        bodyMediumBold = bodyBold.copy(
            fontSize = fontSizes.medium1,
            lineHeight = lineHeights.medium1
        ),
        bodyLarge = bodyNormal.copy(
            fontSize = fontSizes.medium2,
            lineHeight = lineHeights.medium2
        ),
        bodyLargeBold = bodyBold.copy(
            fontSize = fontSizes.medium2,
            lineHeight = lineHeights.medium2
        ),
        titleSmall = titleNormal.copy(
            fontSize = fontSizes.medium1,
            lineHeight = lineHeights.medium1
        ),
        titleSmallBold = titleBold.copy(
            fontSize = fontSizes.medium1,
            lineHeight = lineHeights.medium1
        ),
        titleMedium = titleNormal.copy(
            fontSize = fontSizes.medium2,
            lineHeight = lineHeights.medium2
        ),
        titleMediumBold = titleBold.copy(
            fontSize = fontSizes.medium2,
            lineHeight = lineHeights.medium2
        ),
        titleLarge = titleNormal.copy(
            fontSize = fontSizes.large1,
            lineHeight = lineHeights.large2
        ),
        titleLargeBold = titleBold.copy(
            fontSize = fontSizes.large1,
            lineHeight = lineHeights.large2
        ),
        headlineSmall = titleNormal.copy(
            fontSize = fontSizes.large2,
            lineHeight = lineHeights.large2
        ),
        headlineSmallBold = titleBold.copy(
            fontSize = fontSizes.large2,
            lineHeight = lineHeights.large2
        ),
        headlineMedium = titleNormal.copy(
            fontSize = fontSizes.large3,
            lineHeight = lineHeights.large3
        ),
        headlineMediumBold = titleBold.copy(
            fontSize = fontSizes.large3,
            lineHeight = lineHeights.large3
        ),
        headlineLarge = titleNormal.copy(
            fontSize = fontSizes.giant1,
            lineHeight = lineHeights.giant1
        ),
        displaySmall = titleNormal.copy(
            fontSize = fontSizes.giant2,
            lineHeight = lineHeights.giant2
        ),
        displayMedium = titleNormal.copy(
            fontSize = fontSizes.giant3,
            lineHeight = lineHeights.giant3
        ),
        displayLarge = titleNormal.copy(
            fontSize = fontSizes.giant4,
            lineHeight = lineHeights.giant4
        ),
        buttonLabel = titleBold.copy(
            fontSize = fontSizes.medium1,
            lineHeight = lineHeights.medium1,
            color = mobiColors.onPrimary
        )
    )
}


