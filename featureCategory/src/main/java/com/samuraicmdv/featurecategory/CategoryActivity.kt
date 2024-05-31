package com.samuraicmdv.featurecategory

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.core.os.bundleOf
import androidx.hilt.navigation.compose.hiltViewModel
import com.samuraicmdv.common.BUNDLE_KEY_CATEGORY_ID
import com.samuraicmdv.common.BUNDLE_KEY_IS_EDIT_MODE
import com.samuraicmdv.common.BUNDLE_KEY_PRODUCT_ID
import com.samuraicmdv.common.BUNDLE_KEY_STORE_ID
import com.samuraicmdv.common.navigation.Navigator
import com.samuraicmdv.common.theme.MobiTheme
import com.samuraicmdv.featurecategory.compose.CategoryScreen
import com.samuraicmdv.featurecategory.event.CategoryEvent
import com.samuraicmdv.featurecategory.event.CategoryNavigationEvent
import com.samuraicmdv.featurecategory.event.CategoryPresentationEvent
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class CategoryActivity : ComponentActivity() {
    @Inject
    lateinit var navigator: Navigator

    private val categoryId: Int
        get() = intent.getIntExtra(BUNDLE_KEY_CATEGORY_ID, -1)

    private val storeId: Int
        get() = intent.getIntExtra(BUNDLE_KEY_STORE_ID, -1)

    private lateinit var viewModel: CategoryViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MobiTheme {
                viewModel = hiltViewModel(
                    creationCallback = { factory: CategoryViewModel.Factory ->
                        factory.create(storeId, categoryId)
                    }
                )

                val uiState by viewModel.uiState.collectAsState()

                Surface {
                    CategoryScreen(
                        uiState = uiState,
                        handleEvent = { event -> handleEvent(event) }
                    )
                }
            }
        }
    }

    private fun handleEvent(event: CategoryEvent) {
        when (event) {
            is CategoryPresentationEvent.HandleProductDetailsBottomSheetState ->
                viewModel.updateProductDetailsBottomSheetState(event.show, event.product)

            is CategoryPresentationEvent.OnCategoryTitleAlphaChange ->
                viewModel.updateCategoryTitleAlpha(event.categoryTitleAlpha)

            is CategoryPresentationEvent.OnStickyHeaderPinned ->
                viewModel.updateStickyHeaderPinned(event.isHeaderPinned)

            is CategoryNavigationEvent.NavigateProductDetails -> {
                bundleOf(
                    BUNDLE_KEY_STORE_ID to storeId,
                    BUNDLE_KEY_PRODUCT_ID to event.productId,
                    BUNDLE_KEY_IS_EDIT_MODE to event.isEditMode
                ).also { data ->
                    navigator.toProductDetails(this, data)
                }
            }

            else -> {}
        }
    }
}
