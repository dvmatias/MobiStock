package com.samuraicmdv.featurebarcodescanner.compose

import android.Manifest
import android.content.Intent
import android.net.Uri
import android.provider.Settings
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionState
import com.google.accompanist.permissions.PermissionStatus
import com.samuraicmdv.common.theme.MobiTheme
import com.samuraicmdv.featurebarcodescanner.event.BarcodeScannerEvent
import com.samuraicmdv.featurebarcodescanner.event.BarcodeScannerPresentationEvent
import com.samuraicmdv.ui.util.ThemePreviews
import com.samuraicmdv.ui.widget.CustomButton
import com.samuraicmdv.ui.widget.CustomButtonType
import com.samuraicmdv.common.R as CommonR

/**
 * Composable function to display the camera permission content.
 *
 * @param cameraPermissionState The state of the camera permission.
 */
@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun CameraPermissionContent(
    cameraPermissionState: PermissionState,
    handleEvent: (BarcodeScannerEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current

    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp)
            .padding(top = 48.dp)
    ) {
        Image(
            painter = painterResource(CommonR.drawable.icon_camera),
            contentDescription = "Camera Icon",
            colorFilter = ColorFilter.tint(
                color = MobiTheme.colors.primary
            ),
            modifier = Modifier.size(96.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = stringResource(id = com.samuraicmdv.featurebarcodescanner.R.string.camera_permission_title),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = stringResource(id = com.samuraicmdv.featurebarcodescanner.R.string.camera_permission_details),
            fontSize = 16.sp,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(12.dp))

        when (cameraPermissionState.status) {
            is PermissionStatus.Granted -> { /* No op. This screen will not be visible*/ }

            is PermissionStatus.Denied -> {
                Spacer(modifier = Modifier.height(16.dp))

                // Button to request camera permission
                CustomButton(
                    label = stringResource(id = com.samuraicmdv.featurebarcodescanner.R.string.camera_permission_button_open_config_label),
                    type = CustomButtonType.MAIN_PRIMARY,
                    onClick = {
                        // Ask user permission to use the camera
                        val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS).apply {
                            data = Uri.fromParts("package", context.packageName, null)
                        }
                        context.startActivity(intent)
                    },
                )

                Spacer(modifier = Modifier.height(12.dp))

                // Button to exit the screen
                CustomButton(
                    label = stringResource(id = com.samuraicmdv.featurebarcodescanner.R.string.camera_permission_button_exit_screen_label),
                    type = CustomButtonType.MAIN_SECONDARY,
                    onClick = {
                        handleEvent(BarcodeScannerPresentationEvent.ExitScreen)
                    },
                )
            }
        }
    }
}

@OptIn(ExperimentalPermissionsApi::class)
@ThemePreviews
@Composable
fun PreviewCameraPermissionContent() {
    val mockPermissionState = object : PermissionState {
        override val permission: String = Manifest.permission.CAMERA
        override val status: PermissionStatus
            get() = PermissionStatus.Denied(
                shouldShowRationale = true
            )

        override fun launchPermissionRequest() {}
    }

    MobiTheme {
        Surface {
            CameraPermissionContent(
                cameraPermissionState = mockPermissionState,
                handleEvent = {}
            )
        }
    }
}
