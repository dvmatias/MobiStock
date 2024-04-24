@file:Suppress("UNUSED_PARAMETER")

package com.samuraicmdv.mobistock

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.samuraicmdv.common.theme.MobiStockTheme
import com.samuraicmdv.featurelogin.compose.LoginScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MobiStockTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MobiStockTheme.colors.backgroundPrimary) {
                    LoginScreen {
                        checkCredentialsMock(it)
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

fun checkCredentialsMock(credentials: com.samuraicmdv.featurelogin.compose.Credentials): Boolean {
    return true
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MobiStockTheme {
        Greeting("Android")
    }
}