package com.samuraicmdv.ui.widget

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.samuraicmdv.common.theme.MobiTheme
import com.samuraicmdv.ui.R
import com.samuraicmdv.ui.util.ThemePreviews

private val searchTextStartPadding = 4.dp

/**
 * TODO work in progress
 */
@Composable
fun CustomSearchComponent(
    hint: String? = null,
    modifier: Modifier = Modifier,
    onSearch: (String) -> Unit
) {
    val focusRequester: FocusRequester = remember { FocusRequester() }
    var isSearchExpandedState by remember { mutableStateOf(false) }
    var searchTextState by remember { mutableStateOf("") }
    val hintDefault = stringResource(R.string.custom_search_component_hint_default)
    val hintState by remember { mutableStateOf(hint ?: hintDefault) }

    Card(
        shape = RoundedCornerShape(MobiTheme.dimens.searchView / 2),
        colors = CardDefaults.cardColors(MobiTheme.colors.surfaceContainer),
        elevation = CardDefaults.cardElevation(MobiTheme.elevations.unit),
        modifier = modifier
            .fillMaxWidth()
            .height(MobiTheme.dimens.searchView)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxSize()
                .clickable(indication = null, interactionSource = null) {
                    isSearchExpandedState = true
                }
                .padding(horizontal = MobiTheme.dimens.dimen_0_5)
        ) {
            if (isSearchExpandedState) {
                IconButton(
                    onClick = { }
                ) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Start Search",
                    )
                }
                Box(
                    contentAlignment = Alignment.CenterStart,
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = searchTextStartPadding)
                ) {
                    BasicTextField(
                        value = searchTextState,
                        onValueChange = {
                            searchTextState = it
                            onSearch(it)
                        },
                        maxLines = 1,
                        singleLine = true,
                        textStyle = TextStyle(fontSize = 16.sp, color = Color.Black),
                        modifier = Modifier
                            .fillMaxWidth()
                            .focusRequester(focusRequester)
                    )
                    if (searchTextState.isEmpty()) {
                        Text(
                            text = hintState,
                            style = MobiTheme.typography.bodyMedium,
                            color = MobiTheme.colors.textDisable
                        )
                    }
                }
                IconButton(
                    onClick = {
                        isSearchExpandedState = false
                        searchTextState = ""
                        onSearch("")
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "Close Search"
                    )
                }

                // Request focus when expanded
                LaunchedEffect(isSearchExpandedState) {
                    if (isSearchExpandedState) {
                        focusRequester.requestFocus()
                    }
                }
            } else {
                IconButton(
                    onClick = {
                        isSearchExpandedState = true
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Start Search",
                        tint = MobiTheme.colors.textDisable
                    )
                }
                if (searchTextState.isEmpty()) {
                    Text(
                        text = hintState,
                        style = MobiTheme.typography.bodyMedium,
                        color = MobiTheme.colors.textPrimary,
                        modifier = Modifier.padding(start = searchTextStartPadding)
                    )
                }
            }
        }
    }
}

@ThemePreviews
@Composable
fun PreviewCustomSearchView(modifier: Modifier = Modifier) {
    MobiTheme {
        CustomSearchComponent(
            hint = "Search here...",
            onSearch = { query ->
                println("Search query: $query") // TODO implement search logic
            }
        )
    }
}