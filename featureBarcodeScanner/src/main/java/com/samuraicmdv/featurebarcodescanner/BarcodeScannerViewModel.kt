package com.samuraicmdv.featurebarcodescanner

import androidx.lifecycle.ViewModel
import com.samuraicmdv.featurebarcodescanner.event.BarcodeScannerPresentationEvent
import com.samuraicmdv.featurebarcodescanner.state.BarcodeScannerState
import com.samuraicmdv.featurebarcodescanner.state.ScanDetailsUiData
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
    private var _uiData = MutableStateFlow(BarcodeScannerState())
    val uiData: StateFlow<BarcodeScannerState>
        get() = _uiData

    /**
     * Flow that emits the scanned barcode event. This flow is used to notify the activity when a barcode is
     * successfully scanned.
     */
    private val _scanSuccessEventFlow = MutableSharedFlow<BarcodeScannerPresentationEvent.OnBarcodeScanned>(replay = 1)
    val scanSuccessEventFlow: SharedFlow<BarcodeScannerPresentationEvent.OnBarcodeScanned>
        get() = _scanSuccessEventFlow

    private var canScan: Boolean = true

    /**
     * Handles the event when a barcode is scanned. It updates the UI data with the new scanned barcode and the scanned
     * image bitmap.
     *
     * @param event The event containing the scanned barcode and the image bitmap.
     */
    fun onBarcodeScanned(event: BarcodeScannerPresentationEvent.OnBarcodeScanned) {
        // Check if scanning is allowed and if the scanned barcode is different from the last scanned barcode
        if (canScan && (_uiData.value.lastScannedBarcode == null || _uiData.value.lastScannedBarcode != event.barcode)) {
            // Prevent further scans until the current one is processed
            canScan = false

            // Emit the scanned barcode event to the flow so the activity can sound the "pip"
            _scanSuccessEventFlow.tryEmit(event)

            // Updates the UI data with the new scanned barcode and image bitmap
            _uiData.value = _uiData.value.copy(
                lastScannedBarcode = event.barcode,
            )
            // Update the product details UI data with the scanned barcode
            _uiData.value = _uiData.value.copy(
                scanDetailsUiData = _uiData.value.scanDetailsUiData?.copy(
                    showBottomSheet = true,
                    isLoading = true,
                    scannedBarCode = event.barcode,
                    scannedImageBitmap = event.bitmap
                ) ?: ScanDetailsUiData(
                    showBottomSheet = true,
                    isLoading = true,
                    scannedBarCode = event.barcode,
                    scannedImageBitmap = event.bitmap
                )
            )
        }
    }

    /**
     * Handles the event when a barcode is lost. It resets the last scanned barcode in the UI data.
     */
    fun onBarcodeLost() {
        _uiData.value.lastScannedBarcode?.let {
            _uiData.value = _uiData.value.copy(lastScannedBarcode = null)
        }
    }

    /**
     *  Checks if the bottom sheet should be dismissed.
     */
    fun shouldDismissBottomSheet(): Boolean =
        _uiData.value.scanDetailsUiData?.showBottomSheet == true

    /**
     *  Dismisses the bottom sheet and resets the loading state. Also, allows scanning again.
     */
    fun dismissBottomSheet() {
        _uiData.value = _uiData.value.copy(
            scanDetailsUiData = _uiData.value.scanDetailsUiData?.copy(
                showBottomSheet = false,
                isLoading = false
            )
        )
        // Allow scanning again after dismissing the bottom sheet
        canScan = true
    }

}