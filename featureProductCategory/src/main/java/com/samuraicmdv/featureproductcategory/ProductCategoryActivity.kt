package com.samuraicmdv.featureproductcategory

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.samuraicmdv.common.BUNDLE_KEY_CATEGORY_ID
import com.samuraicmdv.common.BUNDLE_KEY_USER_ID
import com.samuraicmdv.common.theme.MobiStockTheme

class ProductCategoryActivity : ComponentActivity() {
    private val categoryId: Int
        get() = intent.getIntExtra(BUNDLE_KEY_CATEGORY_ID, -1)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MobiStockTheme {

            }
        }
    }
}
