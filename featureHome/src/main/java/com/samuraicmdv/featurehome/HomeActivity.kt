package com.samuraicmdv.featurehome

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
import com.samuraicmdv.common.theme.MobiStockTheme
import com.samuraicmdv.featurehome.compose.HomeScreen
import com.samuraicmdv.featurehome.event.HomeEvent
import com.samuraicmdv.featurehome.event.HomeNavigationEvent
import com.samuraicmdv.featurehome.event.HomePresentationEvent
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeActivity : ComponentActivity() {
    @Inject
    lateinit var navigator: Navigator

    private val storeId: Int
        get() = intent.getIntExtra(BUNDLE_KEY_USER_ID, -1)

    private lateinit var viewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MobiStockTheme {
                viewModel = hiltViewModel(
                    creationCallback = { factory: HomeViewModel.Factory ->
                        factory.create(storeId)
                    }
                )

                val uiState by viewModel.uiState.collectAsState()
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MobiStockTheme.colors.backgroundSecondary
                ) {
                    HomeScreen(
                        uiState = uiState,
                        handleEvent = ::handelEvent
                    )
                }
            }
        }
    }

    private fun handelEvent(event: HomeEvent) {
        when (event) {
            is HomePresentationEvent.HandleUsersBottomSheetState ->
                viewModel.updateUsersBottomSheetState(event.show)

            is HomeNavigationEvent.NavigateProductCategory -> {
                bundleOf(
                    BUNDLE_KEY_STORE_ID to storeId,
                    BUNDLE_KEY_CATEGORY_ID to event.categoryId
                ).also { data ->
                    navigator.toProductCategory(origin = this, data = data, finish = false)
                }
            }
        }
    }
}