package com.samuraicmdv.featureproductdetails.compose

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import com.samuraicmdv.common.theme.MobiTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HorizontalPagerIndicator(
    pagerState: PagerState,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(percent = 50))
            .background(MobiTheme.colors.secondaryContainer)
            .padding(horizontal = MobiTheme.dimens.dimen_1_5, vertical = MobiTheme.dimens.dimen_0_5)
    ) {
        Text(
            text = String.format("%d/%d", pagerState.currentPage + 1, pagerState.pageCount),
            color = MobiTheme.colors.onSecondaryContainer,
            style = MobiTheme.typography.bodyMedium,
        )
    }
}