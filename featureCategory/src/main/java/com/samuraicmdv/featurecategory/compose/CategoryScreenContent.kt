package com.samuraicmdv.featurecategory.compose

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.core.VectorConverter
import androidx.compose.animation.core.animateValueAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInParent
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.samuraicmdv.common.extension.bottomShadow
import com.samuraicmdv.common.theme.MobiTheme
import com.samuraicmdv.featurecategory.R
import com.samuraicmdv.featurecategory.event.CategoryEvent
import com.samuraicmdv.featurecategory.event.CategoryPresentationEvent
import com.samuraicmdv.featurecategory.event.ProductsSort
import com.samuraicmdv.featurecategory.event.ProductsSortName
import com.samuraicmdv.featurecategory.event.ProductsSortType
import com.samuraicmdv.featurecategory.state.CategoryUiData
import com.samuraicmdv.featurecategory.state.ProductBrandUiData
import com.samuraicmdv.featurecategory.state.ProductPriceUiData
import com.samuraicmdv.featurecategory.state.ProductStockUiData
import com.samuraicmdv.featurecategory.state.ProductUiData
import com.samuraicmdv.ui.util.ThemePreviews

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CategoryScreenContent(
    category: CategoryUiData?,
    brands: List<ProductBrandUiData>?,
    products: List<ProductUiData>?,
    categoryTitleAlpha: Float,
    handleEvent: (CategoryEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    category?.run {
        var selectedOrder by remember {
            mutableStateOf(
                ProductsSort(
                    name = ProductsSortName.BY_NAME_ALPHABETICALLY,
                    type = ProductsSortType.ASCENDING
                )
            )
        }
        var selectedBrandId by rememberSaveable { mutableIntStateOf(-1) } // -1 means all brands are selected
        val filteredProducts = products?.filter { product ->
            selectedBrandId == -1 || product.brand?.id == selectedBrandId
        }?.run {
            when (selectedOrder.name) {
                ProductsSortName.BY_NAME_ALPHABETICALLY -> this.sortedBy { it.name?.lowercase() }
                ProductsSortName.BY_SELLING_PRICE_AMOUNT -> this.sortedBy { it.price?.sellingPrice?.toInt() }
            }.let { products ->
                if (selectedOrder.type == ProductsSortType.DESCENDING) {
                    products.reversed()
                } else {
                    products
                }
            }
        }
        var isHeaderPinned by remember { mutableStateOf(false) }
        val headerBackgroundColor by animateColorAsState(
            targetValue = if (isHeaderPinned) MobiTheme.colors.surface else MobiTheme.colors.background, label = "",
            animationSpec = TweenSpec(durationMillis = 1000)
        )
        val headerShadowElevation by animateValueAsState(
            targetValue = if (isHeaderPinned) MobiTheme.elevations.topBar else 0.dp,
            label = "",
            typeConverter = Dp.VectorConverter,
            animationSpec = tween(durationMillis = 300)
        )

        LazyColumn(
            modifier = modifier
                .fillMaxWidth()
        ) {
            // Header
            item {
                CategoryScreenContentHeader(
                    name = stringResource(id = nameResId),
                    description = description,
                    imageUrl = imageUrl,
                    productsCount = productsCount,
                    productsQuantity = productsQuantity,
                    categoryTitleAlpha = categoryTitleAlpha,
                    handleEvent = handleEvent,
                    modifier = Modifier
                        .background(color = headerBackgroundColor)
                        .padding(horizontal = MobiTheme.dimens.dimen_2)
                )
            }
            // Title products section
            item {
                Text(
                    text = stringResource(id = R.string.title_products),
                    style = MobiTheme.typography.titleSmallBold,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = headerBackgroundColor)
                        .padding(horizontal = MobiTheme.dimens.dimen_2)
                        .padding(top = MobiTheme.dimens.dimen_2)
                )
            }
            // Order and filter menu
            stickyHeader {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .bottomShadow(headerShadowElevation)
                        .background(color = headerBackgroundColor)
                        .padding(horizontal = MobiTheme.dimens.dimen_2)
                        .onGloballyPositioned { layoutCoordinates ->
                            val headerPosition = layoutCoordinates.positionInParent().y
                            isHeaderPinned = headerPosition <= 0f

                            handleEvent(
                                CategoryPresentationEvent.OnStickyHeaderPinned(
                                    isHeaderPinned
                                )
                            )
                        }
                ) {
                    Spacer(modifier = Modifier.height(MobiTheme.dimens.dimen_2))
                    Row {
                        SortProductsMenu(
                            { event ->
                                selectedOrder = event.productsSort
                            },
                            productsSort = selectedOrder,
                            Modifier.weight(1F)
                        )
                        FilterProductsByBrandPill(
                            brands = brands,
                            { event ->
                                (event as? CategoryPresentationEvent.FilterProductsByBrand)?.let {
                                    selectedBrandId = it.brandId
                                }
                            }
                        )
                    }
                    Spacer(modifier = Modifier.height(MobiTheme.dimens.dimen_2))
                }
            }
            item {
                Spacer(modifier = Modifier.height(MobiTheme.dimens.dimen_2))
            }
            // Products list
            filteredProducts?.let { products ->
                items(products, { it.id }) { product ->
                    ProductItem(
                        product = product,
                        handleEvent = handleEvent,
                        modifier = Modifier.padding(horizontal = MobiTheme.dimens.dimen_2)
                    )
                    Spacer(modifier = Modifier.height(MobiTheme.dimens.dimen_1))
                }
            }
        }
    }
}


@ThemePreviews
@Composable
fun PreviewCategoryContent() {
    MobiTheme {
        Surface {
            CategoryScreenContent(
                category = CategoryUiData(
                    id = 1,
                    nameResId = com.samuraicmdv.common.R.string.product_category_battery_name,
                    description = "Lorem ipsum dolor sato sit amet. Lorem ipsum dolor sato sit amet. ",
                    imageUrl = "https://www.example.com/image.jpg",
                    productsCount = 32,
                    productsQuantity = 547,
                    logoUrl = "https://www.example.com/image.jpg"
                ),
                products = List(5) { index ->
                    ProductUiData(
                        id = index,
                        name = "Product $index",
                        shortDescription = "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
                        longDescription = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam at tempus nulla, eget vestibulum tortor. Etiam quis nisl justo.",
                        imageUrls = listOf(),
                        price = ProductPriceUiData(
                            sellingPrice = 100.0,
                            costPrice = 100.0,
                            currency = "ARS",
                        ),
                        rating = 4.5,
                        reviews = 100,
                        isFavorite = true,
                        stock = ProductStockUiData(
                            quantity = 100,
                            low = 10,
                            min = 5
                        ),
                        brand = ProductBrandUiData(
                            id = index + 2,
                            name = "Brand",
                            logoUrl = "https://www.example.com/image.jpg"
                        ),
                        model = "Model",
                        code = "Code",
                        sku = "ABCD-00000001",
                    )
                },
                brands = List(5) { index ->
                    ProductBrandUiData(
                        id = index,
                        name = "Brand $index",
                        logoUrl = "https://www.example.com/image.jpg"
                    )
                },
                categoryTitleAlpha = 1F,
                handleEvent = {}
            )
        }
    }
}