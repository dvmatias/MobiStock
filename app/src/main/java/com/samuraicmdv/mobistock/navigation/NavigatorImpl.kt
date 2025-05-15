package com.samuraicmdv.mobistock.navigation

import android.app.Activity
import android.os.Bundle
import com.samuraicmdv.common.extension.navigate
import com.samuraicmdv.common.navigation.Navigator
import com.samuraicmdv.featurebarcodescanner.BarcodeScannerActivity
import com.samuraicmdv.featuredashboard.DashboardActivity
import com.samuraicmdv.featurecategory.CategoryActivity
import com.samuraicmdv.featureproductdetails.ProductDetailsActivity

/**
 * Implementation - This class implements the contract declared on [Navigator]. It implements all
 * methods use for navigate between activities in the app.
 */
class NavigatorImpl: Navigator {
    /**
     * Navigates to [DashboardActivity]
     */
    override fun toHome(origin: Activity, data: Bundle?, finish: Boolean) {
        origin.navigate<DashboardActivity>(data, finish)
    }

    /**
     * Navigates to [CategoryActivity]
     */
    override fun toProductCategory(origin: Activity, data: Bundle?, finish: Boolean) {
        origin.navigate<CategoryActivity>(data, finish)
    }

    /**
     * Navigates to [ProductDetailsActivity]
     */
    override fun toProductDetails(origin: Activity, data: Bundle?, finish: Boolean) {
        origin.navigate<ProductDetailsActivity>(data, finish)
    }

    override fun toBarcodeScanner(origin: Activity, data: Bundle?, finish: Boolean) {
        origin.navigate<BarcodeScannerActivity>(data, finish)
    }
}