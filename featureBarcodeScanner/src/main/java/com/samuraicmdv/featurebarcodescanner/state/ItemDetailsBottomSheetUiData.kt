package com.samuraicmdv.featurebarcodescanner.state

import androidx.compose.ui.graphics.ImageBitmap

/**
 * Represents the UI state for product details in the barcode scanner feature. This UI data powers the bottom
 * sheet that displays product information when a barcode is scanned.
 *
 * @property isLoading Indicates whether the product details are currently being loaded.
 * @property itemDetailsUiData Contains the details of the product, such as name, description, price, stock, and brand.
 * @property scannedBarCode The barcode that was scanned to retrieve the product details, if applicable.
 * @property scannedImageBitmap The bitmap image of the scanned barcode, used for display purposes.
 * @property showBottomSheet Indicates whether the bottom sheet displaying product details should be shown.
 */
data class ItemDetailsBottomSheetUiData(
    val isLoading: Boolean = false,
    val itemDetailsUiData: ItemDetailsUiData? = null,
    val scannedBarCode: String? = null,
    val scannedImageBitmap: ImageBitmap? = null,
    val showBottomSheet: Boolean = false,
)