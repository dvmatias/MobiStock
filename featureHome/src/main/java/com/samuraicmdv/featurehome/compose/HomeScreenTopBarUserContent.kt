package com.samuraicmdv.featurehome.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import coil.compose.rememberImagePainter
import com.samuraicmdv.common.theme.MobiStockTheme
import com.samuraicmdv.featurehome.event.HomeEvent
import com.samuraicmdv.featurehome.event.HomePresentationEvent
import com.samuraicmdv.ui.util.ThemePreviews

@Composable
fun HomeScreenTopBarUserContent(
    userName: String?,
    userAddress: String?,
    userLogoUrl: String?,
    modifier: Modifier = Modifier,
    handleEvent: (HomeEvent) -> Unit,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.clickable {
            handleEvent(HomePresentationEvent.HandleUsersBottomSheetState(true))
        }
    ) {
        Image(
            painter = rememberImagePainter(userLogoUrl),
            contentDescription = null,
            modifier = Modifier
                .size(MobiStockTheme.spaces.grid_5)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.width(MobiStockTheme.spaces.grid_1))
        Column {
            userName?.let { name ->
                Text(
                    text = name.uppercase(),
                    style = MobiStockTheme.typography.mediumBold,
                    color = MobiStockTheme.colors.foregroundPrimary,
                )
            }
            userAddress?.let { address ->
                Text(
                    text = address,
                    style = MobiStockTheme.typography.smallRegular,
                    color = MobiStockTheme.colors.foregroundPrimary,
                )
            }
        }
        Spacer(modifier = Modifier.width(MobiStockTheme.spaces.grid_1))
        Icon(
            Icons.Default.KeyboardArrowDown,
            tint = MobiStockTheme.colors.foregroundPrimary,
            contentDescription = "",
        )
    }
}

@ThemePreviews
@Composable
fun PreviewHomeScreenTopBarUserContent(modifier: Modifier = Modifier) {
    MobiStockTheme {
        Surface(color = MobiStockTheme.colors.backgroundPrimary) {
            HomeScreenTopBarUserContent(
                userName = "User Name",
                userAddress = "User Address 123",
                userLogoUrl = "https://www.pokemon.com/static-assets/content-assets/cms2/img/pokedex/detail/009.png"
            ) {}
        }
    }
}