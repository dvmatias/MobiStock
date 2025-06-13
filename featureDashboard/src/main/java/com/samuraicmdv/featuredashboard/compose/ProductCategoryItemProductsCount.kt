package com.samuraicmdv.featuredashboard.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.IntSize
import com.samuraicmdv.common.theme.MobiTheme

@Composable
fun ProductCategoryItemProductsCount(
    productsCount: Int,
    modifier: Modifier = Modifier,
) {
    var size by remember { mutableStateOf(IntSize.Zero) }
    val textColor = if (productsCount > 0) {
        MobiTheme.colors.onSecondaryContainer
    } else {
        MobiTheme.colors.onDisabledContainerColor
    }
    val backgroundColor = if (productsCount > 0) {
        MobiTheme.colors.secondaryContainer
    } else {
        MobiTheme.colors.disabledContainerColor
    }

    Box(modifier = modifier
        .wrapContentWidth()
        .onSizeChanged { newSize ->
            size = newSize
        }
        .sizeIn(minWidth = with(LocalDensity.current) { size.height.toDp() })
        .clip(
            RoundedCornerShape(MobiTheme.dimens.dimen_2)
        )
        .background(backgroundColor)
        .padding(
            start = MobiTheme.dimens.dimen_1,
            end = MobiTheme.dimens.dimen_1,
            top = MobiTheme.dimens.dimen_0_5,
            bottom = MobiTheme.dimens.dimen_0_5
        )
    ) {
        Text(
            text = productsCount.toString(),
            style = MobiTheme.typography.labelMediumBold,
            color = textColor,
            textAlign = TextAlign.Center,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}