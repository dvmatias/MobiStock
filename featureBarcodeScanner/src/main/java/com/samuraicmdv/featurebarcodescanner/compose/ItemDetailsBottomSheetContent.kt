package com.samuraicmdv.featurebarcodescanner.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewParameter
import com.samuraicmdv.common.theme.MobiTheme
import com.samuraicmdv.featurebarcodescanner.preview.ItemDetailsBottomSheetContentPreviewParameter
import com.samuraicmdv.featurebarcodescanner.state.BarcodeScannerState
import com.samuraicmdv.ui.util.ThemePreviews

/**
 * ProductDetailsBottomSheetContent is a composable function that displays the content of the item details bottom
 * sheet.
 *
 * @param uiData The UI data containing item details and scanned barcode.
 * @param modifier A [Modifier] to be applied to the content.
 */
@Composable
fun ItemDetailsBottomSheetContent(
    uiData: BarcodeScannerState,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(horizontal = MobiTheme.dimens.dimen_2)
    ) {
        if (uiData.isBottomSheetLoading) {
            ItemDetailsBottomSheetLoadingContent(
                scannedBarCode = uiData.scannedBarCode,
                scannedImageBitmap = uiData.scannedImageBitmap
            )
        } else {
            ItemDetailsBottomSheetReadyContent(uiData.itemDetailsUiData ?: return)
        }
    }

}

@ThemePreviews
@Composable
fun PreviewItemDetailsBottomSheetContent(
    @PreviewParameter(ItemDetailsBottomSheetContentPreviewParameter::class) previewData: BarcodeScannerState
) {
    MobiTheme {
        Surface(color = MobiTheme.colors.background) {
            ItemDetailsBottomSheetContent(
                uiData = previewData
            )
        }
    }
}
