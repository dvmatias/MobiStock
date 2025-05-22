package com.samuraicmdv.featuredashboard.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.samuraicmdv.common.theme.MobiTheme
import com.samuraicmdv.featuredashboard.R
import com.samuraicmdv.featuredashboard.event.DashboardEvent
import com.samuraicmdv.ui.util.ThemePreviews

@Composable
fun HomeScreenTopBarContent(
    userName: String?,
    userAddress: String?,
    userLogoUrl: String?,
    modifier: Modifier = Modifier,
    handleEvent: (DashboardEvent) -> Unit,
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .background(MobiTheme.colors.surfaceContainer)
            .height(MobiTheme.dimens.topAppBar)
    ) {
        Text(
            text = stringResource(R.string.home_product_categories_title),
            style = MobiTheme.typography.bodyLargeBold,
        )
//        HomeScreenTopBarUserContent(
//            userName = userName,
//            userAddress = userAddress,
//            userLogoUrl = userLogoUrl,
//            handleEvent = handleEvent
//        )
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