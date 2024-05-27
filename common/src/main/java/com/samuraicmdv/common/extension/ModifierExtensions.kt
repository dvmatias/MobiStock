package com.samuraicmdv.common.extension

import androidx.compose.foundation.shape.GenericShape
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.Dp

fun Modifier.bottomShadow(shadowSize: Dp) =
    this
        .clip(GenericShape { size, _ ->
            lineTo(size.width, 0f)
            lineTo(size.width, Float.MAX_VALUE)
            lineTo(0f, Float.MAX_VALUE)
        })
        .shadow(shadowSize)