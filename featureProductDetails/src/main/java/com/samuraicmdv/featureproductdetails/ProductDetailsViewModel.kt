package com.samuraicmdv.featureproductdetails

import androidx.lifecycle.ViewModel
import com.samuraicmdv.featureproductdetails.state.ProductDetailsUiMode
import com.samuraicmdv.featureproductdetails.state.ProductDetailsUiState
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel(assistedFactory = ProductDetailsViewModel.Factory::class)
class ProductDetailsViewModel @AssistedInject constructor(
    @Assisted("productId") productId: Int,
    @Assisted("isEditMode") isEditMode: Boolean
) : ViewModel() {
    private val _uiState = MutableStateFlow(ProductDetailsUiState(isLoading = true))
    val uiState: StateFlow<ProductDetailsUiState>
        get() = _uiState.asStateFlow()

    init {
        // Set the screen mode first
        val screenMode: ProductDetailsUiMode =
            if (productId == -1) {
                if (isEditMode) ProductDetailsUiMode.EDIT else ProductDetailsUiMode.CREATE
            } else {
                ProductDetailsUiMode.VIEW
            }
        _uiState.value = _uiState.value.copy(screenMode = screenMode)

        // Make the needed calls according screen mode
        when (screenMode) {
            ProductDetailsUiMode.VIEW -> {
                // TODO
                // Fetch the product details
            }

            ProductDetailsUiMode.EDIT -> {
                // TODO
                // Fetch the product details
                // Fetch the available categories
                // Fetch the available brands
            }

            ProductDetailsUiMode.CREATE -> {
                // TODO
                // Fetch the available categories
                // Fetch the available brands
            }
        }
    }

    @AssistedFactory
    interface Factory {
        fun create(
            @Assisted("productId") productId: Int,
            @Assisted("isEditMode") isEditMode: Boolean
        ): ProductDetailsViewModel
    }
}