package com.samuraicmdv.featurebarcodescanner.compose

import android.Manifest
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun CameraPreviewContent(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val cameraPermissionState = rememberPermissionState(permission = Manifest.permission.CAMERA)

    if (cameraPermissionState.status.isGranted) {
        CameraPreviewViewContent(context, modifier)
    } else {
        DisposableEffect(Unit) {
            cameraPermissionState.launchPermissionRequest()
            onDispose { }
        }
    }
}