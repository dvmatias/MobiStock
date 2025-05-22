package com.samuraicmdv.featuredashboard.compose

import android.graphics.drawable.Drawable
import androidx.appcompat.content.res.AppCompatResources
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.samuraicmdv.ui.R as UiR

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
        ProductCategoryItemContent(
            id = category.id,
            iconDrawable = category.iconDrawable,
            name = category.name,
            isCategory = true,
            showExpandButton = hasSubcategories,
            isExpanded = isExpanded,
            onExpandButtonClick = {
                isExpanded = !isExpanded
            },
            handleEvent = handleEvent,
        )

        if (isExpanded) {
            category.subcategories?.forEach { subcategory ->
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

@Composable
fun ProductCategoryItemContent(
    iconDrawable: Drawable?,
    id: Int,
    name: String?,
    isCategory: Boolean,
    showExpandButton: Boolean,
    isExpanded: Boolean,
    onExpandButtonClick: () -> Unit = {},
    handleEvent: (DashboardEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                handleEvent(DashboardNavigationEvent.NavigateProductCategory(id))
            }
            .padding(if (isCategory) MobiTheme.dimens.dimen_1 else MobiTheme.dimens.dimen_0_5)
            .then(modifier)
    ) {
        iconDrawable?.let {
            Image(
                painter = rememberDrawablePainter(it),
                contentDescription = null,
                modifier = Modifier
                    .size(42.dp)
            )
        }
        name?.let {
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
        if (showExpandButton) {
            IconButton(
                onClick = {
                    onExpandButtonClick()
                },
                modifier = Modifier.size(36.dp)
            ) {
                Icon(
                    painter = rememberDrawablePainter(
                        AppCompatResources.getDrawable(
                            context,
                            if (isExpanded) UiR.drawable.ic_arrow_up_24px else UiR.drawable.ic_arrow_down_24px
                        )
                    ),
                    tint = MobiTheme.colors.primary,
                    contentDescription = "Dropdown Icon",
                    modifier = Modifier
                        .size(32.dp)
                        .padding(6.dp),
                )
            }
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