package com.samuraicmdv.featurebarcodescanner.compose

import android.Manifest
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Modifier
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import com.samuraicmdv.featurebarcodescanner.event.BarcodeScannerEvent

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun CameraPreviewContent(
    callback: (BarcodeScannerEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    val cameraPermissionState = rememberPermissionState(permission = Manifest.permission.CAMERA)

    Box(modifier = modifier.fillMaxSize()) {
        if (cameraPermissionState.status.isGranted) {
            // Camera preview
            CameraPreviewViewContent(modifier = modifier, callback = callback)
        } else {
            // Request camera permission
            DisposableEffect(Unit) {
                cameraPermissionState.launchPermissionRequest()
                onDispose { }
            }
        }
    }
}
