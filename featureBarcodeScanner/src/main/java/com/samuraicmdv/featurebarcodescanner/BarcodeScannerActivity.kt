package com.samuraicmdv.featurebarcodescanner

import android.media.AudioManager
import android.media.ToneGenerator
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.lifecycleScope
import com.samuraicmdv.common.theme.MobiTheme
import com.samuraicmdv.featurebarcodescanner.compose.BarcodeScannerScreen
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class BarcodeScannerActivity : ComponentActivity() {
    private val viewModel: BarcodeScannerViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        lifecycleScope.launch {
            val toneGenerator = ToneGenerator(AudioManager.STREAM_MUSIC, 100)
            viewModel.scanSuccessEventFlow.collectLatest {
                toneGenerator.startTone(ToneGenerator.TONE_CDMA_PIP, 200)
            }
        }

        setContent {
            MobiTheme {
                val uiData by viewModel.uiData.collectAsState()
                Surface {
                    BarcodeScannerScreen(
                        uiData = uiData,
                        callback = viewModel::handleEvent
                    )
                }
            }
        }
    }
}
