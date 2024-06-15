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
    val headline: TextStyle,
    val headlineBold: TextStyle,
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
    val caption: TextUnit =   12.sp,
    val bodySmall: TextUnit =  14.sp,
    val bodyMedium: TextUnit =  16.sp,
    val bodyLarge: TextUnit =  18.sp,
    val titleSmall: TextUnit =  20.sp,
    val titleMedium: TextUnit =  24.sp,
    val titleLarge: TextUnit =  28.sp,
    val headline: TextUnit =  32.sp,
    val displaySmall: TextUnit =  36.sp,
    val displayMedium: TextUnit =  48.sp,
    val displayLarge: TextUnit =  60.sp,
)

@Immutable
private data class MobiTypographyLineHeight(
    val smallest: TextUnit = 12.sp,
    val small: TextUnit = 14.sp,
    val caption: TextUnit =   16.sp,
    val bodySmall: TextUnit =  18.sp,
    val bodyMedium: TextUnit =  20.sp,
    val bodyLarge: TextUnit =  26.sp,
    val titleSmall: TextUnit =  30.sp,
    val titleMedium: TextUnit =  32.sp,
    val titleLarge: TextUnit =  36.sp,
    val headline: TextUnit =  42.sp,
    val displaySmall: TextUnit =  46.sp,
    val displayMedium: TextUnit =  56.sp,
    val displayLarge: TextUnit =  66.sp,
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
            fontSize = fontSizes.smallest,
            lineHeight = lineHeights.smallest
        ),
        labelSmallBold = titleBold.copy(
            fontSize = fontSizes.smallest,
            lineHeight = lineHeights.smallest
        ),
        labelMedium = titleNormal.copy(
            fontSize = fontSizes.small,
            lineHeight = lineHeights.small
        ),
        labelMediumBold = titleBold.copy(
            fontSize = fontSizes.small,
            lineHeight = lineHeights.small
        ),
        labelMediumBlack = titleBold.copy(
            fontSize = fontSizes.small,
            lineHeight = lineHeights.small
        ),
        labelLarge = titleNormal.copy(
            fontSize = fontSizes.caption,
            lineHeight = lineHeights.caption
        ),
        labelLargeBold = titleBold.copy(
            fontSize = fontSizes.caption,
            lineHeight = lineHeights.caption
        ),
        bodySmall = bodyNormal.copy(
            fontSize = fontSizes.bodySmall,
            lineHeight = lineHeights.bodySmall
        ),
        bodySmallBold = bodyBold.copy(
            fontSize = fontSizes.bodySmall,
            lineHeight = lineHeights.bodySmall
        ),
        bodyMedium = bodyNormal.copy(
            fontSize = fontSizes.bodyMedium,
            lineHeight = lineHeights.bodyMedium
        ),
        bodyMediumBold = bodyBold.copy(
            fontSize = fontSizes.bodyMedium,
            lineHeight = lineHeights.bodyMedium
        ),
        bodyLarge = bodyNormal.copy(
            fontSize = fontSizes.bodyLarge,
            lineHeight = lineHeights.bodyLarge
        ),
        bodyLargeBold = bodyBold.copy(
            fontSize = fontSizes.bodyLarge,
            lineHeight = lineHeights.bodyLarge
        ),
        titleSmall = titleNormal.copy(
            fontSize = fontSizes.titleSmall,
            lineHeight = lineHeights.titleSmall
        ),
        titleSmallBold = titleBold.copy(
            fontSize = fontSizes.titleSmall,
            lineHeight = lineHeights.titleSmall
        ),
        titleMedium = titleNormal.copy(
            fontSize = fontSizes.titleMedium,
            lineHeight = lineHeights.titleMedium
        ),
        titleMediumBold = titleBold.copy(
            fontSize = fontSizes.titleMedium,
            lineHeight = lineHeights.titleMedium
        ),
        titleLarge = titleNormal.copy(
            fontSize = fontSizes.titleLarge,
            lineHeight = lineHeights.titleLarge
        ),
        titleLargeBold = titleBold.copy(
            fontSize = fontSizes.titleLarge,
            lineHeight = lineHeights.titleLarge
        ),
        headline = titleNormal.copy(
            fontSize = fontSizes.headline,
            lineHeight = lineHeights.headline
        ),
        headlineBold = titleBold.copy(
            fontSize = fontSizes.headline,
            lineHeight = lineHeights.headline
        ),
        displaySmall = titleNormal.copy(
            fontSize = fontSizes.displaySmall,
            lineHeight = lineHeights.displaySmall
        ),
        displayMedium = titleNormal.copy(
            fontSize = fontSizes.displayMedium,
            lineHeight = lineHeights.displayMedium
        ),
        displayLarge = titleNormal.copy(
            fontSize = fontSizes.displayLarge,
            lineHeight = lineHeights.displayLarge
        ),
        buttonLabel = titleBold.copy(
            fontSize = fontSizes.bodyMedium,
            lineHeight = lineHeights.bodyMedium,
            color = mobiColors.onPrimary
        )
    )
}


