package com.samuraicmdv.featurehome.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
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
import com.samuraicmdv.featurehome.data.UserType
import com.samuraicmdv.featurehome.data.UserUiData
import com.samuraicmdv.featurehome.event.HomeEvent
import com.samuraicmdv.ui.util.ThemePreviews

@Composable
fun UsersBottomSheetItem(
    user: UserUiData,
    modifier: Modifier = Modifier,
    handleEvent: (HomeEvent) -> Unit,
) {
    Column(
        modifier = modifier.padding(
            horizontal = MobiStockTheme.spaces.grid_3,
            vertical = MobiStockTheme.spaces.grid_2
        ),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .clickable { /*TODO*/ }
        ) {
            Row(modifier = Modifier.weight(1F)) {
                Image(
                    painter = painterResource(id = R.drawable.user_profile_example), // TODO load image from URL and use a default for loading or null
                    contentDescription = null,
                    modifier = Modifier
                        .size(MobiStockTheme.spaces.grid_5)
                        .clip(CircleShape)
                )
                Spacer(modifier = Modifier.width(MobiStockTheme.spaces.grid_1))
                Column {
                    Text(
                        text = user.name?.uppercase() ?: "",
                        style = MobiStockTheme.typography.mediumBold,
                        color = MobiStockTheme.colors.foregroundPrimary,
                    )
                    Text(
                        text = user.address ?: "",
                        style = MobiStockTheme.typography.bodyRegular,
                        color = MobiStockTheme.colors.foregroundPrimary
                    )
                }
                Spacer(modifier = Modifier.width(MobiStockTheme.spaces.grid_1))
            }
            Icon(
                Icons.AutoMirrored.Filled.KeyboardArrowRight,
                tint = MobiStockTheme.colors.foregroundPrimary,
                contentDescription = "",
            )
        }
//        if (userUiData.isCurrent) {
//            Text(
//                text = "Edit".uppercase(),
//                style = MobiStockTheme.typography.bodyBold,
//                color = MobiStockTheme.colors.linkEnabled,
//                modifier = Modifier
//                    .padding(
//                        horizontal = MobiStockTheme.spaces.grid_2,
//                        vertical = MobiStockTheme.spaces.grid_1
//                    )
//                    .align(Alignment.End)
//                    .clickable { /*TODO*/ }
//            )
//        }
    }
}

@ThemePreviews
@Composable
fun PreviewUsersBottomSheetItem(modifier: Modifier = Modifier) {
    MobiStockTheme {
        Surface(color = MobiStockTheme.colors.backgroundPrimary) {
            UsersBottomSheetItem(
                user = UserUiData(
                    id = 1,
                    name = "User name",
                    address = "User Address 123, Lorem, ipsum",
                    type = UserType.SALES_BRANCH,
                    logoUrl = "",
                    isAdmin = true,
                    isCurrent = true
                )
            ) {}
        }
    }
}