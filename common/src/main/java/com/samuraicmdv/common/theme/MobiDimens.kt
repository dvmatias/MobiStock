package com.samuraicmdv.common.theme

import androidx.compose.runtime.Stable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Suppress("unused")
@Stable
class MobiDimens(
    val unit: Dp = 1.dp,
    val dimen_0_25: Dp = 2.dp,
    val dimen_0_5: Dp = 4.dp,
    val dimen_0_75: Dp = 6.dp,
    val dimen_1: Dp = 8.dp,
    val dimen_1_5: Dp = 12.dp,
    val dimen_2: Dp = 16.dp,
    val dimen_3: Dp = 24.dp,
    val dimen_4: Dp = 32.dp,
    val dimen_5: Dp = 40.dp,
    val dimen_6: Dp = 48.dp,
    val dimen_7: Dp = 56.dp,
    val dimen_8: Dp = 64.dp,
)

val LocalMobiDimens = staticCompositionLocalOf {
    MobiDimens()
}


