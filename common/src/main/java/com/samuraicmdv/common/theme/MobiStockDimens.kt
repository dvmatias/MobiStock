package com.samuraicmdv.common.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun isTablet() = LocalConfiguration.current.smallestScreenWidthDp >= 600

@Stable
class MobiStockDimens(
    val grid_0_25: Dp,
    val grid_0_5: Dp,
    val grid_0_75: Dp,
    val grid_1: Dp,
    val grid_1_5: Dp,
    val grid_2: Dp,
    val grid_3: Dp,
    val grid_4: Dp,
    val grid_5: Dp,
    val grid_6: Dp,
    val grid_7: Dp,
    val grid_8: Dp,
) {
    @Composable
    fun ebayDimens() = if (isTablet()) largeMobiStockDimens else smallMobiStockDimens

    fun defaultMobiStockDimens() = largeMobiStockDimens

    private val largeMobiStockDimens = MobiStockDimens(
        grid_0_25 = 4.dp,
        grid_0_5 = 6.dp,
        grid_0_75 = 8.dp,
        grid_1 = 12.dp,
        grid_1_5 = 18.dp,
        grid_2 = 24.dp,
        grid_3 = 32.dp,
        grid_4 = 48.dp,
        grid_5 = 60.dp,
        grid_6 = 72.dp,
        grid_7 = 84.dp,
        grid_8 = 96.dp,
    )

    private val smallMobiStockDimens = MobiStockDimens(
        grid_0_25 = 2.dp,
        grid_0_5 = 4.dp,
        grid_0_75 = 6.dp,
        grid_1 = 8.dp,
        grid_1_5 = 12.dp,
        grid_2 = 16.dp,
        grid_3 = 24.dp,
        grid_4 = 32.dp,
        grid_5 = 40.dp,
        grid_6 = 48.dp,
        grid_7 = 56.dp,
        grid_8 = 64.dp,
    )

}
