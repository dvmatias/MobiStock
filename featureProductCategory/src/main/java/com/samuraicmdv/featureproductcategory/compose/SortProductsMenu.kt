package com.samuraicmdv.featureproductcategory.compose

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
import com.samuraicmdv.featureproductcategory.R
import com.samuraicmdv.featureproductcategory.event.CategoryPresentationEvent
import com.samuraicmdv.featureproductcategory.event.ProductsSortName
import com.samuraicmdv.featureproductcategory.event.ProductsSortType.ASCENDING
import com.samuraicmdv.featureproductcategory.event.ProductsSortType.DESCENDING
import com.samuraicmdv.featureproductcategory.event.ProductsSort
import com.samuraicmdv.featureproductcategory.theme.AppTheme
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
            .background(AppTheme.colors.primary)
        val unselectedModifier = Modifier
            .border(AppTheme.dimens.unit, AppTheme.colors.primary, RoundedCornerShape(50))
            .clip(RoundedCornerShape(50))
        val keyboardArrowDown = Icons.Default.KeyboardArrowDown
        val keyboardArrowUp = Icons.Default.KeyboardArrowUp
        val selectedColor = AppTheme.colors.onPrimary
        val unselectedColor = AppTheme.colors.primary

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .then(
                    if (sortName == ProductsSortName.BY_NAME_ALPHABETICALLY) selectedModifier else unselectedModifier
                )
                .clickable {
                    handelEvent(
                        CategoryPresentationEvent.SortProducts(
                            ProductsSort(
                                name = ProductsSortName.BY_NAME_ALPHABETICALLY,
                                type = if (srtType == ASCENDING) DESCENDING else ASCENDING
                            )
                        )
                    )
                }
                .padding(start = AppTheme.dimens.dimen_2, end = AppTheme.dimens.dimen_1)
        ) {
            Text(
                text = stringResource(id = R.string.label_alphabetical_sort_pill),
                color = if (sortName == ProductsSortName.BY_NAME_ALPHABETICALLY) selectedColor else unselectedColor,
                style = AppTheme.typography.labelMediumBlack,
                modifier = Modifier
            )
            Icon(
                imageVector = if (srtType == ASCENDING && sortName == ProductsSortName.BY_NAME_ALPHABETICALLY) keyboardArrowDown else keyboardArrowUp,
                contentDescription = null,
                tint = if (sortName == ProductsSortName.BY_NAME_ALPHABETICALLY) selectedColor else unselectedColor,
            )
        }
        Spacer(modifier = Modifier.width(AppTheme.dimens.dimen_1))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .then(
                    if (sortName == ProductsSortName.BY_SELLING_PRICE_AMOUNT) selectedModifier else unselectedModifier
                )
                .clickable {
                    handelEvent(
                        CategoryPresentationEvent.SortProducts(
                            ProductsSort(
                                name = ProductsSortName.BY_SELLING_PRICE_AMOUNT,
                                type = if (srtType == ASCENDING) DESCENDING else ASCENDING
                            )
                        )
                    )
                }
                .padding(start = AppTheme.dimens.dimen_2, end = AppTheme.dimens.dimen_1)
        ) {
            Text(
                text = stringResource(id = R.string.label_price_sort_pill),
                color = if (sortName == ProductsSortName.BY_SELLING_PRICE_AMOUNT) selectedColor else unselectedColor,
                style = AppTheme.typography.labelMediumBlack,
            )
            Icon(
                imageVector = if (srtType == ASCENDING && sortName == ProductsSortName.BY_SELLING_PRICE_AMOUNT) keyboardArrowDown else keyboardArrowUp,
                contentDescription = null,
                tint = if (sortName == ProductsSortName.BY_SELLING_PRICE_AMOUNT) selectedColor else unselectedColor,
            )
        }
    }
}

@ThemePreviews
@Composable
fun PreviewSortProductsMenu() {
    AppTheme {
        Surface {
            Column {
                SortProductsMenu(
                    handelEvent = {},
                    productsSort = ProductsSort(
                        name = ProductsSortName.BY_NAME_ALPHABETICALLY,
                        type = ASCENDING
                    )
                )
                Spacer(modifier = Modifier.height(AppTheme.dimens.dimen_2))
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