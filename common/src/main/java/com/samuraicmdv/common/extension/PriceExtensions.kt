package com.samuraicmdv.common.extension

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