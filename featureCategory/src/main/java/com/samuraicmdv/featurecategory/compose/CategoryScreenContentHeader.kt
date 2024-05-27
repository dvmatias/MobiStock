package com.samuraicmdv.featurecategory.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInRoot
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.samuraicmdv.common.ALPHA_FULL
import com.samuraicmdv.common.ALPHA_ZERO
import com.samuraicmdv.common.theme.MobiTheme
import com.samuraicmdv.featurecategory.R
import com.samuraicmdv.ui.util.ThemePreviews

@Composable
fun CategoryScreenContentHeader(
    name: String?,
    description: String?,
    imageUrl: String?,
    productsCount: Int?,
    productsQuantity: Int?,
    onCategoryTitleAlphaChange: (Float) -> Unit,
    modifier: Modifier = Modifier
) {
    val density = LocalDensity.current
    var titleAlpha by remember {
        mutableFloatStateOf(ALPHA_FULL)
    }
    Row(
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = MobiTheme.dimens.dimen_2)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .weight(1F)
                .padding(end = MobiTheme.dimens.dimen_2)
        ) {
            name?.let {
                Text(
                    text = it,
                    style = MobiTheme.typography.headlineLarge,
                    modifier = Modifier
                        .fillMaxWidth()
                        .alpha(titleAlpha)
                        .padding(start = MobiTheme.dimens.dimen_1 * (ALPHA_FULL - titleAlpha))
                        .onGloballyPositioned { layoutCoordinates ->
                            val height = layoutCoordinates.size.height
                            val topPosition = layoutCoordinates.positionInRoot().y
                            val bottomLeftPosition =
                                topPosition + height - with(density) { 64.dp.toPx() } // 64 dp represents the top app bar height

                            titleAlpha = when {
                                bottomLeftPosition in 0f..height.toFloat() ->
                                    (bottomLeftPosition / height).coerceIn(ALPHA_ZERO, ALPHA_FULL)

                                bottomLeftPosition <= 0 -> ALPHA_ZERO
                                else -> ALPHA_FULL
                            }
                            onCategoryTitleAlphaChange(titleAlpha)
                        }
                )
            }
            Spacer(modifier = Modifier.height(MobiTheme.dimens.dimen_1))
            description?.let {
                Text(
                    text = it,
                    style = MobiTheme.typography.bodyLarge,
                    lineHeight = 18.sp,
                    modifier = Modifier.fillMaxWidth()
                )
            }
            Spacer(modifier = Modifier.height(MobiTheme.dimens.dimen_1))
            productsCount?.let {
                Text(
                    text = "Products count: $it",
                    style = MobiTheme.typography.bodyMedium,
                    modifier = Modifier.fillMaxWidth()
                ) // TODO
            }
            productsQuantity?.let {
                Text(
                    text = "Products quantity: $it",
                    style = MobiTheme.typography.bodyMedium,
                    modifier = Modifier.fillMaxWidth()
                ) // TODO
            }
        }
        Image(
            painter = painterResource(id = R.drawable.logo_1),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth(0.3F)
                .aspectRatio(1F)
        )
    }
}

@ThemePreviews
@Composable
fun PreviewCategoryHeader(modifier: Modifier = Modifier) {
    MobiTheme {
        Surface {
            CategoryScreenContentHeader(
                name = "Category Name",
                description = "Lorem ipsum dolor sato sit amet. Lorem ipsum dolor sato sit amet. ",
                imageUrl = "https://www.example.com/image.jpg",
                productsCount = 10,
                productsQuantity = 100,
                onCategoryTitleAlphaChange = {},
                modifier = Modifier.padding(horizontal = MobiTheme.dimens.dimen_2)
            )
        }
    }
}