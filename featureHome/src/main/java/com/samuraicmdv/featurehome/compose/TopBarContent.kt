package com.samuraicmdv.featurehome.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.samuraicmdv.common.theme.MobiStockTheme
import com.samuraicmdv.featurehome.event.HomeEvent
import com.samuraicmdv.ui.util.ThemePreviews

@Composable
fun HomeScreenTopBarContent(
    userName: String?,
    userAddress: String?,
    modifier: Modifier = Modifier,
    handleEvent: (HomeEvent) -> Unit,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(MobiStockTheme.colors.backgroundPrimary)
            .padding(
                top = MobiStockTheme.spaces.grid_1_5,
                bottom = MobiStockTheme.spaces.grid_1_5,
                start = MobiStockTheme.spaces.grid_3,
                end = MobiStockTheme.spaces.grid_3
            )
    ) {
        HomeScreenTopBarUserContent(
            userName = userName,
            userAddress = userAddress,
            handleEvent = handleEvent
        )
    }
}

@ThemePreviews
@Composable
fun PreviewHomeScreenTopBarContent(modifier: Modifier = Modifier) {
    MobiStockTheme {
        Surface(color = MobiStockTheme.colors.backgroundPrimary) {
            HomeScreenTopBarContent(
                userName = "User Name",
                userAddress = "User Address 123"
            ) {
            }
        }
    }
}