package com.samuraicmdv.featurehome.compose

import android.content.res.Configuration
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.samuraicmdv.common.theme.MobiStockTheme

@Composable
fun HomeScreen() {

}


@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewHomeScreen() {
    MobiStockTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MobiStockTheme.colors.backgroundPrimary
        ) {
            HomeScreen()
        }
    }
}