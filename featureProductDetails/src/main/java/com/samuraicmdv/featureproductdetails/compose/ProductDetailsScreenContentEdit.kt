package com.samuraicmdv.featureproductdetails.compose

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.samuraicmdv.common.theme.MobiTheme
import com.samuraicmdv.ui.util.ThemePreviews

@Composable
fun ProductDetailsScreenContentEdit(
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier.fillMaxSize()
    ) {

    }
}

@ThemePreviews
@Composable
fun PreviewProductDetailsScreenContentEdit() {
    MobiTheme {
        Surface {
            ProductDetailsScreenContentEdit()
        }
    }
}