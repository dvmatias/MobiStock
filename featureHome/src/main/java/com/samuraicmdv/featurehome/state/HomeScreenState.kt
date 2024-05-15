package com.samuraicmdv.featurehome.state

/**
 * Data class for modeling [com.samuraicmdv.featurehome.compose.HomeScreen] composable screen and
 * other related composable functions.
 *
 * @param profile User profile data to be displayed on the screen.
 * @param productCategories Product categories data to be displayed on the screen.
 * @param isUsersBottomSheetDisplayed Users bottom sheet state.
 */
data class HomeScreenState(
    val profile: UserProfileUiData? = null,
    val productCategories: ProductCategoriesUiData? = null,
    val isUsersBottomSheetDisplayed: Boolean = false,
)
