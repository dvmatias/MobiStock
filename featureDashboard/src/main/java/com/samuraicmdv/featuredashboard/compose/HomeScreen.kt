package com.samuraicmdv.featuredashboard.compose

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.samuraicmdv.common.theme.MobiTheme
import com.samuraicmdv.featuredashboard.data.BranchType
import com.samuraicmdv.featuredashboard.data.UserUiData
import com.samuraicmdv.featuredashboard.event.DashboardEvent
import com.samuraicmdv.featuredashboard.state.DailySaleState
import com.samuraicmdv.featuredashboard.state.DashboardScreenState
import com.samuraicmdv.featuredashboard.state.UserProfileUiData
import com.samuraicmdv.ui.util.ThemePreviews

@Composable
fun HomeScreen(
    uiState: DashboardScreenState,
    modifier: Modifier = Modifier,
    handleEvent: (DashboardEvent) -> Unit,
) {
    val userName = uiState.profile?.user?.name
    val userAddress = uiState.profile?.user?.address
    val userLogoUtl = uiState.profile?.user?.logoUrl
    val relatedUsers = uiState.profile?.relatedUsers
    val showUsersBottomSheet = uiState.isUsersBottomSheetDisplayed

    Scaffold(
        topBar = {
            HomeScreenTopBarContent(
                userName = userName,
                userAddress = userAddress,
                userLogoUrl = userLogoUtl,
                handleEvent = handleEvent
            )
        },
        modifier = modifier.fillMaxSize(),
    ) { paddingValues ->
        UsersBottomSheetContent(relatedUsers, showUsersBottomSheet, handleEvent = handleEvent)
        HomeScreenContent(uiState, handleEvent, Modifier.padding(paddingValues))
    }
}

@ThemePreviews
@Composable
fun PreviewHomeScreen() {
    MobiTheme {
        // A surface container using the 'background' color from the theme
        Surface {
            HomeScreen(
                uiState = DashboardScreenState(
                    profile = UserProfileUiData(
                        user = UserUiData(
                            id = 1,
                            name = "User name 1",
                            address = "User Address 123, Lorem, ipsum",
                            branchType = BranchType.DEPOSIT,
                            logoUrl = "",
                            isAdmin = true,
                            isCurrentSelected = true
                        ),
                        relatedUsers = listOf(
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
                                branchType = BranchType.UNKNOWN,
                                logoUrl = "",
                                isAdmin = false,
                                isCurrentSelected = false
                            )
                        )
                    ),
                    dailySaleState = DailySaleState(),
                    isUsersBottomSheetDisplayed = false
                )
            ) {}
        }
    }
}
