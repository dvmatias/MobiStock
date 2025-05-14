package com.samuraicmdv.featurebarcodescanner.compose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.samuraicmdv.common.theme.MobiTheme
import com.samuraicmdv.featurebarcodescanner.event.BarcodeScannerEvent
import com.samuraicmdv.ui.util.ThemePreviews

@Composable
fun BarcodeScannerScreen(
    callback: (BarcodeScannerEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier.fillMaxSize()) {
        CameraPreviewContent(callback)
        CameraOverlayContent()
    }
}

@ThemePreviews
@Composable
fun PreviewBarcodeScannerScreen() {
    MobiTheme {
        Surface {
            BarcodeScannerScreen(callback = {})
        }
    }
}
