package com.samuraicmdv.featurehome.compose

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.samuraicmdv.common.theme.MobiStockTheme
import com.samuraicmdv.featurehome.R
import com.samuraicmdv.featurehome.state.HomeScreenState
import com.samuraicmdv.featurehome.state.ProductCategoriesUiData
import com.samuraicmdv.featurehome.state.ProductCategoryUiData
import com.samuraicmdv.ui.util.ThemePreviews

private const val COLUMNS_COUNT = 3

@Composable
fun HomeScreenContent(
    uiState: HomeScreenState,
    modifier: Modifier = Modifier,
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(COLUMNS_COUNT),
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = MobiStockTheme.spaces.grid_2)
    ) {
        uiState.productCategories?.categories.let { categories ->
            categories?.forEach { category ->
                item {
                    ProductCategoryItem(category)
                }
            }
        }
    }
}

@ThemePreviews
@Composable
fun PreviewHomeScreenContent() {
    MobiStockTheme {
        val categories = mutableListOf<ProductCategoryUiData>().apply {
            repeat(2) {
                add(
                    ProductCategoryUiData(
                        id = it,
                        nameResId = R.string.product_category_battery_name,
                        imageUrl = "",
                        productsCount = 1245
                    )
                )
            }
            repeat(2) {
                add(
                    ProductCategoryUiData(
                        id = it,
                        nameResId = R.string.product_category_battery_name,
                        imageUrl = "",
                        productsCount = 10
                    )
                )
            }
            repeat(2) {
                add(
                    ProductCategoryUiData(
                        id = it,
                        nameResId = R.string.product_category_headphone_bt_name,
                        imageUrl = "",
                        productsCount = 3
                    )
                )
            }
            repeat(2) {
                add(
                    ProductCategoryUiData(
                        id = it,
                        nameResId = R.string.product_category_headphone_bt_name,
                        imageUrl = "",
                        productsCount = 33
                    )
                )
            }
        }
        Surface(color = MobiStockTheme.colors.backgroundPrimary) {
            HomeScreenContent(
                uiState = HomeScreenState(
                    productCategories = ProductCategoriesUiData(
                        categories = categories
                    )
                )
            )
        }
    }
}