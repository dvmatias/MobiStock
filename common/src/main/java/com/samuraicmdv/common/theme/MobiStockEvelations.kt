package com.samuraicmdv.common.theme

import androidx.compose.runtime.Stable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Stable
class MobiElevations(
    val quarter: Dp,
    val half: Dp,
    val unit: Dp,
    val two: Dp,
    val three: Dp,
    val topBar: Dp,
)

private val mobiElevations = MobiElevations(
    quarter = .25.dp,
    half = .5.dp,
    unit = 1.dp,
    two = 2.dp,
    three = 3.dp,
    topBar = 4.dp,
)

val LocalMobiElevations = staticCompositionLocalOf {
    mobiElevations
}

