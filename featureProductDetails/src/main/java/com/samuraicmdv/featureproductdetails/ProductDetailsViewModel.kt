package com.samuraicmdv.featureproductdetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.samuraicmdv.domain.usecase.CreateProductUseCase
import com.samuraicmdv.domain.usecase.GetBrandsUseCase
import com.samuraicmdv.domain.usecase.GetProductCategoriesUseCase
import com.samuraicmdv.featureproductdetails.data.BrandUiData
import com.samuraicmdv.featureproductdetails.data.CategoryUiData
import com.samuraicmdv.featureproductdetails.data.ProductPriceUiData
import com.samuraicmdv.featureproductdetails.data.ProductUiData
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
    private val createProductUseCase: CreateProductUseCase,
    private val transformer: ProductDetailsUiDataTransformer,
) : ViewModel() {
    /**
     * The state of the UI for the product details screen. Initially is loading.
     */
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
                        // Fetch the product details
                        launch { fetchProductDetails() }
                    }

                    ProductDetailsUiMode.EDIT -> {
                        // Fetch the product details
                        launch { fetchProductDetails() }
                        // Fetch the available categories
                        launch { fetchCategories() }
                        // Fetch the available brands
                        launch { fetchBrands() }

                    }

                    ProductDetailsUiMode.CREATE -> {
                        // Fetch the available categories
                        launch { fetchCategories() }
                        // Fetch the available brands
                        launch { fetchBrands() }
                        // When creating a new product, initialized the product UI data
                        _uiState.value = _uiState.value.copy(product = getEmptyProduct())
                    }

                    else -> {
                        // Do nothing
                    }
                }
            }
            // Update the loading status once all the initial needed calls are done.
            _uiState.value = _uiState.value.copy(isLoading = false)
        }
    }

    /**
     * Fetches the product details. This is only needed when the screen is in view mode or edit mode.
     */
    private suspend fun fetchProductDetails() {
        // TODO
    }

    /**
     * Fetches the available categories. This is only needed when the screen is in edit mode or create mode.
     */
    private suspend fun fetchCategories() {
        getProductCategoriesUseCase(GetProductCategoriesUseCase.Params(storeId = storeId, all = true)).let {
            _uiState.value = _uiState.value.copy(categories = transformer.transformCategories(it))
        }
    }

    /**
     * Fetches the available brands. This is only needed when the screen is in edit mode or create mode.
     */
    private suspend fun fetchBrands() {
        getBrandsUseCase(GetBrandsUseCase.Params(storeId = storeId)).let {
            _uiState.value = _uiState.value.copy(brands = transformer.transformBrands(it))
        }
    }

    /**
     * Creates a new product.
     */
    fun createProduct(product: ProductUiData) {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true)
            createProductUseCase(
                CreateProductUseCase.Params(
                    name = product.name!!,
                    shortDescription = product.shortDescription!!,
                    longDescription = product.longDescription!!,
                    code = product.code,
                    model = product.model,
                    categoryId = product.category?.id!!,
                    brandId = product.brand?.id!!,
                    sku = product.sku,
                    selling = product.price!!.sellingPrice,
                    cost = product.price.costPrice,
                    currencyId = 1,
                    storeId = storeId,
                    preferredMargin = product.price.preferredMargin,
                )
            ).let {
                it.id?.let { producId ->
                    _uiState.value = _uiState.value.copy(
                        screenMode = ProductDetailsUiMode.CREATE_SUCCESS, // Update screen state to show success screen
                        product = ProductUiData(id = producId) // Update the product with the newly created product id
                    )
                } ?: run {
                    // TODO Error
                }
            }
        }
    }

    private fun getEmptyProduct() = ProductUiData(
        id = -1,
        name = "",
        shortDescription = "",
        longDescription = "",
        model = "",
        code = "",
        sku = "",
        thumbnailUrl = "",
        imageUrls = emptyList(),
        price = ProductPriceUiData(),
        brand = BrandUiData(
            id = -1,
            name = "",
            logoUrl = "",
        ),
        category = CategoryUiData(
            id = -1,
            nameResId = -1,
            description = "",
            logoUrl = "",
        ),
    )

    @AssistedFactory
    interface Factory {
        fun create(
            @Assisted("storeId") storeId: Int,
            @Assisted("productId") productId: Int,
            @Assisted("isEditMode") isEditMode: Boolean
        ): ProductDetailsViewModel
    }
}