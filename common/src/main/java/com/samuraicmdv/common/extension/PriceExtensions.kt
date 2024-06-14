package com.samuraicmdv.common.extension

import java.text.DecimalFormatSymbols
import java.text.NumberFormat
import java.util.Locale

fun Double?.toDisplayPrice(): String {
    val format = NumberFormat.getCurrencyInstance(Locale.getDefault())

    return this?.let {
        format.format(this)
    } ?: run {
        format.format(0.0)
    }
}

fun String?.toDoublePrice(): Double {
    val symbols = DecimalFormatSymbols(Locale.getDefault())
    val decimalSeparator = symbols.decimalSeparator
    val sanitizedDigits = this?.replace(Regex("[^\\d$decimalSeparator]"), "")
    return sanitizedDigits?.toDoubleOrNull() ?: 0.0
}

/**
 * Returns the margin between two prices in percentage.
 *
 * @receiver A pair of two prices. This first value should be the 'cost' and the second value should be the 'revenue'.
 * @param decimalsCount The number of decimals to display.
 * @param prefix The prefix to add to the margin.
 * @param suffix The suffix to add to the margin.

 */
fun Pair<Double?, Double?>.getMargin(decimalsCount: Int, prefix: String? = null, suffix: String? = null): String {
    if (this.first == null || this.second == null) {
        return "0"
    }
    val formattedMargin = this.getMargin(decimalsCount)
    val builder = StringBuilder()
    if (prefix != null) {
        builder.append(prefix)
    }
    builder.append(formattedMargin)
    if (suffix != null) {
        builder.append(suffix)
    }
    return builder.toString()
}

fun Pair<Double?, Double?>.getMargin(decimalsCount: Int): Double {
    this.first.takeUnless { it == null } ?: return 0.0
    this.second.takeUnless { it == null } ?: return 0.0

    val margin = (1 - (this.first!! / this.second!!)) * 100
    return String.format(Locale.getDefault(), "%.${decimalsCount}f", margin).toDouble()
}