package com.samuraicmdv.featureproductdetails.compose

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil.compose.rememberAsyncImagePainter
import com.samuraicmdv.common.theme.MobiTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ProductDetailsImageGallery(
    imageUrls: List<String>?,
    modifier: Modifier
) {
    imageUrls?.let {
        val pagerState = rememberPagerState(pageCount = { it.size })

        Box {
            HorizontalPager(state = pagerState, modifier = modifier.fillMaxWidth()) { page ->
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1.3F)
                        .background(MobiTheme.colors.disabledContainerColor)
                ) {
                    Image(
                        painter = rememberAsyncImagePainter(model = imageUrls[page]),
                        contentDescription = "Image $page",
                        contentScale = ContentScale.FillHeight,
                        modifier = Modifier
                            .fillMaxWidth()
                            .aspectRatio(1.3F)
                    )
                }

            }

            HorizontalPagerIndicator(
                pagerState = pagerState,
                modifier = Modifier.align(Alignment.BottomCenter)
                    .padding(bottom = MobiTheme.dimens.dimen_2, top = MobiTheme.dimens.dimen_2)
            )
        }
    }
}