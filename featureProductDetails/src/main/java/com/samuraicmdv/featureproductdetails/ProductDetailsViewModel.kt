package com.samuraicmdv.featureproductdetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.samuraicmdv.domain.usecase.GetBrandsUseCase
import com.samuraicmdv.domain.usecase.GetProductCategoriesUseCase
import com.samuraicmdv.featureproductdetails.state.ProductDetailsUiMode
import com.samuraicmdv.featureproductdetails.state.ProductDetailsUiState
import com.samuraicmdv.featureproductdetails.transformer.ProductDetailsUiDataTransformer
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

@HiltViewModel(assistedFactory = ProductDetailsViewModel.Factory::class)
class ProductDetailsViewModel @AssistedInject constructor(
    @Assisted("storeId") val storeId: Int,
    @Assisted("productId") val productId: Int,
    @Assisted("isEditMode") val isEditMode: Boolean,
    private val getProductCategoriesUseCase: GetProductCategoriesUseCase,
    private val getBrandsUseCase: GetBrandsUseCase,
    private val transformer: ProductDetailsUiDataTransformer,
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
        viewModelScope.launch {
            coroutineScope {
                when (screenMode) {
                    ProductDetailsUiMode.VIEW -> {
                        // TODO
                        // Fetch the product details
                        launch { /* Fetch the product details */ }
                    }

                    ProductDetailsUiMode.EDIT -> {
                        // TODO
                        // Fetch the product details
                        launch { /* Fetch the product details */ }
                        // Fetch the available categories
                        launch { getCategories() }
                        // Fetch the available brands
                        launch { getBrands() }

                    }

                    ProductDetailsUiMode.CREATE -> {
                        // Fetch the available categories
                        launch { getCategories() }
                        // Fetch the available brands
                        launch { getBrands() }
                    }
                }
            }
            // Update the loading status once all the initial needed calls are done.
            _uiState.value = _uiState.value.copy(isLoading = false)
        }
    }

    private suspend fun getCategories() {
        getProductCategoriesUseCase(GetProductCategoriesUseCase.Params(storeId = storeId, all = true)).let {
            _uiState.value = _uiState.value.copy(categoriesUiData = transformer.transformCategories(it))
        }
    }

    private suspend fun getBrands() {
        getBrandsUseCase(GetBrandsUseCase.Params(storeId = storeId)).let {
            _uiState.value = _uiState.value.copy(brandsUiData = transformer.transformBrands(it))
        }
    }

    @AssistedFactory
    interface Factory {
        fun create(
            @Assisted("storeId") storeId: Int,
            @Assisted("productId") productId: Int,
            @Assisted("isEditMode") isEditMode: Boolean
        ): ProductDetailsViewModel
    }
}