package com.samuraicmdv.featurebarcodescanner.preview

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.samuraicmdv.featurebarcodescanner.state.BarcodeScannerState
import com.samuraicmdv.featurebarcodescanner.state.ItemDetailsBottomSheetUiData
import com.samuraicmdv.featurebarcodescanner.state.ItemDetailsUiData

class BarcodeScannerScreenPreviewParameter : PreviewParameterProvider<BarcodeScannerState> {
    override val values: Sequence<BarcodeScannerState>
        get() = sequenceOf(BarcodeScannerState(
            itemDetailsBottomSheetUiData = getScanDetailsUiDataReady(),
        ))
}

class ProductDetailsBottomSheetPreviewParameter : PreviewParameterProvider<ItemDetailsBottomSheetUiData> {
    override val values: Sequence<ItemDetailsBottomSheetUiData>
        get() = sequenceOf(
            getScanDetailsUiDataLoading(),
            getScanDetailsUiDataReady()
        )
}

class ItemDetailsBottomSheetContentPreviewParameter : PreviewParameterProvider<ItemDetailsBottomSheetUiData> {
    override val values: Sequence<ItemDetailsBottomSheetUiData>
        get() = sequenceOf(
            getScanDetailsUiDataLoading(),
            getScanDetailsUiDataReady()
        )
}

class ItemDetailsBottomSheetLoadingContentPreviewParameter : PreviewParameterProvider<ItemDetailsBottomSheetUiData> {
    override val values: Sequence<ItemDetailsBottomSheetUiData>
        get() = sequenceOf(getScanDetailsUiDataLoading())
}

class ItemDetailsBottomSheetReadyContentPreviewParameter : PreviewParameterProvider<ItemDetailsUiData> {
    override val values: Sequence<ItemDetailsUiData>
        get() = sequenceOf(getScanDetailsUiDataReady().itemDetailsUiData!!)
}

fun getScanDetailsUiDataLoading() =
    ItemDetailsBottomSheetUiData(
        isLoading = true,
        showBottomSheet = true,
        itemDetailsUiData = null,
        scannedBarCode = "1234567890123"
    )

fun getScanDetailsUiDataReady() =
    ItemDetailsBottomSheetUiData(
        isLoading = false,
        showBottomSheet = true,
        itemDetailsUiData = ItemDetailsUiData(
            id = 1,
            brandLogoUrl = "https://example.com/brand-logo.png",
            brandName = "Samsung",
            categorySubcategory = "Cable - Charger Cable",
            code = "CABL00025",
            description = "This is a sample product. This product is used for demonstration purposes. This is a sample product. This product is used for demonstration purposes.",
            price = 799.99,
            stock = 15,
            thumbnailUrl = "https://example.com/thumbnail.jpg",
            title = "Cable USB 3.0 - 25W - USB A a C"
        ),
        scannedBarCode = "1234567890123"
    )