package com.samuraicmdv.featureproductcategory

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.hilt.navigation.compose.hiltViewModel
import com.samuraicmdv.common.BUNDLE_KEY_CATEGORY_ID
import com.samuraicmdv.featureproductcategory.theme.AppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CategoryActivity : ComponentActivity() {
    private val categoryId: Int
        get() = intent.getIntExtra(BUNDLE_KEY_CATEGORY_ID, -1)

    private lateinit var viewModel: CategoryViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                viewModel = hiltViewModel(
                    creationCallback = { factory: CategoryViewModel.Factory ->
                        factory.create(categoryId)
                    }
                )

                Surface {

                }
            }
        }
    }
}
