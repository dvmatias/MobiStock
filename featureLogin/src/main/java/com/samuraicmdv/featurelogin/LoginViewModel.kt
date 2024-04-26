package com.samuraicmdv.featurelogin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.samuraicmdv.domain.model.UserCredentialsModel
import com.samuraicmdv.domain.usecase.LoginWithCredentialsUseCase
import com.samuraicmdv.featurelogin.data.UserCredentialsUiData
import com.samuraicmdv.featurelogin.state.LoginScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginWithCredentialsUseCase: LoginWithCredentialsUseCase,
) : ViewModel() {

    private val _uiState = MutableStateFlow(LoginScreenState(false, "", ""))
    val uiState: StateFlow<LoginScreenState>
        get() = _uiState.asStateFlow()

    fun doLoginWithCredentials(userCredentialsUiData: UserCredentialsUiData) {
        _uiState.value = uiState.value.copy(isLoading = true)
        viewModelScope.launch {
            loginWithCredentialsUseCase(
                LoginWithCredentialsUseCase.Params(
                    UserCredentialsModel(
                        userCredentialsUiData.user,
                        userCredentialsUiData.password
                    )
                )
            ).let {
                _uiState.value = LoginScreenState(isLoading = false, it.userError, it.passwordError)
            }
        }
    }

}