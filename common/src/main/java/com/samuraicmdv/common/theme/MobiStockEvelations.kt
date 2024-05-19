package com.samuraicmdv.common.theme

import androidx.compose.runtime.Stable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Stable
class MobiElevations(
    val card: Dp,
)

private val mobiElevations = MobiElevations(
    card = 1.dp,
)

val LocalMobiElevations = staticCompositionLocalOf {
    mobiElevations
}

