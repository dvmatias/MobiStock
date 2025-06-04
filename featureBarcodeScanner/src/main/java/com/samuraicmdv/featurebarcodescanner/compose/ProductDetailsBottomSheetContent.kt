package com.samuraicmdv.featurebarcodescanner.compose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.samuraicmdv.common.theme.MobiTheme
import com.samuraicmdv.common.uidata.ProductUiData
import com.samuraicmdv.featurebarcodescanner.state.ProductDetailsUiData
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
    uiData: ProductDetailsUiData,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.padding(horizontal = MobiTheme.dimens.dimen_2)) {
        // Display the scanned barcode
        Text(
            text = "Scanned Barcode: ${uiData.scannedBarCode}",
        )

        if (uiData.isLoading) {
            // Show loading indicator
            Box(
                contentAlignment = Alignment.Center,
                modifier = modifier.fillMaxWidth().wrapContentHeight()
            ) {
                CircularProgressIndicator(
                    modifier = Modifier.padding(MobiTheme.dimens.dimen_2),
                )
            }
        } else {
            Text("This is the product details bottom sheet content", modifier = modifier)
        }
    }

}

@ThemePreviews
@Composable
fun PreviewProductDetailsBottomSheetContent_Loading() {
    MobiTheme {
        Surface {
            ProductDetailsBottomSheetContent(
                uiData = ProductDetailsUiData(
                    isLoading = true,
                    productUiData = null,
                    scannedBarCode = "CABL0034",
                )
            )
        }
    }
}

@ThemePreviews
@Composable
fun PreviewProductDetailsBottomSheetContent_Ready() {
    MobiTheme {
        Surface {
            ProductDetailsBottomSheetContent(
                uiData = ProductDetailsUiData(
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
                    scannedBarCode = "CABL0034",
                )
            )
        }
    }
}