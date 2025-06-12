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
import androidx.compose.ui.tooling.preview.PreviewParameter
import com.samuraicmdv.common.theme.MobiTheme
import com.samuraicmdv.featurebarcodescanner.event.BarcodeScannerEvent
import com.samuraicmdv.featurebarcodescanner.event.BarcodeScannerPresentationEvent
import com.samuraicmdv.featurebarcodescanner.preview.ProductDetailsBottomSheetPreviewParameter
import com.samuraicmdv.featurebarcodescanner.state.ScanDetailsUiData
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
    uiData: ScanDetailsUiData,
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
            ),
            containerColor = MobiTheme.colors.surfaceContainer
        ) {
            ProductDetailsBottomSheetContent(uiData)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@ThemePreviews
@Composable
fun PreviewProductDetailsBottomSheet(
    @PreviewParameter(ProductDetailsBottomSheetPreviewParameter::class) previewData: ScanDetailsUiData
) {
    MobiTheme {
        Surface(color = MobiTheme.colors.background) {
            val bottomSheetState = rememberModalBottomSheetState(skipPartiallyExpanded = false)

            ProductDetailsBottomSheet(
                uiData = previewData,
                bottomSheetState = bottomSheetState,
                handleEvent = {},
            )
        }
    }
}
