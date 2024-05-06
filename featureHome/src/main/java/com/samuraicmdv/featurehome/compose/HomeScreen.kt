package com.samuraicmdv.featurehome.compose

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.samuraicmdv.common.theme.MobiStockTheme
import com.samuraicmdv.featurehome.event.HomeEvent
import com.samuraicmdv.featurehome.state.HomeScreenState
import com.samuraicmdv.ui.util.ThemePreviews

@Composable
fun HomeScreen(
    uiState: HomeScreenState,
    modifier: Modifier = Modifier,
    handleEvent: (HomeEvent) -> Unit,
) {
    val userName by remember { mutableStateOf(uiState.userName) }
    val userAddress by remember { mutableStateOf(uiState.userAddress) }
    val users by remember { mutableStateOf(uiState.users) }
    val showUsersBottomSheet by remember(uiState.isUsersBottomSheetDisplayed) {
        mutableStateOf(uiState.isUsersBottomSheetDisplayed)
    }

    Scaffold(
        topBar = {
            HomeScreenTopBarContent(
                userName = userName,
                userAddress = userAddress,
                handleEvent = handleEvent
            )
        },
        modifier = modifier.fillMaxSize(),
    ) { paddingValues ->
        UsersBottomSheetContent(users, showUsersBottomSheet, handleEvent = handleEvent)
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
                    userName = "User Name",
                    userAddress = "User Address, 123 Lorem, ipsum",
                    isUsersBottomSheetDisplayed = false
                )
            ) {}
        }
    }
}