package com.samuraicmdv.featurehome.compose

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import coil.compose.rememberAsyncImagePainter
import com.samuraicmdv.common.theme.MobiTheme
import com.samuraicmdv.featurehome.data.BranchType
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
            horizontal = MobiTheme.dimens.dimen_3,
            vertical = MobiTheme.dimens.dimen_1
        ),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .clickable { /*TODO*/ }
                .padding(
                    horizontal = MobiTheme.dimens.dimen_1,
                    vertical = MobiTheme.dimens.dimen_1
                ),
        ) {
            Canvas(modifier = Modifier.size(MobiTheme.dimens.dimen_1)) {
                drawCircle(
                    color = if (user.isCurrentSelected) Color.Red else Color.Transparent,
                    radius = 12f,
                    center = center
                )
            }
            Spacer(modifier = Modifier.width(MobiTheme.dimens.dimen_0_5))
            Row(modifier = Modifier.weight(1F)) {
                Image(
                    painter = rememberAsyncImagePainter(user.logoUrl),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(MobiTheme.dimens.dimen_5)
                        .clip(CircleShape)
                        .background(MobiTheme.colors.onDisabledContainerColor)
                )
                Spacer(modifier = Modifier.width(MobiTheme.dimens.dimen_1))
                Column {
                    Text(
                        text = user.name.uppercase(),
                        style = MobiTheme.typography.bodyMediumBold,
                        color = MobiTheme.colors.textPrimary,
                    )
                    Text(
                        text = user.address,
                        style = MobiTheme.typography.bodyMedium,
                        color = MobiTheme.colors.textPrimary
                    )
                }
                Spacer(modifier = Modifier.width(MobiTheme.dimens.dimen_1))
            }
            Icon(
                Icons.AutoMirrored.Filled.KeyboardArrowRight,
                tint = MobiTheme.colors.textPrimary,
                contentDescription = "",
            )
        }
//        if (userUiData.isCurrent) {
//            Text(
//                text = "Edit".uppercase(),
//                style = MobiTheme.typography.bodyBold,
//                color = MobiTheme.colors.linkEnabled,
//                modifier = Modifier
//                    .padding(
//                        horizontal = MobiTheme.spaces.grid_2,
//                        vertical = MobiTheme.spaces.grid_1
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
    MobiTheme {
        Surface {
            UsersBottomSheetItem(
                user = UserUiData(
                    id = 1,
                    name = "User name",
                    address = "User Address 123, Lorem, ipsum",
                    branchType = BranchType.SALES_BRANCH,
                    logoUrl = "",
                    isAdmin = true,
                    isCurrentSelected = true
                )
            ) {}
        }
    }
}