package com.samuraicmdv.featureproductdetails.compose

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.samuraicmdv.common.theme.MobiTheme
import com.samuraicmdv.ui.util.ThemePreviews

@Composable
fun ProductDetailsScreen(
    isEditMode: Boolean,
    modifier: Modifier = Modifier
) {
    if (isEditMode) {
        ProductDetailsScreenContentEdit(modifier)
    } else {
        ProductDetailsScreenContentView(modifier)
    }
}

@ThemePreviews
@Composable
fun PreviewProductDetailsScreenEdit() {
    MobiTheme {
        Surface {
            ProductDetailsScreen(
                isEditMode = true
            )
        }
    }
}

@ThemePreviews
@Composable
fun PreviewProductDetailsScreenView() {
    MobiTheme {
        Surface {
            ProductDetailsScreen(
                isEditMode = false
            )
        }
    }
}