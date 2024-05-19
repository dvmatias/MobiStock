package com.samuraicmdv.featurehome.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.samuraicmdv.common.theme.MobiTheme
import com.samuraicmdv.featurehome.event.HomeEvent
import com.samuraicmdv.ui.util.ThemePreviews

@Composable
fun HomeScreenTopBarContent(
    userName: String?,
    userAddress: String?,
    userLogoUrl: String?,
    modifier: Modifier = Modifier,
    handleEvent: (HomeEvent) -> Unit,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(MobiTheme.colors.background)
            .padding(
                top = MobiTheme.dimens.dimen_1_5,
                bottom = MobiTheme.dimens.dimen_1_5,
                start = MobiTheme.dimens.dimen_3,
                end = MobiTheme.dimens.dimen_3
            )
    ) {
        HomeScreenTopBarUserContent(
            userName = userName,
            userAddress = userAddress,
            userLogoUrl = userLogoUrl,
            handleEvent = handleEvent
        )
    }
}

@ThemePreviews
@Composable
fun PreviewHomeScreenTopBarContent(modifier: Modifier = Modifier) {
    MobiTheme {
        Surface {
            HomeScreenTopBarContent(
                userName = "User Name",
                userAddress = "User Address 123",
                userLogoUrl = "https://www.pokemon.com/static-assets/content-assets/cms2/img/pokedex/detail/009.png"
            ) {
            }
        }
    }
}