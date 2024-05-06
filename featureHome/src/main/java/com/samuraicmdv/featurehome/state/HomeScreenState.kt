package com.samuraicmdv.featurehome.state

import com.samuraicmdv.featurehome.data.UserUiData

/**
 * Data class for modeling [com.samuraicmdv.featurehome.compose.HomeScreen] composable screen and
 * other related composable functions.
 *
 * @param userName Current/Selected user name.
 * @param userAddress Current/Selected user address.
 * @param isUsersBottomSheetDisplayed Users bottom sheet state.
 * @param users List of all users.
 */
data class HomeScreenState(
    val userName: String ? = null,
    val userAddress: String ? = null,
    val isUsersBottomSheetDisplayed: Boolean = false,
    val users: List<UserUiData>? = null
)
