package com.samuraicmdv.ui.widget

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.samuraicmdv.common.theme.MobiTheme
import com.samuraicmdv.ui.R

val iconSize = 24.dp

/**
 * A custom expandable pill button that toggles between expanded and collapsed states.
 *
 * @param isExpanded Indicates whether the button is in expanded state.
 * @param onClick Callback function to be invoked when the button is clicked.
 * @param modifier Modifier to be applied to the button.
 */
@Composable
fun CustomExpandPillButton(
    isExpanded: Boolean = false,
    onClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .then(
            Modifier
                .clip(RoundedCornerShape(100))
                .background(MobiTheme.colors.primary)
                .animateContentSize()
                .clickable {
                    onClick()
                }
                .padding(start = MobiTheme.dimens.dimen_2, end = MobiTheme.dimens.dimen_1)
            )
    ) {
        Text(
            text = stringResource(
                id = if (!isExpanded) {
                    R.string.button_expand_all_label
                } else {
                    R.string.button_collapse_all_label
                }
            ).uppercase(),
            style = MobiTheme.typography.labelMediumBold,
            color = MobiTheme.colors.onPrimary,
            modifier = Modifier
        )
        Icon(
            imageVector = Icons.Default.KeyboardArrowDown,
            contentDescription = null,
            tint = MobiTheme.colors.onPrimary,
            modifier = Modifier.size(iconSize)
        )
    }
}