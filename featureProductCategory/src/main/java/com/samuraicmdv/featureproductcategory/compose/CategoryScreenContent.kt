package com.samuraicmdv.featureproductcategory.compose

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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.samuraicmdv.common.theme.MobiTheme
import com.samuraicmdv.featureproductcategory.R
import com.samuraicmdv.featureproductcategory.event.CategoryEvent
import com.samuraicmdv.featureproductcategory.event.CategoryPresentationEvent
import com.samuraicmdv.featureproductcategory.event.ProductsSort
import com.samuraicmdv.featureproductcategory.event.ProductsSortName
import com.samuraicmdv.featureproductcategory.event.ProductsSortType
import com.samuraicmdv.featureproductcategory.state.CategoryUiData
import com.samuraicmdv.featureproductcategory.state.ProductBrandUiData
import com.samuraicmdv.featureproductcategory.state.ProductPriceUiData
import com.samuraicmdv.featureproductcategory.state.ProductStockUiData
import com.samuraicmdv.featureproductcategory.state.ProductUiData
import com.samuraicmdv.ui.util.ThemePreviews

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CategoryScreenContent(
    category: CategoryUiData?,
    brands: List<ProductBrandUiData>?,
    products: List<ProductUiData>?,
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
        var selectedBrandId by rememberSaveable { mutableStateOf(-1) } // -1 means all brands are selected
        val filteredProducts = products?.filter { product ->
            selectedBrandId == -1 || product.brand?.id == selectedBrandId
        }?.sortedBy { product ->
            when (selectedOrder.name) {
                ProductsSortName.BY_NAME_ALPHABETICALLY -> product.name?.lowercase()
                ProductsSortName.BY_COST_PRICE_AMOUNT -> product.price?.costPrice.toString()
                ProductsSortName.BY_SELLING_PRICE_AMOUNT -> product.price?.sellingPrice.toString()
            }
        }.let { products ->
            if (selectedOrder.type == ProductsSortType.DESCENDING) {
                products?.reversed()
            } else {
                products
            }
        }

        LazyColumn(modifier = modifier.fillMaxWidth()) {
            item {
                CategoryScreenContentHeader(
                    name = stringResource(id = nameResId),
                    description = description,
                    imageUrl = imageUrl,
                    productsCount = productsCount,
                    productsQuantity = productsQuantity
                )
            }
            brands?.let {
                item {
                    Spacer(modifier = Modifier.height(MobiTheme.dimens.dimen_2))
                    CategoryScreenContentBrands(
                        brands = brands
                    )
                }
            }
            filteredProducts?.let { products ->
                stickyHeader {
                    Column(
                        modifier = Modifier
                            .background(MobiTheme.colors.surface)
                            .fillMaxWidth()
                    ) {
                        // TODO Extract this out
                        Spacer(modifier = Modifier.height(MobiTheme.dimens.dimen_3))
                        Text(
                            text = stringResource(id = R.string.title_products),
                            style = MobiTheme.typography.titleMediumBold,
                        )
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

                items(products, { it.id }) { product ->
                    ProductItem(
                        product = product,
                        handleEvent = handleEvent
                    )
                    Spacer(modifier = Modifier.height(MobiTheme.dimens.dimen_1))
                }
            }
        }
    }
}

@ThemePreviews
@Composable
fun PreviewCategoryContent(modifier: Modifier = Modifier) {
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
                        imageUrl = "https://www.example.com/image.jpg",
                        price = ProductPriceUiData(
                            sellingPrice = 100.0,
                            costPrice = 100.0,
                            currency = "USD",
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
                handleEvent = {},
                modifier = Modifier.padding(horizontal = MobiTheme.dimens.dimen_2)
            )
        }
    }
}