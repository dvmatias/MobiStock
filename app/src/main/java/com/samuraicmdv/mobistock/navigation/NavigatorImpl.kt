package com.samuraicmdv.mobistock.navigation

import android.app.Activity
import android.os.Bundle
import com.samuraicmdv.common.extension.navigate
import com.samuraicmdv.common.navigation.Navigator
import com.samuraicmdv.featurehome.HomeActivity
import com.samuraicmdv.featurecategory.CategoryActivity

/**
 * Implementation - This class implements the contract declared on [Navigator]. It implements all
 * methods use for navigate between activities in the app.
 */
class NavigatorImpl: Navigator {
    /**
     * Navigates to [HomeActivity]
     */
    override fun toHome(origin: Activity, data: Bundle?, finish: Boolean) {
        origin.navigate<HomeActivity>(data, finish)
    }

    /**
     * Navigates to [CategoryActivity]
     */
    override fun toProductCategory(origin: Activity, data: Bundle?, finish: Boolean) {
        origin.navigate<CategoryActivity>(data, finish)
    }
}