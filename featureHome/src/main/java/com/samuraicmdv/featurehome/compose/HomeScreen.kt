package com.samuraicmdv.featurehome.compose

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.samuraicmdv.common.theme.MobiStockTheme
import com.samuraicmdv.ui.util.ThemePreviews

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    val tempUserName = "User name"
    val tempUserAddress = "User address"
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            HomeScreenTopBarContent(tempUserName, tempUserAddress)
        }
    ) { paddingValues ->
        HomeScreenContent(Modifier.padding(paddingValues))
    }
}

@ThemePreviews
@Composable
fun PreviewHomeScreen() {
    MobiStockTheme {
        // A surface container using the 'background' color from the theme
        Surface(color = MobiStockTheme.colors.backgroundPrimary) {
            HomeScreen()
        }
    }
}