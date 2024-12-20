package com.samuraicmdv.featurecategory.compose

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.samuraicmdv.common.theme.MobiTheme
import com.samuraicmdv.featurecategory.R
import com.samuraicmdv.featurecategory.event.CategoryPresentationEvent
import com.samuraicmdv.featurecategory.event.ProductsSort
import com.samuraicmdv.featurecategory.event.ProductsSortName
import com.samuraicmdv.featurecategory.event.ProductsSortType.ASCENDING
import com.samuraicmdv.featurecategory.event.ProductsSortType.DESCENDING
import com.samuraicmdv.ui.util.ThemePreviews

@Composable
fun SortProductsMenu(
    handelEvent: (CategoryPresentationEvent.SortProducts) -> Unit,
    productsSort: ProductsSort,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier) {
        val srtType = productsSort.type
        val sortName = productsSort.name
        val selectedModifier = Modifier
            .clip(RoundedCornerShape(100))
            .background(MobiTheme.colors.primary)
            .animateContentSize()
        val unselectedModifier = Modifier
            .border(MobiTheme.dimens.unit, MobiTheme.colors.outline, RoundedCornerShape(50))
            .clip(RoundedCornerShape(50))
            .height(24.dp)
            .padding(end = MobiTheme.dimens.dimen_1)
            .animateContentSize()
        val keyboardArrowDown = Icons.Default.KeyboardArrowDown
        val keyboardArrowUp = Icons.Default.KeyboardArrowUp
        val selectedColor = MobiTheme.colors.onPrimary
        val unselectedColor = MobiTheme.colors.outline

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .then(
                    if (sortName == ProductsSortName.BY_NAME_ALPHABETICALLY) selectedModifier else unselectedModifier
                )
                .clickable {
                    val orderType = if (productsSort.name == ProductsSortName.BY_NAME_ALPHABETICALLY) {
                        if (srtType == ASCENDING) DESCENDING else ASCENDING
                    } else {
                        ASCENDING
                    }
                    handelEvent(
                        CategoryPresentationEvent.SortProducts(
                            ProductsSort(
                                name = ProductsSortName.BY_NAME_ALPHABETICALLY,
                                type = orderType
                            )
                        )
                    )
                }
                .padding(start = MobiTheme.dimens.dimen_2, end = MobiTheme.dimens.dimen_1)
        ) {
            Text(
                text = stringResource(id = R.string.label_alphabetical_sort_pill),
                color = if (sortName == ProductsSortName.BY_NAME_ALPHABETICALLY) selectedColor else unselectedColor,
                style = MobiTheme.typography.labelMediumBold,
                modifier = Modifier
            )
            if (sortName == ProductsSortName.BY_NAME_ALPHABETICALLY)
                Icon(
                    imageVector = if (srtType == DESCENDING) keyboardArrowUp else keyboardArrowDown,
                    contentDescription = null,
                    tint = selectedColor
                )
        }
        Spacer(modifier = Modifier.width(MobiTheme.dimens.dimen_1))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .then(
                    if (sortName == ProductsSortName.BY_SELLING_PRICE_AMOUNT) selectedModifier else unselectedModifier
                )
                .clickable {
                    val orderType = if (productsSort.name == ProductsSortName.BY_SELLING_PRICE_AMOUNT) {
                        if (srtType == ASCENDING) DESCENDING else ASCENDING
                    } else {
                        ASCENDING
                    }
                    handelEvent(
                        CategoryPresentationEvent.SortProducts(
                            ProductsSort(
                                name = ProductsSortName.BY_SELLING_PRICE_AMOUNT,
                                type = orderType
                            )
                        )
                    )
                }
                .padding(start = MobiTheme.dimens.dimen_2, end = MobiTheme.dimens.dimen_1)
        ) {
            Text(
                text = stringResource(id = R.string.label_price_sort_pill),
                color = if (sortName == ProductsSortName.BY_SELLING_PRICE_AMOUNT) selectedColor else unselectedColor,
                style = MobiTheme.typography.labelMediumBold,
            )
            if (sortName == ProductsSortName.BY_SELLING_PRICE_AMOUNT)
                Icon(
                    imageVector = if (srtType == DESCENDING) keyboardArrowUp else keyboardArrowDown,
                    contentDescription = null,
                    tint = selectedColor,
                )
        }
    }
}

@ThemePreviews
@Composable
fun PreviewSortProductsMenu() {
    MobiTheme {
        Surface {
            Column {
                SortProductsMenu(
                    handelEvent = {},
                    productsSort = ProductsSort(
                        name = ProductsSortName.BY_NAME_ALPHABETICALLY,
                        type = ASCENDING
                    )
                )
                Spacer(modifier = Modifier.height(MobiTheme.dimens.dimen_2))
                SortProductsMenu(
                    handelEvent = {},
                    productsSort = ProductsSort(
                        name = ProductsSortName.BY_SELLING_PRICE_AMOUNT,
                        type = ASCENDING
                    )
                )
            }
        }
    }
}