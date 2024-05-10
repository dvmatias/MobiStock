package com.samuraicmdv.featurehome.compose

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.samuraicmdv.common.theme.MobiStockTheme
import com.samuraicmdv.featurehome.data.BranchType
import com.samuraicmdv.featurehome.data.UserUiData
import com.samuraicmdv.featurehome.event.HomeEvent
import com.samuraicmdv.featurehome.state.HomeScreenState
import com.samuraicmdv.featurehome.state.UserProfileUiData
import com.samuraicmdv.ui.util.ThemePreviews

@Composable
fun HomeScreen(
    uiState: HomeScreenState,
    modifier: Modifier = Modifier,
    handleEvent: (HomeEvent) -> Unit,
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
        HomeScreenContent(Modifier.padding(paddingValues))
    }
}

@ThemePreviews
@Composable
fun PreviewHomeScreen() {
    MobiStockTheme {
        // A surface container using the 'background' color from the theme
        Surface(color = MobiStockTheme.colors.backgroundPrimary) {
            HomeScreen(
                uiState = HomeScreenState(
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
                    isUsersBottomSheetDisplayed = false
                )
            ) {}
        }
    }
}
