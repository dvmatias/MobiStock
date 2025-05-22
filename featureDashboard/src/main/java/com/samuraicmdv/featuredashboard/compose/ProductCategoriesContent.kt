package com.samuraicmdv.featuredashboard.compose

import androidx.appcompat.content.res.AppCompatResources
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.samuraicmdv.common.theme.MobiTheme
import com.samuraicmdv.featuredashboard.event.DashboardEvent
import com.samuraicmdv.featuredashboard.state.ProductCategoriesState
import com.samuraicmdv.featuredashboard.state.ProductCategoryUiData
import com.samuraicmdv.featuredashboard.state.ProductSubcategoryUiData
import com.samuraicmdv.ui.util.ThemePreviews
import com.samuraicmdv.ui.widget.CustomSearchView
import com.samuraicmdv.common.R as CommonR

@Composable
fun ProductCategoriesContent(
    uiState: ProductCategoriesState?,
    handleEvent: (DashboardEvent) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
        Spacer(modifier = Modifier.height(MobiTheme.dimens.dimen_2))
        CustomSearchView(
            onSearch = { query ->
                println("Search query: $query")
            },
            modifier = Modifier.padding(horizontal = MobiTheme.dimens.dimen_2)
        )

        LazyColumn(
            contentPadding = PaddingValues(
                start = MobiTheme.dimens.dimen_2,
                end = MobiTheme.dimens.dimen_2,
                top = MobiTheme.dimens.dimen_2,
                bottom = MobiTheme.dimens.dimen_2,
            ),
            verticalArrangement = Arrangement.spacedBy(MobiTheme.dimens.dimen_1)
        ) {
            // Product categories and subcategories
            uiState?.categories.let { categories ->
                categories?.forEach { category ->
                    item {
                        ProductCategoryItem(category, handleEvent)
                    }
                }
            }
        }
    }
}


@ThemePreviews
@Composable
fun PreviewProductCategoriesContent() {
    MobiTheme {
        val context = LocalContext.current
        val categories = mutableListOf<ProductCategoryUiData>().apply {
            add(
                ProductCategoryUiData(
                    id = 1,
                    name = context.getString(CommonR.string.product_category_battery_name),
                    iconDrawable = AppCompatResources.getDrawable(
                        context,
                        CommonR.drawable.product_category_battery_icon
                    ),
                    productsQuantity = 12,
                    subcategories = null
                )
            )

            add(
                ProductCategoryUiData(
                    id = 14,
                    name = context.getString(CommonR.string.product_category_cable_name),
                    iconDrawable = AppCompatResources.getDrawable(
                        context,
                        CommonR.drawable.product_category_cable_icon
                    ),
                    productsQuantity = 125,
                    subcategories = listOf(
                        ProductSubcategoryUiData(
                            id = 1,
                            name = context.getString(CommonR.string.product_subcategory_charge_cable_name),
                            iconDrawable = AppCompatResources.getDrawable(
                                context,
                                CommonR.drawable.product_subcategory_charge_cable_icon
                            ),
                            productsQuantity = 65,
                        ),
                        ProductSubcategoryUiData(
                            id = 2,
                            name = context.getString(CommonR.string.product_subcategory_data_cable_name),
                            iconDrawable = AppCompatResources.getDrawable(
                                context,
                                CommonR.drawable.product_subcategory_data_cable_icon
                            ),
                            productsQuantity = 0,
                        ),
                        ProductSubcategoryUiData(
                            id = 3,
                            name = context.getString(CommonR.string.product_subcategory_auxiliary_cable_name),
                            iconDrawable = AppCompatResources.getDrawable(
                                context,
                                CommonR.drawable.product_subcategory_auxiliary_cable_icon
                            ),
                            productsQuantity = 3,
                        ),
                        ProductSubcategoryUiData(
                            id = 4,
                            name = context.getString(CommonR.string.product_subcategory_adapter_cable_name),
                            iconDrawable = AppCompatResources.getDrawable(
                                context,
                                CommonR.drawable.product_subcategory_adapter_cable_icon
                            ),
                            productsQuantity = 43,
                        )
                    )
                )
            )

            add(
                ProductCategoryUiData(
                    id = 1,
                    name = context.getString(CommonR.string.product_category_charger_name),
                    iconDrawable = AppCompatResources.getDrawable(
                        context,
                        CommonR.drawable.product_category_charger_icon
                    ),
                    productsQuantity = 1,
                    subcategories = null
                )
            )

            repeat(20) {
                add(
                    ProductCategoryUiData(
                        id = 1,
                        name = context.getString(CommonR.string.product_category_other_name),
                        iconDrawable = AppCompatResources.getDrawable(
                            context,
                            CommonR.drawable.product_category_unknown_icon
                        ),
                        productsQuantity = 1,
                        subcategories = null
                    )
                )
            }
        }
        Surface(color = MobiTheme.colors.background) {
            ProductCategoriesContent(
                uiState = ProductCategoriesState(
                    categories = categories
                ),
                handleEvent = {}
            )
        }
    }
}