package com.samuraicmdv.featureproductdetails.compose

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.samuraicmdv.common.theme.MobiTheme

@Composable
fun <T> ProductEditDropDownMenu(
    items: List<ItemMenu<T>>,
    modifier: Modifier = Modifier,
    defaultOptionTitle: String? = null,
    selectedIndexDefault: Int? = null,
    onItemSelected: (T) -> Unit
) {
    val options: List<ItemMenu<T>> = items.toMutableList().apply {
        defaultOptionTitle?.let { add(0, ItemMenu(title = it)) }
    }.toList()
    var expanded by remember { mutableStateOf(false) }
    var selectedOption by remember {
        mutableStateOf(options[selectedIndexDefault ?: 0])
    }

    Box(
        modifier = Modifier
            .wrapContentSize(Alignment.TopStart)
            .background(Color.Transparent)
    ) {

        Column(
            modifier = Modifier
                .width(IntrinsicSize.Max)
                .background(Color.Transparent)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = modifier
                    .padding(
                        start = 0.dp,
                        end = 0.dp,
                        top = 0.dp,
                        bottom = MobiTheme.dimens.dimen_0_5,
                    )
                    .clickable { expanded = true }
                    .animateContentSize()

            ) {
                Text(
                    text = selectedOption.title,
                    style = if (selectedOption.item == null) MobiTheme.typography.labelMediumBold else MobiTheme.typography.bodyLarge,
                    color = if (selectedOption.item == null) MobiTheme.colors.primary else MobiTheme.colors.textPrimary,
                )
                Icon(
                    imageVector = Icons.Default.ArrowDropDown,
                    contentDescription = null,
                    tint = MobiTheme.colors.primary,
                    modifier = Modifier.width(MobiTheme.dimens.dimen_3)
                )
            }

            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = Modifier.background(MobiTheme.colors.surface)
            ) {
                options.forEach { option ->
                    DropdownMenuItem(
                        text = {
                            Row {
                                Text(
                                    text = option.title,
                                    style = MobiTheme.typography.bodyLarge,
                                )
                            }
                        },
                        onClick = {
                            if (option.item != null) {
                                selectedOption = option
                                onItemSelected(option.item)
                                expanded = false
                            }
                        }
                    )
                }
            }
            Spacer(
                modifier = Modifier
                    .height(1.dp)
                    .background(MobiTheme.colors.textDisable)
                    .fillMaxWidth()
            )
        }
    }
}