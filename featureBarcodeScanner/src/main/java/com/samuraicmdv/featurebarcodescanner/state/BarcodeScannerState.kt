package com.samuraicmdv.featurebarcodescanner.state

import androidx.compose.ui.graphics.ImageBitmap

/**
 * Data class representing the UI state of the barcode scanner feature.
 *
 * @param lastScannedBarcode The last scanned barcode string, or null if no barcode has been scanned.
 * @param scannedImageBitmap The bitmap image of the scanned barcode, or null if not available.
 * @param productDetailsUiData The UI data for product details, which may include information about the scanned product
 * and whether the bottom sheet should be shown.
 */
data class BarcodeScannerState(
    val lastScannedBarcode: String? = null,
    val scannedImageBitmap: ImageBitmap? = null,
    val productDetailsUiData: ProductDetailsUiData? = null,
)
