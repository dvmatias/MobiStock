package com.samuraicmdv.featuredashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.samuraicmdv.domain.usecase.GetDaySalesLedgerUseCase
import com.samuraicmdv.domain.usecase.GetProductCategoriesUseCase
import com.samuraicmdv.domain.usecase.GetUserProfileUseCase
import com.samuraicmdv.featuredashboard.state.DailySaleUiData
import com.samuraicmdv.featuredashboard.state.DashboardScreenState
import com.samuraicmdv.featuredashboard.state.ProductCategoriesState
import com.samuraicmdv.featuredashboard.transformer.DashboardUiDataTransformer
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

/**
 * View model for the [DashboardActivity].
 */
@HiltViewModel(assistedFactory = DashboardViewModel.Factory::class)
class DashboardViewModel @AssistedInject constructor(
    @Assisted private val params: Params,
    private val getUserProfileUseCase: GetUserProfileUseCase,
    private val getProductCategoriesUseCase: GetProductCategoriesUseCase,
    private val getDaySalesLedger: GetDaySalesLedgerUseCase,
    private val transformer: DashboardUiDataTransformer,
) : ViewModel() {

    private val _uiState = MutableStateFlow(
        DashboardScreenState(
            profile = null,
            dailySaleUiData = DailySaleUiData(isLoading = true),
            productCategoriesState = ProductCategoriesState(isLoading = true),
        )
    )
    val uiState: StateFlow<DashboardScreenState>
        get() = _uiState.asStateFlow()

    init {
        getStoreProfile()
        getProductCategories()
        getDailySalesLedge()
    }

    private fun getStoreProfile() {
        viewModelScope.launch {
            // GetUser profile
            getUserProfileUseCase(GetUserProfileUseCase.Params(params.storeId)).let { userProfileModel ->
                _uiState.update { currentState ->
                    currentState.copy(
                        profile = transformer.transformUserProfile(userProfileModel)
                    )
                }
            }
        }
    }

    private fun getProductCategories() {
        viewModelScope.launch {
            // Put the product categories state into loading state
            _uiState.update { currentState ->
                currentState.copy(
                    productCategoriesState = currentState.productCategoriesState?.copy(isLoading = true)
                )
            }
            getProductCategoriesUseCase(
                GetProductCategoriesUseCase.Params(params.storeId)
            ).let { productCategories ->
                _uiState.update { currentState ->
                    currentState.copy(
                        productCategoriesState = transformer.transformProductCategories(productCategories)
                    )
                }
            }
        }
    }

    private fun getDailySalesLedge() {
        viewModelScope.launch {
            getDaySalesLedger(
                GetDaySalesLedgerUseCase.Params(
                    storeId = params.storeId,
                    day = params.day,
                    month = params.month,
                    year = params.year
                )
            ).let { dailySales ->
                _uiState.update { currentState ->
                    currentState.copy(
                        dailySaleUiData = transformer.transformDailySales(dailySales)
                    )
                }
            }
        }
    }

    /**
     * Updates the state for the users bottom sheet.
     *
     * @param show Value to be set on [DashboardScreenState.isUsersBottomSheetDisplayed]. If 'true' the
     * users bottom sheet should be displayed, if 'false' it should be hidden.
     */
    fun updateUsersBottomSheetState(show: Boolean) {
        _uiState.update { currentState ->
            currentState.copy(isUsersBottomSheetDisplayed = show)
        }
    }

    /**
     * Toggles the expanded status of a specific product category.
     *
     * @param id The ID of the product category to toggle.
     * @param isExpanded Boolean indicating whether the category should be expanded or collapsed.
     */
    fun toggleCategoryExpandedStatus(
        id: Int,
        isExpanded: Boolean
    ) {
        _uiState.update { currentState ->
            currentState.copy(
                productCategoriesState = currentState.productCategoriesState?.copy(
                    categories = currentState.productCategoriesState.categories?.map {
                        if (it.id == id) {
                            it.copy(isExpanded = isExpanded)
                        } else {
                            it
                        }
                    }
                )
            )
        }
    }

    /**
     * Toggles the expanded status of all product categories.
     *
     * @param areAllCategoriesExpanded Boolean indicating whether all categories should be expanded or collapsed.
     */
    fun toggleAllCategoriesExpandedStatus(areAllCategoriesExpanded: Boolean) {
        _uiState.update { currentState ->
            currentState.copy(
                productCategoriesState = currentState.productCategoriesState?.copy(
                    categories = currentState.productCategoriesState.categories?.map {
                        it.copy(isExpanded = areAllCategoriesExpanded)
                    }
                )
            )
        }
    }

    /**
     * View model's factory. This is used by the view model to create instances of itself. This is
     * needed to pass the 'storeId' parameter from the [DashboardActivity] to the view model.
     */
    @AssistedFactory
    interface Factory {
        fun create(
            params: Params
        ): DashboardViewModel
    }

    data class Params(
        val storeId: Int,
        val day: Int,
        val month: Int,
        val year: Int
    )
}
