package com.samuraicmdv.mobistock.navigation

import android.app.Activity
import android.os.Bundle
import com.samuraicmdv.common.extension.navigate
import com.samuraicmdv.common.navigation.Navigator
import com.samuraicmdv.featurehome.HomeActivity

class NavigatorImpl: Navigator {
    override fun toHome(origin: Activity, data: Bundle?, finish: Boolean) {
        origin.navigate<HomeActivity>(data, finish)
    }
}