package com.samuraicmdv.ui.widget

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.samuraicmdv.common.theme.MobiTheme
import com.samuraicmdv.ui.R
import com.samuraicmdv.ui.util.ThemePreviews

@Composable
fun LabelValue(
    label: String?,
    value: String?,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        label?.let {
            Text(
                text = stringResource(id = R.string.ui_label_value_label_placeholder, it),
                style = MobiTheme.typography.titleMediumBold,
                modifier = Modifier.then(modifier)
            )
            Spacer(modifier = Modifier.width(MobiTheme.dimens.dimen_0_75))
        }
        value?.let {
            Text(
                text = it,
                style = MobiTheme.typography.bodyMedium,
                modifier = Modifier.then(modifier)
            )
        }
    }
}

@ThemePreviews
@Composable
fun PreviewLabelValue(
    modifier: Modifier = Modifier
) {
    MobiTheme {
        Surface {
            LabelValue(
                label = "Label",
                value = "Value",
                modifier = modifier
            )
        }
    }
}