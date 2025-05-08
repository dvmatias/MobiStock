package com.samuraicmdv.featuredashboard.state

import com.samuraicmdv.featuredashboard.data.UserUiData

/**
 * User's profile ui data.
 *
 * @param user Current selected user.
 * @param relatedUsers List of all users.
 */
data class UserProfileUiData(
    val user: UserUiData? = null,
    val relatedUsers: List<UserUiData>? = null,
)
