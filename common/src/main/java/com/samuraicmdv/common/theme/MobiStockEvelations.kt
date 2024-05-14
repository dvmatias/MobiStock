package com.samuraicmdv.common.theme

import androidx.compose.runtime.Stable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Stable
class MobiStockElevations(
    val card: Dp,
)

private val mobiStockElevations = MobiStockElevations(
    card = 1.dp,
)

val LocalMobiStockElevations = staticCompositionLocalOf {
    mobiStockElevations
}

