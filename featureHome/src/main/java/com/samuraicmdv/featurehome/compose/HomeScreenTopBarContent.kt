package com.samuraicmdv.featurehome.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.samuraicmdv.common.theme.MobiStockTheme
import com.samuraicmdv.ui.util.ThemePreviews

@Composable
fun HomeScreenTopBarContent(
    userName: String,
    userAddress: String,
    modifier: Modifier = Modifier,
) {
    Row(modifier = modifier.fillMaxWidth()) {
        HomeScreenTopBarUserContent(
            userName = userName,
            userAddress = userAddress,
            Modifier.background(MobiStockTheme.colors.backgroundPrimary)
        )
    }
}

@ThemePreviews
@Composable
fun PreviewHomeScreenTopBarContent(modifier: Modifier = Modifier) {
    MobiStockTheme {
        Surface(color = MobiStockTheme.colors.backgroundPrimary) {
            HomeScreenTopBarContent(userName = "User Name", userAddress = "User Address 123")
        }
    }
}