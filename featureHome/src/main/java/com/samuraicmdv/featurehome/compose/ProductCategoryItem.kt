package com.samuraicmdv.featurehome.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.samuraicmdv.common.theme.MobiStockTheme
import com.samuraicmdv.featurehome.R
import com.samuraicmdv.featurehome.state.ProductCategoryUiData
import com.samuraicmdv.ui.util.ThemePreviews

@Composable
fun ProductCategoryItem(
    category: ProductCategoryUiData,
    modifier: Modifier = Modifier,
) {
    Surface(
        shadowElevation = MobiStockTheme.elevations.card,
        shape = RoundedCornerShape(MobiStockTheme.spaces.grid_1),
        modifier = modifier.padding(MobiStockTheme.spaces.grid_0_5)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MobiStockTheme.colors.backgroundPrimary)
        ) {
            Column {
                var textPadding by remember {
                    mutableStateOf(0.dp)
                }
                val density = LocalDensity.current.density
                Image(
                    painter = rememberImagePainter(data = category.imageUrl),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1F)
                        .background(Color.LightGray)
                )
                Spacer(modifier = Modifier.height(MobiStockTheme.spaces.grid_0_75))
                Text(
                    text = stringResource(category.nameResId),
                    textAlign = TextAlign.Center,
                    maxLines = 2,
                    style = MobiStockTheme.typography.bodyRegular,
                    onTextLayout = {
                        val isMultiLine = it.lineCount > 1
                        val height = (it.size.height / density).dp
                        textPadding = if (isMultiLine) {
                            0.dp
                        } else {
                            height / 2
                        }
                    },
                    modifier = Modifier
                        .padding(
                            start = MobiStockTheme.spaces.grid_2,
                            end = MobiStockTheme.spaces.grid_2,
                            top = textPadding,
                            bottom = textPadding
                        )
                        .fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(MobiStockTheme.spaces.grid_0_75))
            }
            category.productsCount?.let { it ->
                ProductCategoryItemProductsCount(it, modifier = Modifier.align(Alignment.TopEnd))
            }
        }
    }
}

@ThemePreviews
@Composable
fun PreviewProductCategoryItem(modifier: Modifier = Modifier) {
    MobiStockTheme {
        Surface {
            ProductCategoryItem(
                ProductCategoryUiData(
                    id = 0,
                    nameResId = R.string.product_category_other_name,
                    imageUrl = "",
                    productsCount = 1245
                ),
                modifier = modifier
            )
        }
    }
}