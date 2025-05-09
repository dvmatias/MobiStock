package com.samuraicmdv.featuredashboard.compose

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.samuraicmdv.common.theme.MobiTheme
import com.samuraicmdv.featuredashboard.data.BranchType
import com.samuraicmdv.featuredashboard.data.UserUiData
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
    MobiTheme {
        Surface {
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
            branchType = BranchType.SALES_BRANCH,
            logoUrl = "",
            isAdmin = true,
            isCurrentSelected = true
        ),
        UserUiData(
            id = 2,
            name = "User name 2",
            address = "User Address 456, Lorem, ipsum",
            branchType = BranchType.SALES_BRANCH,
            logoUrl = "",
            isAdmin = false,
            isCurrentSelected = false
        ),
        UserUiData(
            id = 3,
            name = "User name 3",
            address = "User Address 789, Lorem, ipsum",
            branchType = BranchType.SALES_BRANCH,
            logoUrl = "",
            isAdmin = false,
            isCurrentSelected = false
        ),
        UserUiData(
            id = 4,
            name = "User name 4",
            address = "User Address 528, Lorem, ipsum",
            branchType = BranchType.SALES_BRANCH,
            logoUrl = "",
            isAdmin = false,
            isCurrentSelected = false
        ),
    )