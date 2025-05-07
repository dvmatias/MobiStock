package com.samuraicmdv.featureproductdetails.compose

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.samuraicmdv.common.theme.MobiTheme
import com.samuraicmdv.ui.util.ThemePreviews
import java.util.Locale

@Composable
fun HorizontalPagerIndicator(
    pagerState: PagerState,
    modifier: Modifier = Modifier
) {
    Surface(
        color = MobiTheme.colors.surfaceContainer,
        shadowElevation = 4.dp,
        shape = RoundedCornerShape(percent = 50),
        modifier = modifier
    ) {
        Text(
            text = String.format(Locale.getDefault(), "%d/%d", pagerState.currentPage + 1, pagerState.pageCount),
            style = MobiTheme.typography.labelLargeBold,
            modifier = Modifier
                .padding(horizontal = MobiTheme.dimens.dimen_2, vertical = MobiTheme.dimens.dimen_0_5)
        )
    }
}

@ThemePreviews
@Composable
fun PreviewHorizontalPagerIndicator() {
    MobiTheme {
        Surface(
            color = MobiTheme.colors.background
        ) {
            HorizontalPagerIndicator(pagerState = object : PagerState() {
                override val pageCount: Int
                    get() = 5

            })
        }
    }
}