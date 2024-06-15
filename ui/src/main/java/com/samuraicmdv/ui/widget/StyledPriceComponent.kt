package com.samuraicmdv.ui.widget

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.withStyle
import com.samuraicmdv.common.theme.MobiTheme
import com.samuraicmdv.ui.util.ThemePreviews
import java.text.DecimalFormatSymbols
import java.text.NumberFormat
import java.util.Locale

private const val BASELINE_MULTIPLIER_CURRENCY_SYMBOL = 0.4F
private const val BASELINE_MULTIPLIER_DECIMAL = 0.4F

@Composable
fun StyledPriceComponent(
    amount: Double,
    modifier: Modifier = Modifier,
    priceComponentStyle: PriceComponentStyle = PriceComponentStyle.REGULAR,
    priceComponentWeight: PriceComponentWeight = PriceComponentWeight.NORMAL,
    priceComponentLevel: PriceComponentLevel = PriceComponentLevel.DISPLAY,
) {
    val multiplier = priceComponentStyle.multiplier
    val smallFontSize = (MobiTheme.typography.bodySmall.fontSize * multiplier) * 0.7F
    val largeFontSize = MobiTheme.typography.bodyLarge.fontSize * multiplier
    val fontFamily = MobiTheme.typography.bodyLarge.fontFamily
    val fontWeight = when (priceComponentWeight) {
        PriceComponentWeight.NORMAL -> FontWeight.Normal
        PriceComponentWeight.BOLD -> FontWeight.Bold
    }
    val fontColor = when (priceComponentLevel) {
        PriceComponentLevel.DISPLAY -> MobiTheme.colors.textPrimary
        PriceComponentLevel.NEGATIVE -> MobiTheme.colors.error
        PriceComponentLevel.POSITIVE -> MobiTheme.colors.textPositive
    }

    val symbols = DecimalFormatSymbols(Locale.getDefault())
    val decimalSeparator = symbols.decimalSeparator
    val currencySymbol = symbols.currencySymbol
    val numberString = amount.toString()
    val parts = numberString.split(".")
    val integerPart: String = NumberFormat.getCurrencyInstance(Locale.getDefault())
        .format(parts[0].toInt()).replace(currencySymbol, "").replace("\\$decimalSeparator.*".toRegex(), "")
    val originalDecimalPart = parts[1]
    val decimalPart = originalDecimalPart.padEnd(2, '0')

    val text2 = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                color = MobiTheme.colors.textPrimary,
                fontSize = smallFontSize,
                fontWeight = fontWeight,
                fontFamily = fontFamily,
                baselineShift = BaselineShift(BASELINE_MULTIPLIER_CURRENCY_SYMBOL * multiplier)
            ),
        ) {
            append(currencySymbol)
        }
        withStyle(
            style = SpanStyle(
                color = fontColor,
                fontSize = largeFontSize,
                fontWeight = fontWeight,
                fontFamily = fontFamily,
            ),
        ) {
            append(integerPart)
        }
        withStyle(
            style = SpanStyle(
                color = fontColor,
                fontSize = smallFontSize,
                fontWeight = fontWeight,
                fontFamily = fontFamily,
                baselineShift = BaselineShift(BASELINE_MULTIPLIER_DECIMAL * multiplier)
            ),
        ) {
            append(decimalPart)
        }
    }

    Box(
        modifier = modifier
    ) {
        Text(text = text2)
    }
}

enum class PriceComponentLevel {
    DISPLAY,
    NEGATIVE,
    POSITIVE,
}

enum class PriceComponentStyle(val multiplier: Float) {
    SMALL(multiplier = 0.75F),
    REGULAR(multiplier = 1F),
    MEDIUM(multiplier = 1.5F),
    LARGE(multiplier = 2F),
}

enum class PriceComponentWeight {
    NORMAL,
    BOLD,
}

@ThemePreviews
@Composable
fun PreviewStyledPriceComponent() {
    MobiTheme {
        Surface {
            Column(
                verticalArrangement = Arrangement.spacedBy(MobiTheme.dimens.dimen_2)
            ) {
                StyledPriceComponent(
                    amount = 1213.45,
                    priceComponentStyle = PriceComponentStyle.SMALL,
                    priceComponentWeight = PriceComponentWeight.NORMAL,
                )
                StyledPriceComponent(
                    amount = 1256.04,
                    priceComponentStyle = PriceComponentStyle.SMALL,
                    priceComponentWeight = PriceComponentWeight.NORMAL,
                    priceComponentLevel = PriceComponentLevel.NEGATIVE,
                )
                StyledPriceComponent(
                    amount = 1213.45,
                    priceComponentStyle = PriceComponentStyle.REGULAR,
                    priceComponentWeight = PriceComponentWeight.NORMAL,
                )
                StyledPriceComponent(
                    amount = 1256.04,
                    priceComponentStyle = PriceComponentStyle.REGULAR,
                    priceComponentWeight = PriceComponentWeight.NORMAL,
                    priceComponentLevel = PriceComponentLevel.NEGATIVE,
                )
                StyledPriceComponent(
                    amount = 6536.40,
                    priceComponentStyle = PriceComponentStyle.REGULAR,
                    priceComponentWeight = PriceComponentWeight.NORMAL,
                    priceComponentLevel = PriceComponentLevel.POSITIVE,
                )
                StyledPriceComponent(
                    amount = 123.45,
                    priceComponentStyle = PriceComponentStyle.MEDIUM,
                    priceComponentWeight = PriceComponentWeight.NORMAL,
                )
                StyledPriceComponent(
                    amount = 123.45,
                    priceComponentStyle = PriceComponentStyle.LARGE,
                    priceComponentWeight = PriceComponentWeight.NORMAL,
                )
                StyledPriceComponent(
                    amount = 123.45,
                    priceComponentStyle = PriceComponentStyle.REGULAR,
                    priceComponentWeight = PriceComponentWeight.BOLD,
                )
                StyledPriceComponent(
                    amount = 123.45,
                    priceComponentStyle = PriceComponentStyle.REGULAR,
                    priceComponentWeight = PriceComponentWeight.BOLD,
                    priceComponentLevel = PriceComponentLevel.NEGATIVE,
                )
                StyledPriceComponent(
                    amount = 123.45,
                    priceComponentStyle = PriceComponentStyle.REGULAR,
                    priceComponentWeight = PriceComponentWeight.BOLD,
                    priceComponentLevel = PriceComponentLevel.POSITIVE,
                )
                StyledPriceComponent(
                    amount = 123.45,
                    priceComponentStyle = PriceComponentStyle.MEDIUM,
                    priceComponentWeight = PriceComponentWeight.BOLD,
                )
                StyledPriceComponent(
                    amount = 123.45,
                    priceComponentStyle = PriceComponentStyle.LARGE,
                    priceComponentWeight = PriceComponentWeight.BOLD,
                )
            }
        }
    }
}