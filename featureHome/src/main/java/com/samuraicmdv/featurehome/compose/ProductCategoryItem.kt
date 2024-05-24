package com.samuraicmdv.featurehome.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import com.samuraicmdv.common.theme.MobiTheme
import com.samuraicmdv.featurehome.event.HomeEvent
import com.samuraicmdv.featurehome.event.HomeNavigationEvent
import com.samuraicmdv.featurehome.state.ProductCategoryUiData
import com.samuraicmdv.ui.util.ThemePreviews

@Composable
fun ProductCategoryItem(
    category: ProductCategoryUiData,
    handleEvent: (HomeEvent) -> Unit,
    modifier: Modifier = Modifier,
) {
    Surface(
        shadowElevation = MobiTheme.elevations.unit,
        shape = RoundedCornerShape(MobiTheme.dimens.dimen_2),
        modifier = modifier
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MobiTheme.colors.surfaceContainer)
                .clickable {
                    handleEvent(HomeNavigationEvent.NavigateProductCategory(category.id))
                }
        ) {
            Column {
                var textPadding by remember {
                    mutableStateOf(0.dp)
                }
                val density = LocalDensity.current.density
                category.imageUrl?.let {
                    Image(
                        painter = rememberImagePainter(data = category.imageUrl),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxWidth()
                            .aspectRatio(1F)
                            .background(Color.LightGray)
                    )
                    Spacer(modifier = Modifier.height(MobiTheme.dimens.dimen_0_75))
                }
                category.nameResId?.let { stringResource ->
                    Text(
                        text = stringResource(stringResource),
                        textAlign = TextAlign.Center,
                        maxLines = 2,
                        style = MobiTheme.typography.labelSmallBold,
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
                                start = MobiTheme.dimens.dimen_0_5,
                                end = MobiTheme.dimens.dimen_0_5,
                                top = textPadding,
                                bottom = textPadding
                            )
                            .fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(MobiTheme.dimens.dimen_0_75))
                }

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
    MobiTheme {
        Surface {
            ProductCategoryItem(
                ProductCategoryUiData(
                    id = 0,
                    nameResId = com.samuraicmdv.common.R.string.product_category_other_name,
                    imageUrl = "",
                    productsCount = 1245
                ),
                handleEvent = {},
                modifier = modifier.size(100.dp, 140.dp)
            )
        }
    }
}