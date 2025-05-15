package com.samuraicmdv.featurebarcodescanner

import androidx.lifecycle.ViewModel
import com.samuraicmdv.featurebarcodescanner.event.BarcodeScannerEvent
import com.samuraicmdv.featurebarcodescanner.event.BarcodeScannerPresentationEvent
import com.samuraicmdv.featurebarcodescanner.state.BarcodeScannerUiData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class BarcodeScannerViewModel @Inject constructor() : ViewModel() {
    /**
     * StateFlow that holds the UI data for the barcode scanner.
     */
    private var _uiData = MutableStateFlow(BarcodeScannerUiData())
    val uiData: StateFlow<BarcodeScannerUiData>
        get() = _uiData

    /**
     * Flow that emits the scanned barcode event. This flow is used to notify the activity when a barcode is
     * successfully scanned.
     */
    private val _scanSuccessEventFlow = MutableSharedFlow<BarcodeScannerPresentationEvent.OnBarcodeScanned>(replay = 1)
    val scanSuccessEventFlow: SharedFlow<BarcodeScannerPresentationEvent.OnBarcodeScanned>
        get() = _scanSuccessEventFlow

    /**
     * Handles the events emitted from the barcode scanner flow.
     */
    fun handleEvent(event: BarcodeScannerEvent) {
        when (event) {
            // Barcode scanned successfully
            is BarcodeScannerPresentationEvent.OnBarcodeScanned -> onBarcodeScanned(event)
            // After a barcode is scanned, the scanner lost the code and it is ready to scan again
            is BarcodeScannerPresentationEvent.OnBarcodeLost -> onBarcodeLost()
        }
    }

    /**
     * Handles the event when a barcode is scanned. It updates the UI data with the new scanned barcode and the scanned
     * image bitmap.
     *
     * @param event The event containing the scanned barcode and the image bitmap.
     */
    private fun onBarcodeScanned(event: BarcodeScannerPresentationEvent.OnBarcodeScanned) {
        // Check if the scanned barcode is different from the last scanned barcode
        if (_uiData.value.lastScannedBarcode == null || _uiData.value.lastScannedBarcode != event.barcode) {
            // Updates the UI data with the new scanned barcode and image bitmap
            _uiData.value = _uiData.value.copy(
                lastScannedBarcode = event.barcode,
                scannedImageBitmap = event.bitmap
            )
            // Emit the scanned barcode event to the flow so the activity can sound the "pip"
            _scanSuccessEventFlow.tryEmit(event)
        }
    }

    /**
     * Handles the event when a barcode is lost. It resets the last scanned barcode in the UI data.
     */
    private fun onBarcodeLost() {
        _uiData.value.lastScannedBarcode?.let {
            _uiData.value = _uiData.value.copy(lastScannedBarcode = null)
        }
    }

}