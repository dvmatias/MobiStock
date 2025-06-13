package com.samuraicmdv.featurebarcodescanner.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewParameter
import com.samuraicmdv.common.theme.MobiTheme
import com.samuraicmdv.featurebarcodescanner.preview.ItemDetailsBottomSheetContentPreviewParameter
import com.samuraicmdv.featurebarcodescanner.state.ItemDetailsBottomSheetUiData
import com.samuraicmdv.ui.util.ThemePreviews

/**
 * ProductDetailsBottomSheetContent is a composable function that displays the content of the product details bottom
 * sheet.
 *
 * @param uiData The UI data containing product details and scanned barcode.
 * @param modifier A [Modifier] to be applied to the content.
 */
@Composable
fun ItemDetailsBottomSheetContent(
    uiData: ItemDetailsBottomSheetUiData,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(horizontal = MobiTheme.dimens.dimen_2)
    ) {
        if (uiData.isLoading) {
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
    @PreviewParameter(ItemDetailsBottomSheetContentPreviewParameter::class) previewData: ItemDetailsBottomSheetUiData
) {
    MobiTheme {
        Surface(color = MobiTheme.colors.background) {
            ItemDetailsBottomSheetContent(
                uiData = previewData
            )
        }
    }
}
