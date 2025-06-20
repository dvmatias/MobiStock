package com.samuraicmdv.featurebarcodescanner

import android.media.AudioManager
import android.media.ToneGenerator
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.OnBackPressedCallback
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Surface
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.samuraicmdv.common.BUNDLE_KEY_STORE_ID
import com.samuraicmdv.common.theme.MobiTheme
import com.samuraicmdv.featurebarcodescanner.compose.BarcodeScannerScreen
import com.samuraicmdv.featurebarcodescanner.event.BarcodeScannerEvent
import com.samuraicmdv.featurebarcodescanner.event.BarcodeScannerPresentationEvent
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class BarcodeScannerActivity : ComponentActivity() {
    private lateinit var viewModel: BarcodeScannerViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            // Initialize the ViewModel with the store ID from the intent extras
            viewModel = hiltViewModel(
                creationCallback = { factory: BarcodeScannerViewModel.Factory ->
                    val storeId = intent.getIntExtra(BUNDLE_KEY_STORE_ID, -1)
                    factory.create(storeId)
                }
            )

            // Play a tone when a barcode is successfully scanned
            val toneGenerator = ToneGenerator(AudioManager.STREAM_MUSIC, 100)
            LaunchedEffect(key1 = viewModel) {
                viewModel.scanSuccessEventFlow.collectLatest {
                    toneGenerator.startTone(ToneGenerator.TONE_CDMA_PIP, 200)
                }
            }


            // Register on back pressed callback
            onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    if (viewModel.shouldDismissBottomSheet()) {
                        // Dismiss the bottom sheet
                        viewModel.dismissBottomSheet()
                    } else {
                        // Finish the activity
                        finish()
                    }
                }
            })

            MobiTheme {
                val uiData by viewModel.uiData.collectAsState()
                Surface {
                    BarcodeScannerScreen(
                        uiData = uiData,
                        handleEvent = ::handleEvent
                    )
                }
            }
        }
    }

    /**
     * Handles events emitted from the BarcodeScannerScreen.
     *
     * @param event The event to handle.
     */
    private fun handleEvent(event: BarcodeScannerEvent) {
        when (event) {
            // Barcode scanned successfully
            is BarcodeScannerPresentationEvent.OnBarcodeScanned -> viewModel.onBarcodeScanned(event)
            // After a barcode is scanned, the scanner lost the code and it is ready to scan again
            is BarcodeScannerPresentationEvent.OnBarcodeLost -> viewModel.onBarcodeLost()
            // Exit the scanner screen
            is BarcodeScannerPresentationEvent.ExitScreen -> finish()
            // Dismiss the bottom sheet
            is BarcodeScannerPresentationEvent.OnBottomSheetDismissed -> viewModel.dismissBottomSheet()
        }
    }
}
