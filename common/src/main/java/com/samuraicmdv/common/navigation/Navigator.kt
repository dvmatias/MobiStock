package com.samuraicmdv.common.navigation

import android.app.Activity
import android.os.Bundle

/**
 * Interface - Contract to be implemented. This contract defines all the possible navigation
 * destinations (Activities).
 */
interface Navigator {
    fun toHome(origin: Activity, data: Bundle? = null, finish: Boolean = false)
}