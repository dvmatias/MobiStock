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