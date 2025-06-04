package com.samuraicmdv.featurebarcodescanner.compose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Modifier
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import androidx.lifecycle.compose.LocalLifecycleOwner
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionState
import com.google.accompanist.permissions.PermissionStatus
import com.google.accompanist.permissions.isGranted
import com.samuraicmdv.common.theme.MobiTheme
import com.samuraicmdv.featurebarcodescanner.event.BarcodeScannerEvent
import com.samuraicmdv.ui.util.ThemePreviews

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

@OptIn(ExperimentalPermissionsApi::class)
@ThemePreviews
@Composable
private fun CameraPreviewContentPreview_PermissionGranted() {
    // Mock LifecycleOwner for preview
    val mockLifecycleOwner = object : LifecycleOwner {
        override val lifecycle = LifecycleRegistry(this)
    }

    CompositionLocalProvider(LocalLifecycleOwner provides mockLifecycleOwner) {
        MobiTheme {
            Surface {
                CameraPreviewContent(
                    cameraPermissionState = object : PermissionState {
                        override val permission: String = android.Manifest.permission.CAMERA
                        override val status: PermissionStatus
                            get() = PermissionStatus.Granted

                        override fun launchPermissionRequest() {}
                    },
                    handleEvent = {}
                )
            }
        }
    }
}

@OptIn(ExperimentalPermissionsApi::class)
@ThemePreviews
@Composable
private fun CameraPreviewContentPreview_PermissionDenied() {
    val mockCameraPermissionState = object : PermissionState {
        override val permission: String = android.Manifest.permission.CAMERA
        override val status: PermissionStatus
            get() = PermissionStatus.Denied(
                shouldShowRationale = true
            )

        override fun launchPermissionRequest() {}
    }
    MobiTheme {
        Surface {
            CameraPreviewContent(
                cameraPermissionState = mockCameraPermissionState,
                handleEvent = {}
            )
        }
    }
}
