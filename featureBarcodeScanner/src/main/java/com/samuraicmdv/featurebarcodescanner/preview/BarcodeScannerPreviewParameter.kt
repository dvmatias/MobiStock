package com.samuraicmdv.featurebarcodescanner.preview

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.samuraicmdv.common.uidata.ProductBrandUiData
import com.samuraicmdv.common.uidata.ProductPriceUiData
import com.samuraicmdv.common.uidata.ProductStockUiData
import com.samuraicmdv.common.uidata.ProductUiData
import com.samuraicmdv.featurebarcodescanner.state.BarcodeScannerState
import com.samuraicmdv.featurebarcodescanner.state.ScanDetailsUiData

class BarcodeScannerScreenPreviewParameter : PreviewParameterProvider<BarcodeScannerState> {
    override val values: Sequence<BarcodeScannerState>
        get() = TODO("Not yet implemented")
}

class ProductDetailsBottomSheetPreviewParameter : PreviewParameterProvider<ScanDetailsUiData> {
    override val values: Sequence<ScanDetailsUiData>
        get() = sequenceOf(
            getScanDetailsUiDataLoading(),
            getScanDetailsUiDataReady()
        )
}

class ProductDetailsBottomSheetContentPreviewParameter : PreviewParameterProvider<ScanDetailsUiData> {
    override val values: Sequence<ScanDetailsUiData>
        get() = sequenceOf(
            getScanDetailsUiDataLoading(),
            getScanDetailsUiDataReady()
        )
}

class ProductDetailsBottomSheetLoadingContentPreviewParameter : PreviewParameterProvider<ScanDetailsUiData> {
    override val values: Sequence<ScanDetailsUiData>
        get() = sequenceOf(getScanDetailsUiDataLoading())
}

class ProductDetailsBottomSheetReadyContentPreviewParameter : PreviewParameterProvider<ProductUiData> {
    override val values: Sequence<ProductUiData>
        get() = sequenceOf(getScanDetailsUiDataReady().productUiData!!)
}

fun getScanDetailsUiDataLoading() =
    ScanDetailsUiData(
        isLoading = true,
        showBottomSheet = true,
        productUiData = null,
        scannedBarCode = "1234567890123"
    )

fun getScanDetailsUiDataReady() =
    ScanDetailsUiData(
        isLoading = false,
        showBottomSheet = true,
        productUiData = ProductUiData(
            id = 1,
            name = "Sample Product",
            shortDescription = "This is a sample product.",
            longDescription = "This is a sample product. This product is used for demonstration purposes. This is a sample product. This product is used for demonstration purposes.",
            model = "Model X",
            code = "SP-12345",
            sku = "SKU-123456789",
            thumbnailUrl = "https://example.com/thumbnail.jpg",
            imageUrls = listOf("https://example.com/image1.jpg", "https://example.com/image2.jpg"),
            price = ProductPriceUiData(
                sellingPrice = 799.99,
                costPrice = 599.99,
                currency = "ARS"
            ),
            stock = ProductStockUiData(
                quantity = 50
            ),
            rating = 4.5,
            reviews = 100,
            isFavorite = true,
            productCategoryName = "Cable",
            productSubcategoryName = "Charging Cable",
            brand = ProductBrandUiData(
                id = 1,
                name = "Brand Name",
                logoUrl = "https://example.com/brand-logo.png"
            )
        ),
        scannedBarCode = "1234567890123"
    )