package com.samuraicmdv.featurehome

import androidx.lifecycle.ViewModel
import com.samuraicmdv.featurehome.state.HomeScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {

    private val _uiState = MutableStateFlow(HomeScreenState())
    val uiState: StateFlow<HomeScreenState>
        get() = _uiState.asStateFlow()

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