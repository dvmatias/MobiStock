package com.samuraicmdv.featureproductdetails

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.samuraicmdv.common.BUNDLE_KEY_IS_EDIT_MODE
import com.samuraicmdv.common.BUNDLE_KEY_PRODUCT_ID
import com.samuraicmdv.common.BUNDLE_KEY_STORE_ID
import com.samuraicmdv.common.theme.MobiTheme
import com.samuraicmdv.featureproductdetails.compose.ProductDetailsScreen
import com.samuraicmdv.featureproductdetails.event.ProductDetailsEvent
import com.samuraicmdv.featureproductdetails.event.ProductDetailsPresentationEvent
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductDetailsActivity : ComponentActivity() {
    /**
     * The ID of the store to which the product belongs.
     */
    private val storeId: Int
        get() = intent.getIntExtra(BUNDLE_KEY_STORE_ID, -1)

    /**
     * The ID of the product to display details for or edit. If this param is not provided in the Intent, the screen
     * will show an error message.
     */
    private val productId: Int
        get() = intent.getIntExtra(BUNDLE_KEY_PRODUCT_ID, -1)

    /**
     * Whether the screen is in edit mode or not. Default value is false, if this param is not provided in the Intent,
     * the screen will present a view mode for product details. This should be 'true' only for editing existent products.
     */
    private val isEditMode: Boolean
        get() = intent.getBooleanExtra(BUNDLE_KEY_IS_EDIT_MODE, false)

    private lateinit var viewModel: ProductDetailsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MobiTheme {
                // Create the view model instance
                viewModel = hiltViewModel(
                    creationCallback = { factory: ProductDetailsViewModel.Factory ->
                        factory.create(storeId, productId, isEditMode)
                    }
                )
                // Get the state for the screen
                val uiState by viewModel.uiState.collectAsState()
                Surface(modifier = Modifier.fillMaxSize()) {
                    ProductDetailsScreen(
                        uiState = uiState,
                        handleEvent = ::handleEvent
                    )
                }
            }
        }
    }

    private fun handleEvent(event: ProductDetailsEvent) {
        when (event) {
            is ProductDetailsPresentationEvent.CancelProductEdition -> {}// TODO()
            is ProductDetailsPresentationEvent.EditProduct -> {}// TODO()
            is ProductDetailsPresentationEvent.CreateNewProduct ->
                viewModel.createProduct(event.product)
            else -> {}
        }
    }
}