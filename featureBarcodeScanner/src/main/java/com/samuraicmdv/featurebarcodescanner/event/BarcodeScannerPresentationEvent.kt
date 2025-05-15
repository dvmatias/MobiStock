package com.samuraicmdv.featurebarcodescanner.event

import androidx.compose.ui.graphics.ImageBitmap

/**
 * BarcodeScannerPresentationEvent is a sealed interface that represents the events that can be emitted
 * from the barcode scanner and should be handled by presentation layer.
 *
 * @see BarcodeScannerEvent
 */
sealed interface BarcodeScannerPresentationEvent : BarcodeScannerEvent {
    data class OnBarcodeScanned(val barcode: String, val bitmap: ImageBitmap?) : BarcodeScannerPresentationEvent
    data object OnBarcodeLost : BarcodeScannerPresentationEvent
}