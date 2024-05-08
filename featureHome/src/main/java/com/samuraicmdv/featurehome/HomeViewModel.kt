package com.samuraicmdv.featurehome

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.samuraicmdv.domain.usecase.GetUserProfileUseCase
import com.samuraicmdv.featurehome.data.UserUiData
import com.samuraicmdv.featurehome.state.HomeScreenState
import com.samuraicmdv.featurehome.transformer.HomeUiDataTransformer
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getUserProfileUseCase: GetUserProfileUseCase,
    private val transformer: HomeUiDataTransformer
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeScreenState(profile = null))
    val uiState: StateFlow<HomeScreenState>
        get() = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            GetUserProfileUseCase.Params(1).run {
                getUserProfileUseCase(this).let { userProfileModel ->
                    _uiState.update { currentState ->
                        currentState.copy(
                            profile = transformer.transformUserProfile(userProfileModel)
                        )
                    }
                }
            }
        }
    }

    /**
     * Updates the state for the users bottom sheet.
     *
     * @param show Value to be set on [HomeScreenState.isUsersBottomSheetDisplayed]. If 'true' the
     * users bottom sheet should be displayed, if 'false' it should be hidden.
     */
    fun updateUsersBottomSheetState(show: Boolean) {
        _uiState.update { currentState ->
            currentState.copy(isUsersBottomSheetDisplayed = show)
        }
    }
}