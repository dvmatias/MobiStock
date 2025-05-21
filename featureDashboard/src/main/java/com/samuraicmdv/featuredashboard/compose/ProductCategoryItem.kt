package com.samuraicmdv.featuredashboard.compose

import androidx.appcompat.content.res.AppCompatResources
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.google.accompanist.drawablepainter.rememberDrawablePainter
import com.samuraicmdv.common.R
import com.samuraicmdv.common.theme.MobiTheme
import com.samuraicmdv.featuredashboard.event.DashboardEvent
import com.samuraicmdv.featuredashboard.event.DashboardNavigationEvent
import com.samuraicmdv.featuredashboard.state.ProductCategoryUiData
import com.samuraicmdv.featuredashboard.state.ProductSubcategoryUiData
import com.samuraicmdv.ui.util.ThemePreviews

@Composable
fun ProductCategoryItem(
    category: ProductCategoryUiData,
    handleEvent: (DashboardEvent) -> Unit,
    modifier: Modifier = Modifier,
) {
    val hasSubcategories = category.subcategories?.isNotEmpty() ?: false
    var isExpanded by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .clip(
                RoundedCornerShape(MobiTheme.dimens.dimen_1)
            )
            .animateContentSize()
            .background(MobiTheme.colors.surfaceContainer)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    handleEvent(DashboardNavigationEvent.NavigateProductCategory(category.id))
                }
                .padding(MobiTheme.dimens.dimen_1)
        ) {
            category.iconDrawable?.let {
                Image(
                    painter = rememberDrawablePainter(it),
                    contentDescription = null,
                    modifier = Modifier
                        .size(42.dp)
                )
            }
            category.name?.let {
                Text(
                    text = it,
                    maxLines = 1,
                    style = MobiTheme.typography.bodyMedium,
                    color = MobiTheme.colors.textPrimary,
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = MobiTheme.dimens.dimen_1)
                        .align(Alignment.CenterVertically)
                )
            }

            if (!hasSubcategories) {
                category.productsQuantity?.let {
                    ProductCategoryItemProductsCount(it)
                }
            } else {
                IconButton(
                    onClick = {
                        isExpanded = !isExpanded
                    },
                    modifier = Modifier.size(36.dp)
                ) {
                    Icon(
                        imageVector = if (isExpanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                        contentDescription = "Dropdown Icon"
                    )
                }
            }
        }

        if (isExpanded) {
            category.subcategories?.forEach { subcategory ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            handleEvent(DashboardNavigationEvent.NavigateProductCategory(category.id))
                        }
                        .padding(
                            start = 50.dp,
                            top = MobiTheme.dimens.dimen_0_25,
                            bottom = MobiTheme.dimens.dimen_0_25,
                            end = MobiTheme.dimens.dimen_1
                        )
                ) {
                    subcategory.iconDrawable?.let { icon ->
                        Image(
                            painter = rememberDrawablePainter(icon),
                            contentDescription = null,
                            modifier = Modifier
                                .size(42.dp)
                        )
                    }
                    subcategory.name?.let { name ->
                        Text(
                            text = name,
                            maxLines = 1,
                            style = MobiTheme.typography.bodyMedium,
                            color = subcategory.productsQuantity?.let {
                                if (subcategory.productsQuantity > 0) MobiTheme.colors.textPrimary else MobiTheme.colors.textDisable
                            } ?: MobiTheme.colors.textDisable,
                            modifier = Modifier
                                .weight(1f)
                                .padding(horizontal = MobiTheme.dimens.dimen_1)
                                .align(Alignment.CenterVertically)
                        )
                    }
                    subcategory.productsQuantity?.let {
                        ProductCategoryItemProductsCount(it)
                    }
                }
            }
            Spacer(modifier = Modifier.height(MobiTheme.dimens.dimen_1))
        }
    }
}

@ThemePreviews
@Composable
fun PreviewProductCategoryItem(modifier: Modifier = Modifier) {
    MobiTheme {
        Surface(color = MobiTheme.colors.background) {
            val context = LocalContext.current
            Column(
                verticalArrangement = Arrangement.spacedBy(MobiTheme.dimens.dimen_2),
            ) {
                ProductCategoryItem(
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

                ProductCategoryItem(
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
                        )
                    ),
                    handleEvent = {}
                )

                ProductCategoryItem(
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