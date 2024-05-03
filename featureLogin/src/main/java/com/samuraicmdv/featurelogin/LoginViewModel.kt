package com.samuraicmdv.featurelogin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.samuraicmdv.common.ERROR_LOGIN_INCORRECT_PASSWORD
import com.samuraicmdv.common.ERROR_LOGIN_PASSWORD_EMPTY
import com.samuraicmdv.common.ERROR_LOGIN_USER_EMPTY
import com.samuraicmdv.common.ERROR_LOGIN_USER_NOT_FOUND
import com.samuraicmdv.domain.usecase.LoginWithCredentialsUseCase
import com.samuraicmdv.featurelogin.event.LoginNavigationEvent
import com.samuraicmdv.featurelogin.state.LoginScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginWithCredentialsUseCase: LoginWithCredentialsUseCase,
) : ViewModel() {

    private val _uiState = MutableStateFlow(LoginScreenState(false, null, null))
    val uiState: StateFlow<LoginScreenState>
        get() = _uiState.asStateFlow()

    private val _Login_navigationEvent = MutableStateFlow<LoginNavigationEvent?>(null)
    val loginNavigationEvent: StateFlow<LoginNavigationEvent?>
        get() = _Login_navigationEvent

    fun doLoginWithCredentials(username: String, password: String) {
        _uiState.value = uiState.value.copy(isLoading = true)
        viewModelScope.launch {
            loginWithCredentialsUseCase(
                LoginWithCredentialsUseCase.Params(username, password)
            ).let { loginResponseModel ->
                when (loginResponseModel.hasErrors) {
                    false -> {
                        _uiState.update { currentState ->
                            currentState.copy(
                                isLoading = false,
                                userError = null,
                                passwordError = null
                            )
                        }
                        _Login_navigationEvent.value = LoginNavigationEvent.NavigateHome(1) // TODO need the real userId
                    }

                    true -> {
                        _uiState.update { currentState ->
                            currentState.copy(
                                isLoading = false,
                                userError = loginResponseModel.errors?.firstOrNull {
                                    it.code == ERROR_LOGIN_USER_EMPTY || it.code == ERROR_LOGIN_USER_NOT_FOUND
                                }?.code,
                                passwordError = loginResponseModel.errors?.firstOrNull {
                                    it.code == ERROR_LOGIN_INCORRECT_PASSWORD || it.code == ERROR_LOGIN_PASSWORD_EMPTY
                                }?.code
                            )
                        }
                    }
                }
            }
        }
    }
}