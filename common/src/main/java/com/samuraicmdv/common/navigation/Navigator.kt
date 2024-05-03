package com.samuraicmdv.common.navigation

import android.app.Activity
import android.os.Bundle

interface Navigator {
    fun toHome(origin: Activity, data: Bundle? = null, finish: Boolean = false)
}