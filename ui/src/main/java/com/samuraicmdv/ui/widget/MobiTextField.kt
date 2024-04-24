package com.samuraicmdv.ui.widget

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.samuraicmdv.common.theme.MobiStockTheme
import com.samuraicmdv.common.theme.NEUTRAL_300
import com.samuraicmdv.common.theme.NEUTRAL_500
import com.samuraicmdv.common.theme.NEUTRAL_600
import com.samuraicmdv.common.theme.NEUTRAL_700
import com.samuraicmdv.common.theme.NEUTRAL_800
import com.samuraicmdv.common.theme.RED_400

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MobiTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    textStyle: TextStyle = LocalTextStyle.current,
    label: @Composable (() -> Unit)? = null,
    placeholder: @Composable (() -> Unit)? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    supportingText: @Composable (() -> Unit)? = null,
    isError: Boolean = false,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    singleLine: Boolean = false,
    maxLines: Int = Int.MAX_VALUE,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    shape: Shape? = null,
    colors: TextFieldColors? = null,
) {
    val updatedTextStyle = textStyle.copy(fontSize = 15.sp)
    val updatedLabel = label.apply { textStyle.copy(fontSize = 15.sp) }
    val updatedShape = shape ?: RoundedCornerShape(MobiStockTheme.spaces.grid_0_5)
    val updatedColors = updateColors(colors)
    val updatedModifier = modifier.height(52.dp)

    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        enabled = enabled,
        readOnly = readOnly,
        textStyle = updatedTextStyle,
        label = updatedLabel,
        placeholder = placeholder,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        supportingText = supportingText,
        isError = isError,
        visualTransformation = visualTransformation,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        singleLine = singleLine,
        maxLines = maxLines,
        interactionSource = interactionSource,
        shape = updatedShape,
        colors = updatedColors,
        modifier = updatedModifier
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MobiTextField(
    value: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    textStyle: TextStyle = LocalTextStyle.current,
    label: @Composable (() -> Unit)? = null,
    placeholder: @Composable (() -> Unit)? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    supportingText: @Composable (() -> Unit)? = null,
    isError: Boolean = false,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    singleLine: Boolean = false,
    maxLines: Int = Int.MAX_VALUE,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    shape: Shape? = null,
    colors: TextFieldColors = TextFieldDefaults.textFieldColors(),
) {
    val updatedShape = shape ?: RoundedCornerShape(MobiStockTheme.spaces.grid_1)

    TextField(
        value = value,
        onValueChange = onValueChange,
        enabled = enabled,
        readOnly = readOnly,
        textStyle = textStyle,
        label = label,
        placeholder = placeholder,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        supportingText = supportingText,
        isError = isError,
        visualTransformation = visualTransformation,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        singleLine = singleLine,
        maxLines = maxLines,
        interactionSource = interactionSource,
        shape = updatedShape,
        colors = colors,
        modifier = modifier
    )
}

@Composable
private fun updateColors(colors: TextFieldColors?): TextFieldColors =
    colors ?: OutlinedTextFieldDefaults.colors(
        focusedTextColor = MobiStockTheme.colors.foregroundPrimary,
        unfocusedTextColor = MobiStockTheme.colors.foregroundPrimary,
        disabledTextColor = MobiStockTheme.colors.foregroundSecondary,
        errorTextColor = MobiStockTheme.colors.foregroundError,
        focusedContainerColor = MobiStockTheme.colors.backgroundSecondary,
        unfocusedContainerColor = MobiStockTheme.colors.backgroundSecondary,
        disabledContainerColor = MobiStockTheme.colors.backgroundTertiary,
        errorContainerColor = MobiStockTheme.colors.backgroundSecondary,
        cursorColor = NEUTRAL_800,
        errorCursorColor = NEUTRAL_800,
        selectionColors = null,
        focusedBorderColor = NEUTRAL_500,
        unfocusedBorderColor = MobiStockTheme.colors.backgroundSecondary,
        disabledBorderColor = NEUTRAL_300,
        errorBorderColor = MobiStockTheme.colors.foregroundError,
        focusedLeadingIconColor = MobiStockTheme.colors.foregroundSecondary,
        unfocusedLeadingIconColor = MobiStockTheme.colors.foregroundSecondary,
        disabledLeadingIconColor = MobiStockTheme.colors.foregroundTertiary,
        errorLeadingIconColor = MobiStockTheme.colors.foregroundError,
        focusedTrailingIconColor = MobiStockTheme.colors.foregroundSecondary,
        unfocusedTrailingIconColor = MobiStockTheme.colors.foregroundSecondary,
        disabledTrailingIconColor = MobiStockTheme.colors.foregroundTertiary,
        errorTrailingIconColor = MobiStockTheme.colors.foregroundSecondary,
        focusedLabelColor = MobiStockTheme.colors.foregroundSecondary,
        unfocusedLabelColor = MobiStockTheme.colors.foregroundSecondary,
        disabledLabelColor = MobiStockTheme.colors.foregroundSecondary,
        errorLabelColor = MobiStockTheme.colors.foregroundSecondary,
        focusedPlaceholderColor = NEUTRAL_600,
        unfocusedPlaceholderColor = NEUTRAL_600,
        disabledPlaceholderColor = NEUTRAL_700,
        errorPlaceholderColor = RED_400,
        focusedSupportingTextColor = Green,
        unfocusedSupportingTextColor = Green,
        disabledSupportingTextColor = Green,
        errorSupportingTextColor = Green,
        focusedPrefixColor = Green,
        unfocusedPrefixColor = Green,
        disabledPrefixColor = Green,
        errorPrefixColor = Green,
        focusedSuffixColor = Green,
        unfocusedSuffixColor = Green,
        disabledSuffixColor = Green,
        errorSuffixColor = Green,
    )

