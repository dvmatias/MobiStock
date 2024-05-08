package com.samuraicmdv.featurehome.compose

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.samuraicmdv.common.theme.MobiStockTheme
import com.samuraicmdv.featurehome.data.UserType
import com.samuraicmdv.featurehome.data.UserUiData
import com.samuraicmdv.ui.util.ThemePreviews

@Composable
fun UsersBottomSheetList(
    relatedUsers: List<UserUiData>?,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier
    ) {
        relatedUsers?.let { users ->
            items(users, { it.id }) {
                UsersBottomSheetItem(user = it) {/*TODO*/ }
            }
        }
    }
}

@ThemePreviews
@Composable
fun PreviewUsersList(modifier: Modifier = Modifier) {
    MobiStockTheme {
        Surface(color = MobiStockTheme.colors.backgroundPrimary) {
            UsersBottomSheetList(
                getBottomSheetUsersForPreview()
            )
        }
    }
}

fun getBottomSheetUsersForPreview() =
    listOf(
        UserUiData(
            id = 1,
            name = "User name 1",
            address = "User Address 123, Lorem, ipsum",
            type = UserType.SALES_BRANCH,
            logoUrl = "",
            isAdmin = true,
            isCurrent = true
        ),
        UserUiData(
            id = 2,
            name = "User name 2",
            address = "User Address 456, Lorem, ipsum",
            type = UserType.SALES_BRANCH,
            logoUrl = "",
            isAdmin = false,
            isCurrent = false
        ),
        UserUiData(
            id = 3,
            name = "User name 3",
            address = "User Address 789, Lorem, ipsum",
            type = UserType.SALES_BRANCH,
            logoUrl = "",
            isAdmin = false,
            isCurrent = false
        ),
        UserUiData(
            id = 4,
            name = "User name 4",
            address = "User Address 528, Lorem, ipsum",
            type = UserType.SALES_BRANCH,
            logoUrl = "",
            isAdmin = false,
            isCurrent = false
        ),
    )