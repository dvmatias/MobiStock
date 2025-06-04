package com.samuraicmdv.featurebarcodescanner.event

import androidx.compose.ui.graphics.ImageBitmap

/**
 * BarcodeScannerPresentationEvent is a sealed interface that represents the events that can be emitted
 * from the barcode scanner and should be handled by presentation layer.
 *
 * @see BarcodeScannerEvent
 */
sealed interface BarcodeScannerPresentationEvent : BarcodeScannerEvent {
    /**
     * Event emitted when a barcode is successfully scanned.
     *
     * @param barcode The scanned barcode string.
     * @param bitmap The image bitmap of the scanned barcode, can be null if not available.
     */
    data class OnBarcodeScanned(
        val barcode: String,
        val bitmap: ImageBitmap?
    ) : BarcodeScannerPresentationEvent

    /**
     * Event emitted when the barcode scanner has lost the code after a successful scan.
     */
    data object OnBarcodeLost : BarcodeScannerPresentationEvent

    /**
     * Exit screen event.
     */
    data object ExitScreen : BarcodeScannerNavigationEvent

    /**
     * Event emitted when the bottom sheet is dismissed.
     */
    data object OnBottomSheetDismissed : BarcodeScannerNavigationEvent
}