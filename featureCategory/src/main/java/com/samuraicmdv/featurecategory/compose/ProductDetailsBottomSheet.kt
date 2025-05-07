package com.samuraicmdv.featurecategory.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetValue
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.rememberNestedScrollInteropConnection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.samuraicmdv.common.theme.MobiTheme
import com.samuraicmdv.featurecategory.R
import com.samuraicmdv.featurecategory.event.CategoryEvent
import com.samuraicmdv.featurecategory.event.CategoryNavigationEvent
import com.samuraicmdv.featurecategory.event.CategoryPresentationEvent.HandleProductDetailsBottomSheetState
import com.samuraicmdv.featurecategory.state.ProductBrandUiData
import com.samuraicmdv.featurecategory.state.ProductPriceUiData
import com.samuraicmdv.featurecategory.state.ProductStockUiData
import com.samuraicmdv.featurecategory.state.ProductUiData
import com.samuraicmdv.ui.util.ThemePreviews
import com.samuraicmdv.ui.widget.IconLabelValue
import com.samuraicmdv.ui.widget.LabelValue
import com.samuraicmdv.ui.widget.PriceComponentLevel
import com.samuraicmdv.ui.widget.PriceComponentStyle
import com.samuraicmdv.ui.widget.PriceComponentWeight
import com.samuraicmdv.ui.widget.StyledPriceComponent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductDetailsBottomSheet(
    product: ProductUiData?,
    showBottomSheet: Boolean,
    handleEvent: (CategoryEvent) -> Unit,
    modifier: Modifier = Modifier,
) {
    product?.let { selectedProduct ->
        val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)

        LaunchedEffect(key1 = showBottomSheet) {
            if (showBottomSheet) sheetState.show()
            else sheetState.hide()
        }

        LaunchedEffect(sheetState.currentValue) {
            if (sheetState.currentValue == SheetValue.Expanded &&
                sheetState.targetValue == SheetValue.PartiallyExpanded
            )
                sheetState.hide()
        }

        if (showBottomSheet) {
            ModalBottomSheet(
                sheetState = sheetState,
                onDismissRequest = {
                    handleEvent(HandleProductDetailsBottomSheetState(show = false))
                },
                dragHandle = { BottomSheetDefaults.DragHandle() },
                containerColor = MobiTheme.colors.background,
                modifier = modifier
                    .nestedScroll(rememberNestedScrollInteropConnection())
                    .fillMaxHeight(0.6f)
            ) {
                ProductDetailsBottomSheetContent(
                    product = selectedProduct,
                    isAdmin = true, // TODO replace with real value,
                    handleEvent = {
                        handleEvent(it)
                    },
                )
            }
        }
    }
}

