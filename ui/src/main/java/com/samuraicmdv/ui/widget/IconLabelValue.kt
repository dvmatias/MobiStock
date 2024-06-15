package com.samuraicmdv.ui.widget

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.samuraicmdv.common.theme.MobiTheme
import com.samuraicmdv.ui.util.ThemePreviews

@Composable
fun IconLabelValue(
    label: String?,
    value: String? = null,
    icon: @Composable () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.fillMaxWidth()
    ) {
        icon()
        Spacer(modifier = Modifier.width(MobiTheme.dimens.dimen_0_5))
        LabelValue(
            label = label,
            value = value,
            modifier = Modifier
        )
    }
}

@Composable
fun IconLabelValue(
    label: @Composable () -> Unit?,
    value: @Composable () -> Unit?,
    icon: @Composable () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.fillMaxWidth()
    ) {
        icon()
        Spacer(modifier = Modifier.width(MobiTheme.dimens.dimen_0_5))
        LabelValue(
            label = label,
            value = value,
            modifier = Modifier
        )
    }
}

@ThemePreviews
@Composable
fun PreviewIconLabelValue(
    modifier: Modifier = Modifier
) {
    MobiTheme {
        Surface {
            IconLabelValue(
                label = "Label",
                value = "Value",
                icon = {
                       Icon(
                           imageVector = Icons.Default.Favorite,
                           contentDescription = "Favorite",
                           tint = Color.Red
                       )
                },
                modifier = modifier
            )
        }
    }
}