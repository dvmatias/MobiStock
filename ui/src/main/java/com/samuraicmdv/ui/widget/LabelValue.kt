package com.samuraicmdv.ui.widget

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import com.samuraicmdv.common.theme.MobiTheme
import com.samuraicmdv.ui.R
import com.samuraicmdv.ui.util.ThemePreviews

@Composable
fun LabelValue(
    label: String?,
    value: String?,
    modifier: Modifier = Modifier,
    valueStyle: TextStyle = MobiTheme.typography.bodyMedium,
    valueColor: Color = MobiTheme.colors.textPrimary
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        label?.let {
            val labelString =
                if (value != null) stringResource(id = R.string.ui_label_value_label_placeholder, it) else it
            Text(
                text = labelString,
                style = MobiTheme.typography.titleSmallBold,
                modifier = Modifier.then(modifier)
            )
            Spacer(modifier = Modifier.width(MobiTheme.dimens.dimen_0_75))
        }
        value?.let {
            Text(
                text = it,
                style = valueStyle,
                modifier = Modifier.then(modifier),
                color = valueColor
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