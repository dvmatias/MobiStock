package com.samuraicmdv.featurebarcodescanner.compose

import android.Manifest
import android.graphics.Bitmap
import android.media.AudioManager
import android.media.ToneGenerator
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.unit.dp
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import com.samuraicmdv.featurebarcodescanner.event.BarcodeScannerEvent
import com.samuraicmdv.featurebarcodescanner.event.BarcodeScannerPresentationEvent

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun CameraPreviewContent(
    callback: (BarcodeScannerEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    var lastScannedBarcode by remember { mutableStateOf<String?>(null) }
    val cameraPermissionState = rememberPermissionState(permission = Manifest.permission.CAMERA)
    val toneGenerator = ToneGenerator(AudioManager.STREAM_MUSIC, 100)
    var scannedImageBitmap by remember { mutableStateOf<Bitmap?>(null) }

    if (cameraPermissionState.status.isGranted) {
        Box(modifier = modifier.fillMaxSize()) {
            CameraPreviewViewContent(modifier = modifier) { event ->
                when (event) {
                    is BarcodeScannerPresentationEvent.OnBarcodeScanned -> {
                        val scannedBarcode = event.barcode
                        if (lastScannedBarcode == null || scannedBarcode != lastScannedBarcode) {
                            toneGenerator.startTone(ToneGenerator.TONE_CDMA_PIP, 200) // 200ms beep
                            lastScannedBarcode = scannedBarcode
                            scannedImageBitmap = event.bitmap
                            callback(event)
                        }
                    }

                    is BarcodeScannerPresentationEvent.OnBarcodeLost -> {
                        if (lastScannedBarcode != null) lastScannedBarcode = null
                    }
                }
            }

            scannedImageBitmap?.let {
                Image(
                    bitmap = it.asImageBitmap(),
                    contentDescription = "Rendered Bitmap",
                    modifier = Modifier
                        .width(300.dp)
                        .aspectRatio(1f)
                        .align(androidx.compose.ui.Alignment.BottomCenter)
                )
            }
        }

    } else {
        DisposableEffect(Unit) {
            cameraPermissionState.launchPermissionRequest()
            onDispose { }
        }
    }
}