@Composable
fun ProductDetailsBottomSheetContent(
    product: ProductUiData,
    isAdmin: Boolean,
    handleEvent: (CategoryEvent) -> Unit,
    modifier: Modifier = Modifier,
) {
    val lazyListState = rememberLazyListState(initialFirstVisibleItemIndex = 0)
    val context = LocalContext.current

    Column(
        modifier = modifier
            .fillMaxSize()
            .navigationBarsPadding()
    ) {
        LazyColumn(
            userScrollEnabled = true,
            state = lazyListState,
            modifier = Modifier
                .nestedScroll(rememberNestedScrollInteropConnection())
                .weight(1F)
        ) {
            product.imageUrls?.let { imageUrls ->
                item {
                    Column {

                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(MobiTheme.dimens.dimen_1),
                            modifier = Modifier.padding(horizontal = MobiTheme.dimens.dimen_2)
                        ) {
                            product.brand?.logoUrl?.let { brandLogoUrl ->
                                Image(
                                    painter = rememberAsyncImagePainter(model = brandLogoUrl),
                                    contentDescription = null,
                                    contentScale = ContentScale.Fit,
                                    modifier = Modifier
                                        .size(42.dp)
                                        .clip(RoundedCornerShape(MobiTheme.dimens.dimen_0_5))
                                )
                            }
                            product.brand?.name?.let { brandName ->
                                Text(
                                    text = brandName,
                                    style = MobiTheme.typography.bodyMediumBold,
                                    modifier = Modifier
                                )
                            }
                        }
                        Spacer(modifier = Modifier.height(MobiTheme.dimens.dimen_1))
                        product.name?.let { productName ->
                            Text(
                                text = productName,
                                style = MobiTheme.typography.titleMediumBold,
                                modifier = Modifier.padding(horizontal = MobiTheme.dimens.dimen_2)
                            )
                        }
                        Spacer(modifier = Modifier.height(MobiTheme.dimens.dimen_1))
                        product.price?.sellingPrice?.let { price ->
                            StyledPriceComponent(
                                amount = price,
                                priceComponentWeight = PriceComponentWeight.BOLD,
                                priceComponentStyle = PriceComponentStyle.MEDIUM,
                                priceComponentLevel = PriceComponentLevel.POSITIVE,
                                modifier = Modifier
                                    .align(Alignment.Start)
                                    .padding(horizontal = MobiTheme.dimens.dimen_2)
                            )
                        }

                        Spacer(modifier = Modifier.height(MobiTheme.dimens.dimen_2))
                        LazyRow(
                            contentPadding = PaddingValues(
                                horizontal = MobiTheme.dimens.dimen_2,
                                vertical = MobiTheme.dimens.dimen_2
                            ),
                            horizontalArrangement = Arrangement.spacedBy(MobiTheme.dimens.dimen_1)
                        ) {
                            imageUrls.forEach {
                                item {
                                    Card(
                                        shape = RoundedCornerShape(MobiTheme.dimens.dimen_1),
                                        colors = CardDefaults.cardColors(MobiTheme.colors.surface),
                                        elevation = CardDefaults.cardElevation(MobiTheme.elevations.two),
                                        modifier = Modifier
                                    ) {
                                        Image(
                                            painter = rememberAsyncImagePainter(model = it),
                                            contentDescription = null,
                                            contentScale = ContentScale.Crop,
                                            modifier = Modifier
                                                .height(150.dp)
                                                .aspectRatio(1F)
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }

            item {
                Column(
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(horizontal = MobiTheme.dimens.dimen_2)
                ) {

                    Spacer(modifier = Modifier.height(MobiTheme.dimens.dimen_2))
                    Text(
                        text = stringResource(id = R.string.title_product_description),
                        style = MobiTheme.typography.titleSmallBold
                    )
                    Spacer(modifier = Modifier.height(MobiTheme.dimens.dimen_1))
                    product.shortDescription?.let {
                        Text(
                            text = it,
                            style = MobiTheme.typography.bodyMedium,
                            color = MobiTheme.colors.textSecondary,
                        )
                        Spacer(modifier = Modifier.height(MobiTheme.dimens.dimen_2))
                    }
                    LabelValue(
                        label = stringResource(id = R.string.title_product_model),
                        value = product.model,
                    )
                    Spacer(modifier = Modifier.height(MobiTheme.dimens.dimen_2))
                    product.code?.let { productCode ->
                        LabelValue(
                            label = stringResource(id = R.string.title_product_code),
                            value = productCode
                        )
                        Spacer(modifier = Modifier.height(MobiTheme.dimens.dimen_2))
                    }
                    LabelValue(
                        label = stringResource(id = R.string.title_product_sku),
                        value = product.sku
                    )
                    Spacer(modifier = Modifier.height(MobiTheme.dimens.dimen_2))

                    IconLabelValue(
                        label = stringResource(id = R.string.title_product_quantity),
                        value = product.stock?.quantity?.toString(),
                        icon = {
                            Icon(
                                painter = painterResource(id = R.drawable.in_stock_ic),
                                contentDescription = null,
                                modifier = Modifier.size(24.dp)
                            )
                        }
                    )
                    Spacer(modifier = Modifier.height(MobiTheme.dimens.dimen_2))

                }
            }
            item {
                Spacer(modifier = Modifier.height(MobiTheme.dimens.dimen_2))
            }
        }

        Button(
            onClick = {
                handleEvent(CategoryNavigationEvent.NavigateProductDetails(false, product.id))
            },
            enabled = isAdmin,
            shape = RoundedCornerShape(MobiTheme.dimens.dimen_1_5),
            modifier = Modifier
                .padding(
                    start = MobiTheme.dimens.dimen_2,
                    end = MobiTheme.dimens.dimen_2,
                    bottom = MobiTheme.dimens.dimen_2,
                    top = MobiTheme.dimens.dimen_1
                )
                .fillMaxWidth()
                .height(48.dp)
        ) {
            Text(
                text = stringResource(id = R.string.label_product_details_button).uppercase(),
                style = MobiTheme.typography.buttonLabel
            )
        }
    }

}

@ThemePreviews
@Composable
fun PreviewProductDetailsBottomSheetContentAdminStatic() {
    MobiTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            ProductDetailsBottomSheetContent(
                product = ProductUiData(
                    id = 0,
                    name = "Product name",
                    shortDescription = "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
                    longDescription = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam at tempus nulla, eget vestibulum tortor. Etiam quis nisl justo.",
                    model = "Product model",
                    code = "Product code",
                    sku = "ABCD-00000001",
                    imageUrls = List(5) {
                        "url"
                    },
                    price = ProductPriceUiData(
                        sellingPrice = 100.0,
                        costPrice = 50.0,
                        currency = "ARS"
                    ),
                    stock = ProductStockUiData(
                        quantity = 100,
                        low = 10,
                        min = 5
                    ),
                    rating = 4.5,
                    reviews = 100,
                    isFavorite = false,
                    brand = ProductBrandUiData(
                        id = 0,
                        name = "Brand name",
                        logoUrl = "Brand logo url"
                    )
                ),
                isAdmin = true,
                handleEvent = {}
            )
        }
    }
}

@ThemePreviews
@Composable
fun PreviewProductDetailsBottomSheetContentAdminEdit() {
    MobiTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            ProductDetailsBottomSheetContent(
                product = ProductUiData(
                    id = 0,
                    name = "Product name",
                    shortDescription = "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
                    longDescription = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam at tempus nulla, eget vestibulum tortor. Etiam quis nisl justo.",
                    model = "Product model",
                    code = "Product code",
                    sku = "ABCD-00000001",
                    imageUrls = listOf(),
                    price = ProductPriceUiData(
                        sellingPrice = 100.0,
                        costPrice = 50.0,
                        currency = "ARS"
                    ),
                    stock = ProductStockUiData(
                        quantity = 100,
                        low = 10,
                        min = 5
                    ),
                    rating = 4.5,
                    reviews = 100,
                    isFavorite = false,
                    brand = ProductBrandUiData(
                        id = 0,
                        name = "Brand name",
                        logoUrl = "Brand logo url"
                    )
                ),
                isAdmin = true,
                handleEvent = {}
            )
        }
    }
}

@ThemePreviews
@Composable
fun PreviewProductDetailsBottomSheetContentNoAdmin() {
    MobiTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            ProductDetailsBottomSheetContent(
                product = ProductUiData(
                    id = 0,
                    name = "Product name",
                    shortDescription = "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
                    longDescription = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam at tempus nulla, eget vestibulum tortor. Etiam quis nisl justo.",
                    model = "Product model",
                    code = "Product code",
                    sku = "ABCD-00000001",
                    imageUrls = listOf(),
                    price = ProductPriceUiData(
                        sellingPrice = 100.0,
                        costPrice = 50.0,
                        currency = "ARS"
                    ),
                    stock = ProductStockUiData(
                        quantity = 100,
                        low = 10,
                        min = 5
                    ),
                    rating = 4.5,
                    reviews = 100,
                    isFavorite = false,
                    brand = ProductBrandUiData(
                        id = 0,
                        name = "Brand name",
                        logoUrl = "Brand logo url"
                    )
                ),
                isAdmin = false,
                handleEvent = {}
            )
        }
    }
}
