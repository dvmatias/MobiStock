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
import com.samuraicmdv.common.theme.MobiStockTheme
import com.samuraicmdv.featurelogin.compose.LoginScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : ComponentActivity() {
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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

    private fun handelEvent(event: PresentationEvent) {
        when (event) {
            is PresentationEvent.Login -> viewModel.doLoginWithCredentials(
                event.username,
                event.password
            )

            is PresentationEvent.SignUp -> {
                Toast.makeText(this, "Not implemented yet!", Toast.LENGTH_SHORT).show()
            }

            is PresentationEvent.ForgotPassword -> {
                Toast.makeText(this, "Not implemented yet!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}