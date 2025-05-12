package com.samuraicmdv.featurebarcodescanner

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Surface
import com.samuraicmdv.common.theme.MobiTheme
import com.samuraicmdv.featurebarcodescanner.compose.BarcodeScannerScreen

class BarcodeScannerActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MobiTheme {
                Surface {
                    BarcodeScannerScreen()
                }
            }
        }
    }
}