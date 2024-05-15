package com.samuraicmdv.featurehome.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.samuraicmdv.common.theme.MobiStockTheme
import com.samuraicmdv.featurehome.R
import com.samuraicmdv.featurehome.event.HomeEvent
import com.samuraicmdv.featurehome.state.HomeScreenState
import com.samuraicmdv.featurehome.state.ProductCategoriesUiData
import com.samuraicmdv.featurehome.state.ProductCategoryUiData
import com.samuraicmdv.ui.util.ThemePreviews

private const val COLUMNS_COUNT = 3

@Composable
fun HomeScreenContent(
    uiState: HomeScreenState,
    handleEvent: (HomeEvent) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(COLUMNS_COUNT),
        contentPadding = PaddingValues(
            start = MobiStockTheme.spaces.grid_2,
            end = MobiStockTheme.spaces.grid_2,
            top = MobiStockTheme.spaces.grid_2,
            bottom = MobiStockTheme.spaces.grid_2,
        ),
        verticalArrangement = Arrangement.spacedBy(MobiStockTheme.spaces.grid_1),
        horizontalArrangement = Arrangement.spacedBy(MobiStockTheme.spaces.grid_1),
        modifier = modifier
            .fillMaxSize()
    ) {
        uiState.productCategories?.categories.let { categories ->
            categories?.forEach { category ->
                item {
                    ProductCategoryItem(category, handleEvent)
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
            repeat(20) {
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
                ),
                handleEvent = {}
            )
        }
    }
}