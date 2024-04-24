package com.samuraicmdv.featurelogin.compose

import android.content.res.Configuration
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.samuraicmdv.common.theme.MobiStockTheme

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
) {

}

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun LoginScreenPreview() {
    MobiStockTheme {
        Surface(color = MobiStockTheme.colors.backgroundPrimary) {
            LoginScreen()
        }
    }
}