package com.samuraicmdv.featurehome.data

/**
 * Data class that models a user.
 *
 * @param id User's unique identifier.
 * @param name User's name
 * @param address User's Address
 * @param type User's type.
 * @param logoUrl User's logo URL.
 * @param isAdmin Set to 'true' for admin users, 'false' otherwise.
 * @param isCurrent Set to 'true' if the user is the current selected user, 'false' if not.
 */
data class UserUiData(
    val id: Int,
    val name: String,
    val address: String,
    val type: UserType,
    val logoUrl: String,
    val isAdmin: Boolean,
    val isCurrent: Boolean
)