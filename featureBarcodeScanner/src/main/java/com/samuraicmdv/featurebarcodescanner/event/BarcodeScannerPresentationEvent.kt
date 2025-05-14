package com.samuraicmdv.featurebarcodescanner.event

/**
 * BarcodeScannerPresentationEvent is a sealed interface that represents the events that can be emitted
 * from the barcode scanner and should be handld by presentation layer.
 *
 * @see BarcodeScannerEvent
 */
sealed interface BarcodeScannerPresentationEvent : BarcodeScannerEvent {
    data class OnBarcodeScanned(val barcode: String) : BarcodeScannerPresentationEvent
    data object OnBarcodeLost : BarcodeScannerPresentationEvent
}