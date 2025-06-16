package com.samuraicmdv.featuredashboard.compose

import androidx.appcompat.content.res.AppCompatResources
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import com.samuraicmdv.common.R
import com.samuraicmdv.common.theme.MobiTheme
import com.samuraicmdv.featuredashboard.event.DashboardEvent
import com.samuraicmdv.featuredashboard.event.DashboardPresentationEvent
import com.samuraicmdv.featuredashboard.state.ProductCategoryUiData
import com.samuraicmdv.featuredashboard.state.ProductSubcategoryUiData
import com.samuraicmdv.ui.util.ThemePreviews

/**
 * Composable function that displays a container for a item category item. This function renders a item category
 * with its subcategories, if any, in a collapsible format. 
 * 
 * @param uiData The item category data to be displayed.
 * @param handleEvent A lambda function to handle events, such as toggling the expanded state of the category.
 * @param modifier A [Modifier] to be applied to the container.
 */
@Composable
fun ProductCategoryItemContainerContent(
    uiData: ProductCategoryUiData,
    handleEvent: (DashboardEvent) -> Unit,
    modifier: Modifier = Modifier,
) {
    val hasSubcategories = uiData.subcategories?.isNotEmpty() ?: false

    Column(
        modifier = modifier
            .clip(
                RoundedCornerShape(MobiTheme.dimens.dimen_1)
            )
            .animateContentSize()
            .background(MobiTheme.colors.surfaceContainer)
    ) {
        ProductCategoryItemContent(
            id = uiData.id,
            iconDrawable = uiData.iconDrawable,
            name = uiData.name,
            isCategory = true,
            showExpandButton = hasSubcategories,
            isExpanded = uiData.isExpanded,
            onExpandButtonClick = {
                handleEvent(DashboardPresentationEvent.ToggleProductCategoryExpandedStatus(uiData.id, !uiData.isExpanded))
            },
            handleEvent = handleEvent,
        )

        if (uiData.isExpanded) {
            uiData.subcategories?.forEach { subcategory ->
                ProductCategoryItemContent(
                    id = subcategory.id,
                    iconDrawable = subcategory.iconDrawable,
                    name = subcategory.name,
                    isCategory = false,
                    showExpandButton = false,
                    isExpanded = false,
                    onExpandButtonClick = { },
                    handleEvent = handleEvent,
                    modifier = Modifier.padding(start = MobiTheme.dimens.dimen_4)
                )
            }
        }
    }
}

@ThemePreviews
@Composable
fun PreviewProductCategoryItemContainerContent(modifier: Modifier = Modifier) {
    MobiTheme {
        Surface(color = MobiTheme.colors.background) {
            val context = LocalContext.current
            Column(
                verticalArrangement = Arrangement.spacedBy(MobiTheme.dimens.dimen_2),
            ) {
                ProductCategoryItemContainerContent(
                    ProductCategoryUiData(
                        id = 1,
                        name = "Batteries",
                        iconDrawable = AppCompatResources.getDrawable(
                            context,
                            R.drawable.product_category_battery_icon
                        ),
                        productsQuantity = 12,
                        subcategories = null
                    ),
                    handleEvent = {}
                )

                ProductCategoryItemContainerContent(
                    ProductCategoryUiData(
                        id = 4,
                        name = "Cables",
                        iconDrawable = AppCompatResources.getDrawable(
                            context,
                            R.drawable.product_category_cable_icon
                        ),
                        productsQuantity = 125,
                        subcategories = listOf(
                            ProductSubcategoryUiData(
                                id = 43,
                                name = "charge cable",
                                iconDrawable = AppCompatResources.getDrawable(
                                    context,
                                    R.drawable.product_subcategory_charge_cable_icon
                                ),
                                productsQuantity = 0,
                            ),
                            ProductSubcategoryUiData(
                                id = 7,
                                name = "Data Cable",
                                iconDrawable = AppCompatResources.getDrawable(
                                    context,
                                    R.drawable.product_subcategory_data_cable_icon
                                ),
                                productsQuantity = 42,
                            ),
                            ProductSubcategoryUiData(
                                id = 234,
                                name = "Auxiliary Cable",
                                iconDrawable = AppCompatResources.getDrawable(
                                    context,
                                    R.drawable.product_subcategory_auxiliary_cable_icon
                                ),
                                productsQuantity = 2,
                            ),
                            ProductSubcategoryUiData(
                                id = 11,
                                name = "Adapter Cable",
                                iconDrawable = AppCompatResources.getDrawable(
                                    context,
                                    R.drawable.product_subcategory_adapter_cable_icon
                                ),
                                productsQuantity = 13,
                            )
                        ),
                    ),
                    handleEvent = {}
                )

                ProductCategoryItemContainerContent(
                    ProductCategoryUiData(
                        id = 17,
                        name = "Gaming",
                        iconDrawable = AppCompatResources.getDrawable(
                            context,
                            R.drawable.product_category_gaming_icon
                        ),
                        productsQuantity = 0,
                        subcategories = null
                    ),
                    handleEvent = {}
                )
            }
        }
    }
}