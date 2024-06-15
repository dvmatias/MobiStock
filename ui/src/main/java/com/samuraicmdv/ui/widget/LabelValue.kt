package com.samuraicmdv.ui.widget

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import com.samuraicmdv.common.event.Action
import com.samuraicmdv.common.theme.MobiTheme
import com.samuraicmdv.ui.util.ThemePreviews

@Composable
fun LabelValue(
    label: String?,
    value: String?,
    modifier: Modifier = Modifier,
    action: Action? = null,
    valueStyle: TextStyle = MobiTheme.typography.bodyMedium,
    valueColor: Color = MobiTheme.colors.textPrimary
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            label?.let {
                Text(
                    text = label,
                    style = MobiTheme.typography.bodyMediumBold,
                    modifier = Modifier.align(Alignment.Top)
                )
                Spacer(modifier = Modifier.width(MobiTheme.dimens.dimen_0_75))
            }
            value?.let {
                Text(
                    text = it,
                    style = valueStyle,
                    color = valueColor,
                    modifier = Modifier
                        .weight(1F)
                        .align(Alignment.Top)
                )
            }
            action?.let { action ->
                Spacer(modifier = Modifier.width(MobiTheme.dimens.dimen_0_5))
                ActionText(
                    action = Action(
                        name = action.name,
                        label = action.label,
                        handler = action.handler
                    )
                )
            }
        }
    }

}

@Composable
fun LabelValue(
    label: @Composable () -> Unit?,
    value: @Composable () -> Unit?,
    modifier: Modifier = Modifier,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        label.invoke()
        Spacer(modifier = Modifier.width(MobiTheme.dimens.dimen_0_75))
        value.invoke()
    }
}

@ThemePreviews
@Composable
fun PreviewLabelValue(
    modifier: Modifier = Modifier
) {
    MobiTheme {
        Surface {
            Column(
                verticalArrangement = androidx.compose.foundation.layout.Arrangement.spacedBy(MobiTheme.dimens.dimen_2)
            ) {
                LabelValue(
                    label = "Label",
                    value = "Value",
                    action = Action(
                        name = "Action",
                        label = "Action",
                        handler = {}
                    ),
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(horizontal = MobiTheme.dimens.dimen_2)
                )
                LabelValue(
                    label = "Label",
                    value = "Lorem ipsum dolor sato sit amet. Lorem ipsum dolor sato sit amet. Lorem ipsum dolor sato sit amet. Lorem ipsum dolor sato sit amet. Lorem ipsum dolor sato sit amet. Lorem ipsum dolor sato sit amet. ",
                    action = Action(
                        name = "Action",
                        label = "Action",
                        handler = {}
                    ),
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(horizontal = MobiTheme.dimens.dimen_2)
                )

                LabelValue(
                    label = { Text(text = "Composable label") },
                    value = { Text(text = "Composable value") },
                    modifier = modifier.fillMaxWidth()
                )
            }
        }
    }
}