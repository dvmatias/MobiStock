package com.samuraicmdv.featuredashboard.compose.dailysalesledge

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.samuraicmdv.common.theme.MobiTheme
import com.samuraicmdv.featuredashboard.event.DashboardEvent
import com.samuraicmdv.featuredashboard.state.DailySaleUiData
import com.samuraicmdv.ui.util.ThemePreviews
import java.util.Date

@Composable
fun DailySalesLedgeScreen(
    state: DailySaleUiData?,
    callback: (DashboardEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        if (state?.isDailySalesLedgeOpen == true) {
            // Daily sales ledge already open
            DailySalesOpenContent(callback)
        } else {
            // Daily sales ledge not open yet
            DailySalesNotOpenContent(state?.currentDayDate, state?.summary, callback)
        }
    }
}

@ThemePreviews
@Composable
fun PreviewDailySalesLedgeScreen() {
    MobiTheme {
        // A surface container using the 'background' color from the theme
        Surface {
            DailySalesLedgeScreen(
                state = DailySaleUiData(
                    isLoading = false,
                    currentDayDate = Date(),
                    summary = "There are no sales registered today. Please open cash register to start registering sales.",
                    isDailySalesLedgeOpen = false
                ),
                callback = {}
            )
        }
    }
}
