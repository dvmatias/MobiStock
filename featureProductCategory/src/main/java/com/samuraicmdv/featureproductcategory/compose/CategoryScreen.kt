package com.samuraicmdv.featureproductcategory.compose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.samuraicmdv.featureproductcategory.state.CategoryScreenState
import com.samuraicmdv.featureproductcategory.state.ProductBrandUiData
import com.samuraicmdv.featureproductcategory.state.CategoryUiData
import com.samuraicmdv.featureproductcategory.state.ProductUiData
import com.samuraicmdv.featureproductcategory.theme.AppTheme
import com.samuraicmdv.ui.util.ThemePreviews

@Composable
fun CategoryScreen(
    uiState: CategoryScreenState,
    modifier: Modifier = Modifier
) {
    val category = uiState.productCategory
    val brands = uiState.brands
    val products = uiState.products

    if (!uiState.isLoading) {
        Scaffold(
            modifier = modifier
                .fillMaxSize()
                .padding(horizontal = AppTheme.dimens.dimen_2)
        ) { paddingValues ->
            CategoryScreenContent(
                category = category,
                brands = brands,
                products = products,
                modifier = Modifier.padding(paddingValues)
            )
        }
    } else {
        /// Show loading if ui state is loading
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
    AppTheme {
        Surface {
            CategoryScreen(
                uiState = CategoryScreenState(
                    productCategory = CategoryUiData(
                        id = "1",
                        name = "Category Name",
                        description = "Lorem ipsum dolor sato sit amet. Lorem ipsum dolor sato sit amet. ",
                        imageUrl = "https://www.example.com/image.jpg",
                        productsCount = 32,
                        productsQuantity = 547
                    ),
                    products = List(5) { index ->
                        ProductUiData(
                            id = index.toString(),
                            name = "Product $index",
                            description = "Product Description",
                            imageUrl = "https://www.example.com/image.jpg",
                            sellingPrice = 100.0,
                            costPrice = 100.0,
                            currency = "USD",
                            rating = 4.5,
                            reviews = 100,
                            isFavorite = true,
                            stock = 100,
                            brand = ProductBrandUiData(
                                id = "1",
                                name = "Brand",
                                logoUrl = "https://www.example.com/image.jpg"
                            )
                        )
                    },
                    brands = List(5) { index ->
                        ProductBrandUiData(
                            id = index.toString(),
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