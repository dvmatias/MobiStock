package com.samuraicmdv.featurebarcodescanner.state

import androidx.compose.ui.graphics.ImageBitmap

data class BarcodeScannerUiData(
    val lastScannedBarcode: String? = null,
    val scannedImageBitmap: ImageBitmap? = null,
)
