package com.samuraicmdv.featurelogin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.samuraicmdv.common.theme.MobiStockTheme
import com.samuraicmdv.featurelogin.compose.LoginScreen

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MobiStockTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MobiStockTheme.colors.backgroundPrimary
                ) {
                    LoginScreen()
                }
            }
        }
    }
}