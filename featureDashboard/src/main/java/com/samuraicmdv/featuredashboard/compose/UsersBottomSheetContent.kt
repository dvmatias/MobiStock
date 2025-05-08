package com.samuraicmdv.featuredashboard.compose

import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Surface
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import com.samuraicmdv.common.theme.MobiTheme
import com.samuraicmdv.featuredashboard.data.UserUiData
import com.samuraicmdv.featuredashboard.event.DashboardEvent
import com.samuraicmdv.featuredashboard.event.DashboardPresentationEvent
import com.samuraicmdv.ui.util.ThemePreviews

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UsersBottomSheetContent(
    relatedUsers: List<UserUiData>?,
    showUsersBottomSheet: Boolean,
    modifier: Modifier = Modifier,
    handleEvent: (DashboardEvent) -> Unit,
) {
    val modalBottomSheetState = rememberModalBottomSheetState()

    LaunchedEffect(key1 = showUsersBottomSheet) {
        if (showUsersBottomSheet) modalBottomSheetState.show()
        else modalBottomSheetState.hide()

    }

    if (showUsersBottomSheet) {
        ModalBottomSheet(
            onDismissRequest = {
                handleEvent(DashboardPresentationEvent.HandleUsersBottomSheetState(false))
            },
            sheetState = modalBottomSheetState,
            dragHandle = { BottomSheetDefaults.DragHandle() },
            modifier = modifier
        ) {
            UsersBottomSheetList(relatedUsers)
        }
    }
}

@ThemePreviews
@Composable
fun PreviewHomeUsersBottomSheetContent(modifier: Modifier = Modifier) {
    MobiTheme {
        Surface {
            UsersBottomSheetContent(getBottomSheetUsersForPreview(), true) {}
        }
    }
}