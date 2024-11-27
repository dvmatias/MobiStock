package com.samuraicmdv.ui.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import com.samuraicmdv.common.event.Action
import com.samuraicmdv.common.theme.MobiTheme

@Composable
fun ActionText(
    action: Action,
    modifier: Modifier = Modifier
) {
    val style = MobiTheme.typography.bodySmallBold
    val color = MobiTheme.colors.textAccent

    val updatedModifier = modifier
        .then(
            Modifier
                .clip(RoundedCornerShape(percent = 50))
                .clickable {
                    action.handler.invoke(Unit)
                }
                .background(MobiTheme.colors.secondaryContainer.copy(alpha = 0.2F))
                .padding(vertical = MobiTheme.dimens.dimen_0_5, horizontal = MobiTheme.dimens.dimen_1_5)
        )

    Text(
        text = action.label,
        style = style,
        color = color,
        modifier = updatedModifier
    )
}

// TODO preview