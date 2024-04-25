package com.samuraicmdv.featurelogin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.samuraicmdv.common.theme.MobiStockTheme
import com.samuraicmdv.featurelogin.compose.LoginScreen
import com.samuraicmdv.featurelogin.compose.LoginViewModel
import com.samuraicmdv.featurelogin.compose.PresentationEvent
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : ComponentActivity() {
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MobiStockTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MobiStockTheme.colors.backgroundPrimary
                ) {
                    LoginScreen(handleEvent = ::handelEvent)
                }
            }
        }
    }

    private fun handelEvent(event: PresentationEvent) {
        when (event) {
            PresentationEvent.Login -> viewModel.doLogin()
            else -> {}
        }
    }
}