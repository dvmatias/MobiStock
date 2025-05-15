package com.samuraicmdv.featuredashboard.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.samuraicmdv.common.theme.MobiTheme
import com.samuraicmdv.common.R
import com.samuraicmdv.featuredashboard.event.DashboardEvent
import com.samuraicmdv.featuredashboard.state.DailySaleState
import com.samuraicmdv.featuredashboard.state.DashboardScreenState
import com.samuraicmdv.featuredashboard.state.ProductCategoriesState
import com.samuraicmdv.featuredashboard.state.ProductCategoryUiData
import com.samuraicmdv.ui.util.ThemePreviews

private const val COLUMNS_COUNT = 3

@Composable
fun HomeScreenContent(
    uiState: ProductCategoriesState?,
    handleEvent: (DashboardEvent) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(COLUMNS_COUNT),
        contentPadding = PaddingValues(
            start = MobiTheme.dimens.dimen_2,
            end = MobiTheme.dimens.dimen_2,
            top = MobiTheme.dimens.dimen_2,
            bottom = MobiTheme.dimens.dimen_2,
        ),
        verticalArrangement = Arrangement.spacedBy(MobiTheme.dimens.dimen_2),
        horizontalArrangement = Arrangement.spacedBy(MobiTheme.dimens.dimen_2),
        modifier = modifier
            .fillMaxSize()
    ) {
        uiState?.categories.let { categories ->
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
    MobiTheme {
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
        Surface {
            HomeScreenContent(
                uiState =  ProductCategoriesState(
                    categories = categories
                ),
                handleEvent = {}
            )
        }
    }
}