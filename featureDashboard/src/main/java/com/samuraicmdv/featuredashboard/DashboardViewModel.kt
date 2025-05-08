package com.samuraicmdv.featuredashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.samuraicmdv.domain.usecase.GetDailySalesLedgeUseCase
import com.samuraicmdv.domain.usecase.GetProductCategoriesUseCase
import com.samuraicmdv.domain.usecase.GetUserProfileUseCase
import com.samuraicmdv.featuredashboard.state.DailySaleState
import com.samuraicmdv.featuredashboard.state.DashboardScreenState
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

@HiltViewModel(assistedFactory = DashboardViewModel.Factory::class)
class DashboardViewModel @AssistedInject constructor(
    @Assisted private val storeId: Int,
    private val getUserProfileUseCase: GetUserProfileUseCase,
    private val getProductCategoriesUseCase: GetProductCategoriesUseCase,
    private val getDailySalesLedge: GetDailySalesLedgeUseCase,
    private val transformer: DashboardUiDataTransformer,
) : ViewModel() {

    private val _uiState = MutableStateFlow(DashboardScreenState(profile = null, dailySaleState = DailySaleState()))
    val uiState: StateFlow<DashboardScreenState>
        get() = _uiState.asStateFlow()

    init {
        getStoreProfile()
        getProductCategories()
    }

    private fun getStoreProfile() {
        viewModelScope.launch {
            // GetUser profile
            getUserProfileUseCase(GetUserProfileUseCase.Params(storeId)).let { userProfileModel ->
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
            getProductCategoriesUseCase(
                GetProductCategoriesUseCase.Params(storeId)
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
            getDailySalesLedge(GetDailySalesLedgeUseCase.Params(storeId)).let { dailySales ->
                _uiState.update { currentState ->
                    currentState.copy(
                        dailySaleState = transformer.transformDailySales(dailySales)
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
     * View model's factory. This is used by the view model to create instances of itself. This is
     * needed to pass the 'storeId' parameter from the [DashboardActivity] to the view model.
     */
    @AssistedFactory
    interface Factory {
        fun create(storeId: Int): DashboardViewModel
    }
}
