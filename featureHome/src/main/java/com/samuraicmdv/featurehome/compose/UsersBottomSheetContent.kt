package com.samuraicmdv.featurehome.compose

import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Surface
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import com.samuraicmdv.common.theme.MobiStockTheme
import com.samuraicmdv.featurehome.data.UserUiData
import com.samuraicmdv.featurehome.event.HomeEvent
import com.samuraicmdv.featurehome.event.HomePresentationEvent
import com.samuraicmdv.ui.util.ThemePreviews

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UsersBottomSheetContent(
    relatedUsers: List<UserUiData>?,
    showUsersBottomSheet: Boolean,
    modifier: Modifier = Modifier,
    handleEvent: (HomeEvent) -> Unit,
) {
    val modalBottomSheetState = rememberModalBottomSheetState()

    LaunchedEffect(key1 = showUsersBottomSheet) {
        if (showUsersBottomSheet) modalBottomSheetState.show()
        else modalBottomSheetState.hide()

    }

    if (showUsersBottomSheet) {
        ModalBottomSheet(
            onDismissRequest = {
                handleEvent(HomePresentationEvent.HandleUsersBottomSheetState(false))
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
    MobiStockTheme {
        Surface(color = MobiStockTheme.colors.backgroundPrimary) {
            UsersBottomSheetContent(getBottomSheetUsersForPreview(), true) {}
        }
    }
}