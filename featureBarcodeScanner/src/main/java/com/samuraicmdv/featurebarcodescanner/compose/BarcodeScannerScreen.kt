package com.samuraicmdv.featurebarcodescanner.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.samuraicmdv.common.theme.MobiTheme
import com.samuraicmdv.featurebarcodescanner.event.BarcodeScannerEvent
import com.samuraicmdv.featurebarcodescanner.state.BarcodeScannerUiData
import com.samuraicmdv.ui.util.ThemePreviews

@Composable
fun BarcodeScannerScreen(
    uiData: BarcodeScannerUiData,
    callback: (BarcodeScannerEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier.fillMaxSize()) {
        // Camera preview
        CameraPreviewContent(callback)

        // Screen overlay
        CameraOverlayContent()

        // Scanned image preview
        uiData.scannedImageBitmap?.let {
            Image(
                bitmap = it,
                contentDescription = "Rendered Bitmap",
                modifier = Modifier
                    .width(300.dp)
                    .aspectRatio(1f)
                    .align(androidx.compose.ui.Alignment.BottomCenter)
            )
        }
    }
}

@ThemePreviews
@Composable
fun PreviewBarcodeScannerScreen() {
    MobiTheme {
        Surface {
            BarcodeScannerScreen(
                uiData = BarcodeScannerUiData(),
                callback = {}
            )
        }
    }
}
