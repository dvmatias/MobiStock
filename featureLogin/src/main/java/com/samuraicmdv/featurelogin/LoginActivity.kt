package com.samuraicmdv.featurelogin

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.lifecycleScope
import com.samuraicmdv.common.navigation.Navigator
import com.samuraicmdv.common.theme.MobiStockTheme
import com.samuraicmdv.featurelogin.compose.LoginScreen
import com.samuraicmdv.featurelogin.event.LoginEvent
import com.samuraicmdv.featurelogin.event.LoginNavigationEvent
import com.samuraicmdv.featurelogin.event.LoginBusinessEvent
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class LoginActivity : ComponentActivity() {
    private val viewModel: LoginViewModel by viewModels()

    @Inject
    lateinit var navigator: Navigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleScope.launch {
            viewModel.loginNavigationEvent.collect { navigationEvent ->
                navigationEvent?.let { handelEvent(it) }
            }
        }
        setContent {
            MobiStockTheme {
                val uiState by viewModel.uiState.collectAsState()
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MobiStockTheme.colors.backgroundPrimary
                ) {
                    LoginScreen(uiState) { event ->
                        handelEvent(event)
                    }
                }
            }
        }
    }

    private fun handelEvent(event: LoginEvent) {
        when (event) {
            is LoginBusinessEvent.Login -> viewModel.doLoginWithCredentials(
                event.username,
                event.password
            )

            is LoginBusinessEvent.SignUp -> {
                Toast.makeText(this, "Not implemented yet!", Toast.LENGTH_SHORT).show()
            }

            is LoginBusinessEvent.ForgotPassword -> {
                Toast.makeText(this, "Not implemented yet!", Toast.LENGTH_SHORT).show()
            }

            is LoginNavigationEvent.NavigateHome -> {
                navigator.toHome(origin = this, data = null, finish = true)
            }
        }
    }
}