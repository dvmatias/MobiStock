package com.samuraicmdv.featuredashboard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.core.os.bundleOf
import androidx.hilt.navigation.compose.hiltViewModel
import com.samuraicmdv.common.BUNDLE_KEY_CATEGORY_ID
import com.samuraicmdv.common.BUNDLE_KEY_STORE_ID
import com.samuraicmdv.common.BUNDLE_KEY_USER_ID
import com.samuraicmdv.common.navigation.Navigator
import com.samuraicmdv.common.theme.MobiTheme
import com.samuraicmdv.featuredashboard.compose.DashboardScreen
import com.samuraicmdv.featuredashboard.event.DashboardEvent
import com.samuraicmdv.featuredashboard.event.DashboardNavigationEvent
import com.samuraicmdv.featuredashboard.event.DashboardPresentationEvent
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class DashboardActivity : ComponentActivity() {
    @Inject
    lateinit var navigator: Navigator

    private val storeId: Int
        get() = intent.getIntExtra(BUNDLE_KEY_USER_ID, -1)

    private lateinit var viewModel: DashboardViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MobiTheme {
                viewModel = hiltViewModel(
                    creationCallback = { factory: DashboardViewModel.Factory ->
                        factory.create(storeId)
                    }
                )

                val uiState by viewModel.uiState.collectAsState()
                Surface(modifier = Modifier.fillMaxSize()) {
                    DashboardScreen(
                        uiState = uiState,
                        callback = ::handelEvent
                    )
                }
            }
        }
    }

    private fun handelEvent(event: DashboardEvent) {
        when (event) {
            is DashboardPresentationEvent.HandleUsersBottomSheetState ->
                viewModel.updateUsersBottomSheetState(event.show)

            is DashboardNavigationEvent.NavigateProductCategory -> {
                bundleOf(
                    BUNDLE_KEY_STORE_ID to storeId,
                    BUNDLE_KEY_CATEGORY_ID to event.categoryId
                ).also { data ->
                    navigator.toProductCategory(origin = this, data = data, finish = false)
                }
            }

            is DashboardNavigationEvent.NavigateBarcodeScanner -> {
                navigator.toBarcodeScanner(origin = this, finish = false)
            }
        }
    }
}