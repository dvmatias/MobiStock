package com.samuraicmdv.featuredashboard.compose

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
import coil.compose.rememberAsyncImagePainter
import com.samuraicmdv.common.theme.MobiTheme
import com.samuraicmdv.featuredashboard.event.DashboardEvent
import com.samuraicmdv.featuredashboard.event.DashboardPresentationEvent
import com.samuraicmdv.ui.util.ThemePreviews

@Composable
fun HomeScreenTopBarUserContent(
    userName: String?,
    userAddress: String?,
    userLogoUrl: String?,
    modifier: Modifier = Modifier,
    handleEvent: (DashboardEvent) -> Unit,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.clickable {
            handleEvent(DashboardPresentationEvent.HandleUsersBottomSheetState(true))
        }
    ) {
        Image(
            painter = rememberAsyncImagePainter(userLogoUrl),
            contentDescription = null,
            modifier = Modifier
                .size(MobiTheme.dimens.dimen_5)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.width(MobiTheme.dimens.dimen_1))
        Column {
            userName?.let { name ->
                Text(
                    text = name.uppercase(),
                    style = MobiTheme.typography.bodyLargeBold,
                    color = MobiTheme.colors.textPrimary,
                )
            }
            userAddress?.let { address ->
                Text(
                    text = address,
                    style = MobiTheme.typography.labelSmallBold,
                    color = MobiTheme.colors.textPrimary,
                )
            }
        }
        Spacer(modifier = Modifier.width(MobiTheme.dimens.dimen_1))
        Icon(
            Icons.Default.KeyboardArrowDown,
            tint = MobiTheme.colors.textPrimary,
            contentDescription = "",
        )
    }
}

@ThemePreviews
@Composable
fun PreviewHomeScreenTopBarUserContent(modifier: Modifier = Modifier) {
    MobiTheme {
        Surface {
            HomeScreenTopBarUserContent(
                userName = "User Name",
                userAddress = "User Address 123",
                userLogoUrl = "https://www.pokemon.com/static-assets/content-assets/cms2/img/pokedex/detail/009.png"
            ) {}
        }
    }
}