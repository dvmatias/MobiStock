package com.samuraicmdv.featureproductcategory.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.samuraicmdv.common.theme.MobiTheme
import com.samuraicmdv.featureproductcategory.R
import com.samuraicmdv.featureproductcategory.state.ProductBrandUiData
import com.samuraicmdv.ui.util.ThemePreviews

@Composable
fun CategoryScreenContentBrands(
    brands: List<ProductBrandUiData>,
    modifier: Modifier = Modifier
) {
    Surface(
        color = MobiTheme.colors.surfaceContainer,
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(MobiTheme.dimens.dimen_2))
    ) {
        Column {
            Text(
                text = stringResource(id = R.string.title_brands),
                style = MobiTheme.typography.titleMediumBold,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = MobiTheme.dimens.dimen_1_5)
            )
            LazyRow(
                horizontalArrangement = Arrangement.SpaceEvenly,
                contentPadding = PaddingValues(
                    horizontal = MobiTheme.dimens.dimen_2,
                    vertical = MobiTheme.dimens.dimen_2
                ),
                modifier = Modifier.fillMaxWidth()
            ) {
                brands.forEach { brand ->
                    item {
                        ProductBrandItem(brand = brand)
                    }
                }
            }
        }
    }

}

@ThemePreviews
@Composable
fun PreviewProductCategoryBrands(modifier: Modifier = Modifier) {
    MobiTheme {
        Surface {
            CategoryScreenContentBrands(
                brands = List(13) { index ->
                    ProductBrandUiData(
                        id = index,
                        name = "Brand $index",
                        logoUrl = "https://www.example.com/image.jpg"
                    )
                },
                modifier = modifier
            )
        }
    }
}