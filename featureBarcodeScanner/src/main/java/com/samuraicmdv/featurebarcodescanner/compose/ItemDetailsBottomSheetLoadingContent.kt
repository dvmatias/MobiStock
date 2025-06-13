package com.samuraicmdv.featurebarcodescanner.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.samuraicmdv.common.theme.MobiTheme
import com.samuraicmdv.featurebarcodescanner.preview.ItemDetailsBottomSheetLoadingContentPreviewParameter
import com.samuraicmdv.featurebarcodescanner.state.ItemDetailsBottomSheetUiData
import com.samuraicmdv.ui.util.ThemePreviews

/**
 * Composable function to display the loading content of the product details bottom sheet.
 *
 * @param scannedBarCode The barcode that was scanned, displayed as text.
 * @param scannedImageBitmap The bitmap image of the scanned barcode, displayed as an image.
 */
@Composable
fun ItemDetailsBottomSheetLoadingContent(
    scannedBarCode: String?,
    scannedImageBitmap: ImageBitmap?,
    modifier: Modifier = Modifier
) {
    // Display the scanned barcode
    Text(
        text = "Scanned Barcode: $scannedBarCode",
    )

    Spacer(modifier = Modifier.height(MobiTheme.dimens.dimen_1))

    // Scanned image preview
    scannedImageBitmap?.let {
        Image(
            bitmap = it,
            contentDescription = "Scanned bitmap",
            modifier = Modifier.width(200.dp)
        )
    }

    // Show loading indicator
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        CircularProgressIndicator(
            modifier = Modifier.padding(MobiTheme.dimens.dimen_2),
        )
    }
}

@ThemePreviews
@Composable
fun PreviewItemDetailsBottomSheetLoadingContent(
    @PreviewParameter(ItemDetailsBottomSheetLoadingContentPreviewParameter::class) previewData: ItemDetailsBottomSheetUiData
) {
    MobiTheme {
        Surface(color = MobiTheme.colors.background) {
            ItemDetailsBottomSheetLoadingContent(
                scannedBarCode = previewData.scannedBarCode,
                scannedImageBitmap = previewData.scannedImageBitmap,
            )
        }
    }
}