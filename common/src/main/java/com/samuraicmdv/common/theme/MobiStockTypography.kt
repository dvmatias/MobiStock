@file:Suppress("PropertyName")

package com.samuraicmdv.common.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

@Immutable
data class MobiStockTypography(
    val bodyBold: TextStyle,
    val bodyRegular: TextStyle,
    val giant1Bold: TextStyle,
    val giant2Bold: TextStyle,
    val giant3Bold: TextStyle,
    val large1Regular: TextStyle,
    val large1Bold: TextStyle,
    val large2Bold: TextStyle,
    val mediumBold: TextStyle,
    val mediumRegular: TextStyle,
    val smallBold: TextStyle,
    val smallRegular: TextStyle,
    val smallest: TextStyle,
)

@Immutable
private data class MobiStockTypographyFontSizes(
    val smallest: TextUnit = 10.sp,
    val small: TextUnit = 12.sp,
    val regular: TextUnit = 14.sp,
    val medium: TextUnit = 16.sp,
    val large1: TextUnit = 20.sp,
    val large2: TextUnit = 24.sp,
    val giant1: TextUnit = 30.sp,
    val giant2: TextUnit = 36.sp,
    val giant3: TextUnit = 46.sp
)

@Immutable
private data class MobiStockTypographyLineHeight(
    val Smallest: TextUnit = 12.sp,
    val Small: TextUnit = 16.sp,
    val Regular: TextUnit = 20.sp,
    val Medium: TextUnit = 24.sp,
    val Large1: TextUnit = 28.sp,
    val Large2: TextUnit = 32.sp,
    val Giant1: TextUnit = 40.sp,
    val Giant2: TextUnit = 46.sp,
    val Giant3: TextUnit = 56.sp,
)

val LocalMobiStockTypography = staticCompositionLocalOf {
    defaultMobiStockTypography()
}

fun defaultMobiStockTypography() = mobiStockTypography()

fun mobiStockTypography(): MobiStockTypography {
    val fontSizes = MobiStockTypographyFontSizes()
    val lineHeights = MobiStockTypographyLineHeight()
    val bold = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Bold
    )
    val regular = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Normal
    )

    return MobiStockTypography(
        bodyBold = bold.copy(
            fontSize = fontSizes.regular,
            lineHeight = lineHeights.Regular
        ),
        bodyRegular = regular.copy(
            fontSize = fontSizes.regular,
            lineHeight = lineHeights.Regular
        ),
        giant1Bold = bold.copy(
            fontSize = fontSizes.giant1,
            lineHeight = lineHeights.Giant1
        ),
        giant2Bold = bold.copy(
            fontSize = fontSizes.giant2,
            lineHeight = lineHeights.Giant2
        ),
        giant3Bold = bold.copy(
            fontSize = fontSizes.giant3,
            lineHeight = lineHeights.Giant3
        ),
        large1Regular = regular.copy(
            fontSize = fontSizes.large1,
            lineHeight = lineHeights.Large1
        ),
        large1Bold = bold.copy(
            fontSize = fontSizes.large1,
            lineHeight = lineHeights.Large1
        ),
        large2Bold = bold.copy(
            fontSize = fontSizes.large2,
            lineHeight = lineHeights.Large2
        ),
        mediumBold = bold.copy(
            fontSize = fontSizes.medium,
            lineHeight = lineHeights.Medium
        ),
        mediumRegular = regular.copy(
            fontSize = fontSizes.medium,
            lineHeight = lineHeights.Medium
        ),
        smallBold = bold.copy(
            fontSize = fontSizes.small,
            lineHeight = lineHeights.Small
        ),
        smallRegular = regular.copy(
            fontSize = fontSizes.small,
            lineHeight = lineHeights.Small
        ),
        smallest = regular.copy(
            fontSize = fontSizes.smallest,
            lineHeight = lineHeights.Smallest
        )
    )
}


