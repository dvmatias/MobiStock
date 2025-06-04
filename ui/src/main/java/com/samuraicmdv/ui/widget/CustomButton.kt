package com.samuraicmdv.ui.widget

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.samuraicmdv.common.theme.MobiTheme
import com.samuraicmdv.ui.R
import com.samuraicmdv.ui.util.ThemePreviews

val mainButtonHeight = 48.dp
val expandPillButtonIconSize = 24.dp

enum class CustomButtonType {
    MAIN_PRIMARY,
    MAIN_SECONDARY,
}

/**
 * This button is the main version of a button in teh application. It can be used as a primary or secondary button.
 *
 * @param label The text to display on the button.
 * @param type The type of the button, which determines its style (primary or secondary).
 * @param onClick The callback function to be invoked when the button is clicked.
 * @param enabled Indicates whether the button is enabled or disabled. Defaults to true.
 * @param modifier The modifier to be applied to the button.
 */
@Composable
fun CustomButton(
    label: String,
    type: CustomButtonType,
    onClick: () -> Unit,
    enabled: Boolean = true,
    modifier: Modifier = Modifier
) {
    when (type) {
        CustomButtonType.MAIN_PRIMARY -> CustomMainButton(
            label = label,
            onClick = onClick,
            type = CustomButtonType.MAIN_PRIMARY,
            enabled = enabled,
            modifier = modifier
        )

        CustomButtonType.MAIN_SECONDARY -> CustomMainButton(
            label = label,
            onClick = onClick,
            type = CustomButtonType.MAIN_SECONDARY,
            enabled = enabled,
            modifier = modifier
        )
    }
}

@Composable
private fun CustomMainButton(
    label: String,
    onClick: () -> Unit,
    type: CustomButtonType,
    enabled: Boolean,
    modifier: Modifier = Modifier
) {
    val border = when (type) {
        CustomButtonType.MAIN_PRIMARY -> null
        CustomButtonType.MAIN_SECONDARY -> {
            if (enabled) {
                BorderStroke(1.dp, MobiTheme.colors.primary)
            } else {
                BorderStroke(1.dp, MobiTheme.colors.textDisable)
            }
        }
    }
    val textColor = when (type) {
        CustomButtonType.MAIN_PRIMARY -> if (enabled) MobiTheme.colors.onPrimary else MobiTheme.colors.textPrimary
        CustomButtonType.MAIN_SECONDARY -> if (enabled) MobiTheme.colors.primary else MobiTheme.colors.textDisable
    }
    val containerColor = when (type) {
        CustomButtonType.MAIN_PRIMARY -> MobiTheme.colors.primary
        CustomButtonType.MAIN_SECONDARY -> MobiTheme.colors.surfaceContainer
    }
    val disabledContainerColor = when (type) {
        CustomButtonType.MAIN_PRIMARY -> MobiTheme.colors.disabledContainerColor
        CustomButtonType.MAIN_SECONDARY -> MobiTheme.colors.surfaceContainer
    }

    Button(
        onClick = {
            onClick()
        },
        enabled = enabled,
        shape = RoundedCornerShape(MobiTheme.dimens.dimen_1_5),
        border = border,
        colors = ButtonColors(
            containerColor = containerColor,
            contentColor = if (type == CustomButtonType.MAIN_SECONDARY) {
                MobiTheme.colors.primary
            } else {
                MobiTheme.colors.onPrimary
            },
            disabledContainerColor = disabledContainerColor,
            disabledContentColor = MobiTheme.colors.primary
        ),
        modifier = modifier.then(
            Modifier
                .fillMaxWidth()
                .height(mainButtonHeight)
        )
    ) {
        Text(
            text = label.uppercase(),
            style = MobiTheme.typography.buttonLabel,
            color = textColor,
        )
    }
}

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
            modifier = Modifier.size(expandPillButtonIconSize)
        )
    }
}

@ThemePreviews
@Composable
fun PreviewCustomMainButton_PrimaryEnabled() {
    MobiTheme {
        Surface {
            CustomButton(
                label = "Primary Enabled Button",
                onClick = {},
                type = CustomButtonType.MAIN_PRIMARY,
                enabled = true
            )
        }
    }
}


@ThemePreviews
@Composable
fun PreviewCustomMainButton_PrimaryDisabled() {
    MobiTheme {
        Surface {
            CustomButton(
                label = "Primary Disabled Button",
                onClick = {},
                enabled = false,
                type = CustomButtonType.MAIN_PRIMARY,
            )
        }
    }
}

@ThemePreviews
@Composable
fun PreviewCustomMainButton_SecondaryEnabled() {
    MobiTheme {
        Surface {
            CustomButton(
                label = "Secondary Enabled Button",
                onClick = {},
                type = CustomButtonType.MAIN_SECONDARY,
                enabled = true,
                modifier = Modifier
            )
        }
    }
}


@ThemePreviews
@Composable
fun PreviewCustomMainButton_SecondaryDisabled() {
    MobiTheme {
        Surface {
            CustomButton(
                label = "Secondary Disabled Button",
                onClick = {},
                enabled = false,
                type = CustomButtonType.MAIN_SECONDARY,
                modifier = Modifier
            )
        }
    }
}

@ThemePreviews
@Composable
fun PreviewCustomExpandPillButton() {
    MobiTheme {
        CustomExpandPillButton(
            isExpanded = false,
            onClick = {}
        )
    }
}