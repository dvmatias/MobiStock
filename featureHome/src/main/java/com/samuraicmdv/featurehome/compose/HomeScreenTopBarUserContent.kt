package com.samuraicmdv.featurehome.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.res.painterResource
import com.samuraicmdv.common.theme.MobiStockTheme
import com.samuraicmdv.featurehome.R
import com.samuraicmdv.ui.util.ThemePreviews

@Composable
fun HomeScreenTopBarUserContent(
    userName: String,
    userAddress: String,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .padding(
                top = MobiStockTheme.spaces.grid_1_5,
                bottom = MobiStockTheme.spaces.grid_1_5,
                start = MobiStockTheme.spaces.grid_3
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.user_profile_example),
            contentDescription = null,
            modifier = Modifier
                .size(MobiStockTheme.spaces.grid_5)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.width(MobiStockTheme.spaces.grid_1))
        Column {
            Text(
                text = userName.uppercase(),
                style = MobiStockTheme.typography.mediumBold,
                color = MobiStockTheme.colors.foregroundPrimary,
            )
            Text(
                text = userAddress,
                style = MobiStockTheme.typography.bodyRegular,
                color = MobiStockTheme.colors.foregroundPrimary
            )
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
            HomeScreenTopBarUserContent(userName = "User Name", userAddress = "User Address 123")
        }
    }
}