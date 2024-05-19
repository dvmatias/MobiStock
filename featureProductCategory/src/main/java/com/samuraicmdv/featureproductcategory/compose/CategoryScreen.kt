package com.samuraicmdv.featureproductcategory.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.samuraicmdv.common.R
import com.samuraicmdv.common.theme.MobiTheme
import com.samuraicmdv.featureproductcategory.state.CategoryScreenState
import com.samuraicmdv.featureproductcategory.state.CategoryUiData
import com.samuraicmdv.featureproductcategory.state.ProductBrandUiData
import com.samuraicmdv.featureproductcategory.state.ProductPriceUiData
import com.samuraicmdv.featureproductcategory.state.ProductUiData
import com.samuraicmdv.ui.util.ThemePreviews

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryScreen(
    uiState: CategoryScreenState,
    modifier: Modifier = Modifier
) {
    val category = uiState.category
    val brands = uiState.brands
    val products = uiState.products

    if (!uiState.isLoading) {
        Scaffold(
            topBar = {
               Column {
                   TopAppBar(
                       title = {
                           Text(text = uiState.category?.nameResId?.let { stringResId ->
                               stringResource(id = stringResId)
                           } ?: "")
                       },
                       navigationIcon = {
                           IconButton(onClick = { /* TODO Handle navigation icon click */ }) {
                               Icon(
                                   Icons.AutoMirrored.Filled.ArrowBack,
                                   contentDescription = null,
                                   tint = MobiTheme.colors.primary
                               )
                           }
                       }
                   )
                   Spacer(modifier = Modifier.alpha(0.1f).height(0.75.dp).fillMaxWidth().background(MobiTheme.colors.textPrimary))
               }
            },
            modifier = modifier.fillMaxSize()
        ) { paddingValues ->
            CategoryScreenContent(
                category = category,
                brands = brands,
                products = products,
                modifier = Modifier
                    .padding(paddingValues)
                    .padding(horizontal = MobiTheme.dimens.dimen_2)
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
                    products = List(5) { index ->
                        ProductUiData(
                            id = index,
                            name = "Product $index",
                            description = "Product Description",
                            imageUrl = "https://www.example.com/image.jpg",
                            price = ProductPriceUiData(
                                sellingPrice = 100.0,
                                costPrice = 100.0,
                                currency = "USD",
                            ),
                            rating = 4.5,
                            reviews = 100,
                            isFavorite = true,
                            stock = 100,
                            brand = ProductBrandUiData(
                                id = index + 2,
                                name = "Brand",
                                logoUrl = "https://www.example.com/image.jpg"
                            ),
                            model = "Model",
                            code = "Code"
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
                modifier = modifier
            )
        }
    }
}