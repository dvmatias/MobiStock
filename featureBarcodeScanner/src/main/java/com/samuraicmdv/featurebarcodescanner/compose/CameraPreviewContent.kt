package com.samuraicmdv.featurebarcodescanner.compose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Modifier
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionState
import com.google.accompanist.permissions.isGranted
import com.samuraicmdv.featurebarcodescanner.event.BarcodeScannerEvent

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun CameraPreviewContent(
    cameraPermissionState: PermissionState,
    handleEvent: (BarcodeScannerEvent) -> Unit,
    modifier: Modifier = Modifier
) {

    Box(modifier = modifier.fillMaxSize()) {
        if (cameraPermissionState.status.isGranted) {
            // Camera preview
            CameraPreviewViewContent(modifier = modifier, handleEvent = handleEvent)
        } else {
            // Request camera permission
            DisposableEffect(Unit) {
                cameraPermissionState.launchPermissionRequest()
                onDispose { }
            }
            // Show camera permission content
            CameraPermissionContent(
                cameraPermissionState = cameraPermissionState,
                handleEvent = handleEvent,
            )
        }
    }
}
