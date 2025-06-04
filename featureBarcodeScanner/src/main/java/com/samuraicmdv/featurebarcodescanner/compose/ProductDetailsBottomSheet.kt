package com.samuraicmdv.featurebarcodescanner.compose

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.ModalBottomSheetProperties
import androidx.compose.material3.SheetState
import androidx.compose.material3.Surface
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import com.samuraicmdv.common.theme.MobiTheme
import com.samuraicmdv.common.uidata.ProductUiData
import com.samuraicmdv.featurebarcodescanner.event.BarcodeScannerEvent
import com.samuraicmdv.featurebarcodescanner.event.BarcodeScannerPresentationEvent
import com.samuraicmdv.featurebarcodescanner.state.ProductDetailsUiData
import com.samuraicmdv.ui.util.ThemePreviews
import kotlinx.coroutines.launch

/**
 * ProductDetailsBottomSheet is a composable function that displays a bottom sheet with product details and the scanned
 * barcode.
 *
 * @param uiData The UI data containing product details and scanned barcode.
 * @param bottomSheetState The state of the bottom sheet.
 * @param handleEvent A lambda function to handle events emitted from the bottom sheet.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductDetailsBottomSheet(
    uiData: ProductDetailsUiData,
    bottomSheetState: SheetState,
    handleEvent: (BarcodeScannerEvent) -> Unit
) {
    val coroutineScope = rememberCoroutineScope()
    val showBottomSheet = uiData.showBottomSheet

    LaunchedEffect(key1 = showBottomSheet) {
        if (showBottomSheet) bottomSheetState.show()
        else bottomSheetState.hide()
    }

    if (showBottomSheet) {
        ModalBottomSheet(
            onDismissRequest = {
                coroutineScope.launch {
                    handleEvent(BarcodeScannerPresentationEvent.OnBottomSheetDismissed)
                }
            },
            sheetState = bottomSheetState,
            properties = ModalBottomSheetProperties(
                shouldDismissOnBackPress = true,
            )
        ) {
            ProductDetailsBottomSheetContent(uiData)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@ThemePreviews
@Composable
fun PreviewProductDetailsBottomSheet_Loading() {
    MobiTheme {
        Surface(color = MobiTheme.colors.background) {
            val bottomSheetState = rememberModalBottomSheetState(skipPartiallyExpanded = false)

            ProductDetailsBottomSheet(
                uiData = ProductDetailsUiData(
                    isLoading = true,
                    showBottomSheet = true,
                    productUiData = null,
                    scannedBarCode = "1234567890123"
                ),
                bottomSheetState = bottomSheetState,
                handleEvent = {},
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@ThemePreviews
@Composable
fun PreviewProductDetailsBottomSheet_Ready() {
    MobiTheme {
        Surface(color = MobiTheme.colors.background) {
            val bottomSheetState = rememberModalBottomSheetState(skipPartiallyExpanded = false)

            ProductDetailsBottomSheet(
                uiData = ProductDetailsUiData(
                    isLoading = false,
                    showBottomSheet = true,
                    productUiData = ProductUiData(
                        id = 1,
                        name = "Sample Product",
                        shortDescription = "This is a sample product.",
                        longDescription = "This product is used for demonstration purposes.",
                        model = "Model X",
                        code = "SP-12345",
                        sku = "SKU-12345",
                        thumbnailUrl = "https://example.com/thumbnail.jpg",
                        imageUrls = listOf("https://example.com/image1.jpg", "https://example.com/image2.jpg"),
                        price = null, // Assuming ProductPriceUiData is defined elsewhere
                        stock = null, // Assuming ProductStockUiData is defined elsewhere
                        rating = 4.5,
                        reviews = 100,
                        isFavorite = true,
                        brand = null // Assuming ProductBrandUiData is defined elsewhere
                    ),
                    scannedBarCode = "1234567890123"
                ),
                bottomSheetState = bottomSheetState,
                handleEvent = {}
            )
        }
    }
}