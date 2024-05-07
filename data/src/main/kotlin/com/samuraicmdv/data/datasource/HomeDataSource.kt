package com.samuraicmdv.data.datasource

/**
 * Interface Data Source - This class along with its implementations are in charge of originate data
 * that serves the Home screen.
 */
interface HomeDataSource {
    /**
     * Gets the current user profile
     *
     * @param userId User ID to fetch user's profile.
     */
    fun getUserProfile(userId: Int)
}