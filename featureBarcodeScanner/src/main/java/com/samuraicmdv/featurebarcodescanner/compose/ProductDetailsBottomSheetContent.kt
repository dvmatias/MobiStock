package com.samuraicmdv.featurebarcodescanner.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewParameter
import com.samuraicmdv.common.theme.MobiTheme
import com.samuraicmdv.featurebarcodescanner.preview.ProductDetailsBottomSheetContentPreviewParameter
import com.samuraicmdv.featurebarcodescanner.state.ScanDetailsUiData
import com.samuraicmdv.ui.util.ThemePreviews

/**
 * ProductDetailsBottomSheetContent is a composable function that displays the content of the product details bottom
 * sheet.
 *
 * @param uiData The UI data containing product details and scanned barcode.
 * @param modifier A [Modifier] to be applied to the content.
 */
@Composable
fun ProductDetailsBottomSheetContent(
    uiData: ScanDetailsUiData,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(horizontal = MobiTheme.dimens.dimen_2)
    ) {
        if (uiData.isLoading) {
            ProductDetailsBottomSheetLoadingContent(
                scannedBarCode = uiData.scannedBarCode,
                scannedImageBitmap = uiData.scannedImageBitmap
            )
        } else {
            ProductDetailsBottomSheetReadyContent(uiData.productUiData ?: return)
        }
    }

}

@ThemePreviews
@Composable
fun PreviewProductDetailsBottomSheetContent(
    @PreviewParameter(ProductDetailsBottomSheetContentPreviewParameter::class) previewData: ScanDetailsUiData
) {
    MobiTheme {
        Surface(color = MobiTheme.colors.background) {
            ProductDetailsBottomSheetContent(
                uiData = previewData
            )
        }
    }
}
