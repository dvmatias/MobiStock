package com.samuraicmdv.featurebarcodescanner.compose

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import com.samuraicmdv.common.theme.MobiTheme
import com.samuraicmdv.ui.util.ThemePreviews

const val SCAN_REGION_WIDTH_FACTOR = 0.7f
const val SCAN_REGION_HEIGHT_FACTOR = 0.8f

@Composable
fun CameraOverlayContent(modifier: Modifier = Modifier) {
    var isVisible by remember { mutableStateOf(true) }

    Box {
        // Toggle visibility every 500ms
        LaunchedEffect(Unit) {
            while (true) {
                isVisible = !isVisible
                kotlinx.coroutines.delay(1)
            }
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Black.copy(alpha = 0.5f))
                .drawWithContent {
                    drawContent()
                    val squareWidth = size.width * SCAN_REGION_WIDTH_FACTOR
                    val squareHeight = squareWidth * SCAN_REGION_HEIGHT_FACTOR
                    val centerX = size.width / 2 - squareWidth / 2
                    val centerY = size.height / 2 - squareHeight / 2
                    drawRect(
                        color = Color(0xFFFFFFFF),
                        topLeft = Offset(x = centerX, y = centerY),
                        size = Size(
                            squareWidth,
                            squareHeight
                        ),
                        blendMode = BlendMode.DstOut
                    )
                }
        )

        Canvas(modifier = modifier.fillMaxSize()) {
            if (isVisible) {
                val centerX = size.width / 2
                val centerY = size.height / 2
                drawLine(
                    color = Color.Red,
                    start = Offset(centerX - size.width * 0.4f, centerY),
                    end = Offset(centerX + size.width * 0.4f, centerY),
                    strokeWidth = 8f
                )
            }
        }
    }
}

@ThemePreviews
@Composable
fun PreviewCameraOverlayContent() {
    MobiTheme {
        Surface {
            CameraOverlayContent()
        }
    }
}