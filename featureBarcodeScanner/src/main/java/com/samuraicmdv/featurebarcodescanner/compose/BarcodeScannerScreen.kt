package com.samuraicmdv.featurebarcodescanner.compose

import android.Manifest
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewParameter
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionState
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import com.samuraicmdv.common.theme.MobiTheme
import com.samuraicmdv.featurebarcodescanner.event.BarcodeScannerEvent
import com.samuraicmdv.featurebarcodescanner.preview.BarcodeScannerScreenPreviewParameter
import com.samuraicmdv.featurebarcodescanner.state.BarcodeScannerState
import com.samuraicmdv.ui.util.ThemePreviews

/**
 * Main composable screen for BarcodeScannerActivity. BarcodeScannerScreen is a composable function that displays the
 * barcode scanner UI.
 *
 * @param uiData The UI data containing the state of the barcode scanner, including scanned image and product details.
 * @param handleEvent A lambda function to handle events emitted from the barcode scanner.
 * @param modifier A [Modifier] to be applied to the screen.
 */
@OptIn(ExperimentalPermissionsApi::class, ExperimentalMaterial3Api::class)
@Composable
fun BarcodeScannerScreen(
    uiData: BarcodeScannerState,
    handleEvent: (BarcodeScannerEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    val bottomSheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    val cameraPermissionState: PermissionState = rememberPermissionState(permission = Manifest.permission.CAMERA)

    Box(modifier = modifier.fillMaxSize()) {
        // Camera preview
        CameraPreviewContent(
            cameraPermissionState = cameraPermissionState,
            handleEvent = handleEvent
        )

        if (cameraPermissionState.status.isGranted) {
            // Screen overlay
            CameraOverlayContent()
        }

        // Product details bottom sheet
        uiData.scanDetailsUiData?.let {
            ProductDetailsBottomSheet(
                uiData = it,
                bottomSheetState = bottomSheetState,
                handleEvent = handleEvent,
            )
        }
    }
}

@ThemePreviews
@Composable
fun PreviewBarcodeScannerScreen(
    @PreviewParameter(BarcodeScannerScreenPreviewParameter::class) previewData: BarcodeScannerState
) {
    MobiTheme {
        Surface {
            BarcodeScannerScreen(
                uiData = previewData,
                handleEvent = {}
            )
        }
    }
}
