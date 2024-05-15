package com.samuraicmdv.featurehome.compose

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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.IntSize
import com.samuraicmdv.common.theme.MobiStockTheme

@Composable
fun ProductCategoryItemProductsCount(
    productsCount: Int,
    modifier: Modifier = Modifier,
) {
    var size by remember { mutableStateOf(IntSize.Zero) }
    Box(modifier = modifier
        .wrapContentWidth()
        .onSizeChanged { newSize ->
            size = newSize
        }
        .sizeIn(minWidth = with(LocalDensity.current) { size.height.toDp() })
        .clip(
            RoundedCornerShape(
                topStart = MobiStockTheme.spaces.grid_1,
                bottomEnd = MobiStockTheme.spaces.grid_1
            )
        )
        .background(MobiStockTheme.colors.brandPrimary)
        .padding(
            start = MobiStockTheme.spaces.grid_0_75,
            end = MobiStockTheme.spaces.grid_0_75,
            top = MobiStockTheme.spaces.grid_0_75,
            bottom = MobiStockTheme.spaces.grid_0_75
        )
    ) {
        Text(
            text = productsCount.toString(),
            style = MobiStockTheme.typography.smallBold,
            color = Color.White,
            textAlign = TextAlign.Center,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}