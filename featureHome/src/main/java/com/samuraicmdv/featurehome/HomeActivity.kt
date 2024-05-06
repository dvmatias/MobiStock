package com.samuraicmdv.featurehome

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.samuraicmdv.common.theme.MobiStockTheme
import com.samuraicmdv.featurehome.compose.HomeScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : ComponentActivity() {
    private val viewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MobiStockTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MobiStockTheme.colors.backgroundSecondary
                ) {
                    HomeScreen()
                }
            }
                    HomeScreen(
                        uiState = uiState,
                        handleEvent = ::handelEvent
                    )
                }
            }
        }
    }
        }
    }
}