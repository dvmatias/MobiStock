package com.samuraicmdv.featuredashboard.state

/**
 * Data class for modeling [com.samuraicmdv.featuredashboard.compose.HomeScreen] composable screen and
 * other related composable functions.
 *
 * @param profile User profile data to be displayed on the screen.
 * @param productCategoriesState Product categories data to be displayed on the screen.
 * @param isUsersBottomSheetDisplayed Users bottom sheet state.
 */
data class DashboardScreenState(
    val profile: UserProfileUiData? = null,
    val isUsersBottomSheetDisplayed: Boolean = false,
    val productCategoriesState: ProductCategoriesState? = null,
    val dailySaleState: DailySaleState? = null
)
