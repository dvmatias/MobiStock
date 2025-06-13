package com.samuraicmdv.featurebarcodescanner.state

import androidx.compose.ui.graphics.ImageBitmap

/**
 * Data class representing the UI state of the barcode scanner feature.
 *
 * @property isBottomSheetDisplayed Indicates whether the bottom sheet displaying product details should be shown.
 * @property isBottomSheetLoading Indicates whether the product details are currently being loaded.
 * @property itemDetailsUiData The UI data for the scan details, which may include information about the scanned product
 * and whether the bottom sheet should be shown.
 * @property scannedBarCode The barcode that was scanned to retrieve the product details, if applicable.
 * @property scannedImageBitmap The bitmap image of the scanned barcode, used for display purposes.
 */
data class BarcodeScannerState(
    val isBottomSheetLoading: Boolean = false,
    val itemDetailsUiData: ItemDetailsUiData? = null,
    val isBottomSheetDisplayed: Boolean = false,
    val scannedBarCode: String? = null,
    val scannedImageBitmap: ImageBitmap? = null,
)
