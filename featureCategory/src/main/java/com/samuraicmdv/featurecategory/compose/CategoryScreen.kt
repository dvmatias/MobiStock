package com.samuraicmdv.featurecategory.compose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.samuraicmdv.common.EMPTY_STRING
import com.samuraicmdv.common.R
import com.samuraicmdv.common.extension.bottomShadow
import com.samuraicmdv.common.theme.MobiTheme
import com.samuraicmdv.featurecategory.event.CategoryEvent
import com.samuraicmdv.featurecategory.event.CategoryNavigationEvent
import com.samuraicmdv.featurecategory.state.CategoryScreenState
import com.samuraicmdv.featurecategory.state.CategoryUiData
import com.samuraicmdv.featurecategory.state.ProductBrandUiData
import com.samuraicmdv.featurecategory.state.ProductPriceUiData
import com.samuraicmdv.featurecategory.state.ProductStockUiData
import com.samuraicmdv.featurecategory.state.ProductUiData
import com.samuraicmdv.ui.util.ThemePreviews

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryScreen(
    uiState: CategoryScreenState,
    handleEvent: (CategoryEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    val category = uiState.category
    val brands = uiState.brands
    val products = uiState.products
    val showProductDetailsBottomSheet = uiState.showProductDetailsBottomSheet
    val topAppBarTitleAlpha = uiState.topAppBarTitleAlpha
    val categoryTitleAlpha = uiState.categoryTitleAlpha
    val isStickyHeaderPinned = uiState.isStickyHeaderPinned

    if (!uiState.isLoading) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            text = uiState.category?.nameResId?.let { stringResId ->
                                stringResource(id = stringResId)
                            } ?: EMPTY_STRING,
                            modifier = Modifier.alpha(topAppBarTitleAlpha))
                    },
                    navigationIcon = {
                        IconButton(
                            onClick = { /* TODO Handle navigation icon click */ }
                        ) {
                            Icon(
                                Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = null,
                                tint = MobiTheme.colors.primary
                            )
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(actionIconContentColor = MobiTheme.colors.primary),
                    actions = {
                        IconButton(
                            onClick = {
                                handleEvent(CategoryNavigationEvent.NavigateProductDetails(false, -1))
                            }
                        ) {
                            Icon(imageVector = Icons.Default.Add, contentDescription = null)
                        }
                    },
                    modifier = Modifier.bottomShadow(if (isStickyHeaderPinned) 0.dp else MobiTheme.elevations.topBar)
                )
            },
            modifier = modifier.fillMaxSize()
        ) { paddingValues ->
            CategoryScreenContent(
                category = category,
                brands = brands,
                products = products,
                categoryTitleAlpha,
                handleEvent = handleEvent,
                modifier = Modifier
                    .padding(paddingValues)
            )
            // Product Bottom Sheet
            ProductDetailsBottomSheet(
                product = uiState.selectedProduct,
                showBottomSheet = showProductDetailsBottomSheet,
                handleEvent = handleEvent
            )
        }
    } else {
        // Show loading if ui state is loading
        Box(
            contentAlignment = Alignment.Center,
            modifier = modifier.fillMaxSize()
        ) {
            CircularProgressIndicator()
        }
    }

}

@ThemePreviews
@Composable
fun PreviewCategoryScreen(modifier: Modifier = Modifier) {
    MobiTheme {
        Surface {
            CategoryScreen(
                uiState = CategoryScreenState(
                    category = CategoryUiData(
                        id = 1,
                        nameResId = R.string.product_category_battery_name,
                        description = "Lorem ipsum dolor sato sit amet. Lorem ipsum dolor sato sit amet. ",
                        imageUrl = "https://www.example.com/image.jpg",
                        productsCount = 32,
                        productsQuantity = 547,
                        logoUrl = "https://www.example.com/image.jpg"
                    ),
                    products = List(10) { index ->
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
                            sku = "ABCD-00000001"
                        )
                    },
                    brands = List(5) { index ->
                        ProductBrandUiData(
                            id = index,
                            name = "Brand $index",
                            logoUrl = "https://www.example.com/image.jpg"
                        )
                    },
                ),
                handleEvent = {},
                modifier = modifier
            )
        }
    }
}