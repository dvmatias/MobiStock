package com.samuraicmdv.featurebarcodescanner.state

/**
 * Data class representing the UI state of the barcode scanner feature.
 *
 * @param itemDetailsBottomSheetUiData The UI data for the scan details, which may include information about the scanned product
 * and whether the bottom sheet should be shown.
 */
data class BarcodeScannerState(
    val itemDetailsBottomSheetUiData: ItemDetailsBottomSheetUiData,
)
