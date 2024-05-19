package com.samuraicmdv.featureproductcategory.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import com.samuraicmdv.common.theme.MobiTheme
import com.samuraicmdv.featureproductcategory.R
import com.samuraicmdv.featureproductcategory.event.CategoryPresentationEvent
import com.samuraicmdv.featureproductcategory.state.ProductBrandUiData
import com.samuraicmdv.ui.util.ThemePreviews

@Composable
fun FilterProductsByBrandPill(
    brands: List<ProductBrandUiData>?,
    handelEvent: (CategoryPresentationEvent.FilterProductsByBrand) -> Unit,
    modifier: Modifier = Modifier
) {
    brands?.let {
        var expanded by rememberSaveable { mutableStateOf(false) }
        val options = mutableListOf<String>().apply {
            add(stringResource(id = R.string.label_filter_by_brand_pill))
            addAll(brands.map { it.name })
        }
        var selectedOption by rememberSaveable { mutableStateOf(options[0]) }

        Column {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = modifier
                    .clip(RoundedCornerShape(100))
                    .background(MobiTheme.colors.primary)
                    .padding(start = MobiTheme.dimens.dimen_2, end = MobiTheme.dimens.dimen_1)
                    .clickable { expanded = true }
            ) {
                Text(
                    text = selectedOption.uppercase(),
                    color = MobiTheme.colors.onPrimary,
                    style = MobiTheme.typography.labelMediumBlack,
                )
                Icon(
                    imageVector = Icons.Default.ArrowDropDown,
                    contentDescription = null,
                    tint = MobiTheme.colors.onPrimary,
                    modifier = Modifier.width(MobiTheme.dimens.dimen_3)
                )
            }

            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = Modifier.background(MobiTheme.colors.surface)
            ) {
                options.forEach { option ->
                    DropdownMenuItem(
                        onClick = {
                            selectedOption = option
                            expanded = false
                            handelEvent(
                                CategoryPresentationEvent.FilterProductsByBrand(
                                    brandId = it.find { brand ->
                                        brand.name == option
                                    }?.id ?: -1
                                )
                            )
                        },
                        text = {
                            Text(
                                text = option,
                                style = MobiTheme.typography.bodyLargeBold,
                            )
                        }
                    )
                }
            }
        }
    }
}

@ThemePreviews
@Composable
fun PreviewFilterProductsByBrandPill() {
    MobiTheme {
        Surface {
            FilterProductsByBrandPill(
                brands = listOf(
                    ProductBrandUiData(id = 1, name = "Brand 1", logoUrl = ""),
                    ProductBrandUiData(id = 2, name = "Brand 2", logoUrl = ""),
                    ProductBrandUiData(id = 3, name = "Brand 3", logoUrl = ""),
                ),
                handelEvent = {}
            )
        }
    }
}