package com.samuraicmdv.featurebarcodescanner

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Surface
import com.samuraicmdv.common.theme.MobiTheme
import com.samuraicmdv.featurebarcodescanner.compose.BarcodeScannerScreen
import com.samuraicmdv.featurebarcodescanner.event.BarcodeScannerEvent
import com.samuraicmdv.featurebarcodescanner.event.BarcodeScannerPresentationEvent

class BarcodeScannerActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MobiTheme {
                Surface {
                    BarcodeScannerScreen(callback = ::handelEvent)
                }
            }
        }
    }

    private fun handelEvent(event: BarcodeScannerEvent) {
        when (event) {
            is BarcodeScannerPresentationEvent.OnBarcodeScanned -> {
                // TODO tke action over the scanned barcode
                Log.e("MAti test", "Barcode scanned: ${event.barcode}")
            }
        }
    }
}