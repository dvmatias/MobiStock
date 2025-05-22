package com.samuraicmdv.ui.widget

import androidx.compose.foundation.background
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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.samuraicmdv.common.theme.MobiTheme

/**
 * TODO work in progress
 */
@Composable
fun CustomSearchView(
    hint: String? = "Search",
    modifier: Modifier = Modifier,
    onSearch: (String) -> Unit
) {
    val focusRequester: FocusRequester = remember { FocusRequester() }
    var isSearchExpandedState by remember { mutableStateOf(false) }
    var searchTextState by remember { mutableStateOf("") }
    val hintState by remember { mutableStateOf(hint ?: "Search") }

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(MobiTheme.dimens.searchView)
            .shadow(
                elevation = 1.dp, // Shadow elevation
                shape = RoundedCornerShape(MobiTheme.dimens.searchView / 2), // Rounded corners
                clip = false
            )
            .background(
                color = Color.White,
                shape = RoundedCornerShape(MobiTheme.dimens.searchView / 2)
            )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxSize()
                .clickable(indication = null, interactionSource = null) {
                    isSearchExpandedState = true
                }
                .padding(horizontal = MobiTheme.dimens.dimen_2)
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
                Box(modifier = Modifier.weight(1f)) {
                    BasicTextField(
                        value = searchTextState,
                        onValueChange = {
                            searchTextState = it
                            onSearch(it)
                        },
                        textStyle = TextStyle(fontSize = 16.sp, color = Color.Black),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 8.dp)
                            .focusRequester(focusRequester)
                    )
                    if (searchTextState.isEmpty()) {
                        Text(
                            text = hintState,
                            style = MobiTheme.typography.bodyMedium,
                            color = MobiTheme.colors.textDisable,
                            modifier = Modifier.padding(start = 8.dp)
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
                    Icon(imageVector = Icons.Default.Close, contentDescription = "Close Search")
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
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }
            }
        }
    }
}