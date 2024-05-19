package com.samuraicmdv.ui.widget

import android.content.res.Configuration
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.samuraicmdv.common.theme.MobiTheme
import com.samuraicmdv.common.theme.NEUTRAL_300
import com.samuraicmdv.common.theme.NEUTRAL_500
import com.samuraicmdv.common.theme.NEUTRAL_800
import com.samuraicmdv.common.theme.RED_400

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
    errorMessage: String? = null,
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
    val updatedShape = shape ?: RoundedCornerShape(MobiTheme.dimens.dimen_0_5)
    val updatedColors = updateColors(colors)
    val updatedModifier = modifier.height(52.dp)

    Column {
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
        if (isError) {
            errorMessage?.let {
                Text(
                    text = it,
                    color = MobiTheme.colors.error,
                    textAlign = TextAlign.End,
                    maxLines = 2,
                    style = MobiTheme.typography.labelSmallBold,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = MobiTheme.dimens.unit)
                )
            }
        }
    }
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
    error: String? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    singleLine: Boolean = false,
    maxLines: Int = Int.MAX_VALUE,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    shape: Shape? = null,
    colors: TextFieldColors = TextFieldDefaults.textFieldColors(),
) {
    val updatedShape = shape ?: RoundedCornerShape(MobiTheme.dimens.dimen_1)

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
        cursorColor = NEUTRAL_800,
        disabledBorderColor = NEUTRAL_300,
        disabledContainerColor = MobiTheme.colors.disabledContainerColor,
        disabledLabelColor = MobiTheme.colors.textDisable,
        disabledLeadingIconColor = MobiTheme.colors.textDisable,
        disabledPlaceholderColor = Green,
        disabledPrefixColor = Green,
        disabledSuffixColor = Green,
        disabledSupportingTextColor = Green,
        disabledTextColor = MobiTheme.colors.textDisable,
        disabledTrailingIconColor = MobiTheme.colors.textDisable,
        errorBorderColor = MobiTheme.colors.error,
        errorContainerColor = MobiTheme.colors.errorContainer,
        errorCursorColor = MobiTheme.colors.error,
        errorLabelColor = MobiTheme.colors.error,
        errorLeadingIconColor = MobiTheme.colors.error,
        errorPlaceholderColor = MobiTheme.colors.error,
        errorPrefixColor = MobiTheme.colors.error,
        errorSuffixColor = MobiTheme.colors.error,
        errorSupportingTextColor = MobiTheme.colors.error,
        errorTextColor = MobiTheme.colors.error,
        errorTrailingIconColor = MobiTheme.colors.error,
        focusedBorderColor = MobiTheme.colors.secondary,
        focusedContainerColor = MobiTheme.colors.secondaryContainer,
        focusedLabelColor = MobiTheme.colors.onSecondaryContainer,
        focusedLeadingIconColor = MobiTheme.colors.onSecondaryContainer,
        focusedPlaceholderColor = Green,
        focusedPrefixColor = Green,
        focusedSuffixColor = Green,
        focusedSupportingTextColor = Green,
        focusedTextColor = MobiTheme.colors.onPrimary,
        focusedTrailingIconColor = MobiTheme.colors.onSecondary,
        selectionColors = null,
        unfocusedBorderColor = MobiTheme.colors.secondary,
        unfocusedContainerColor = MobiTheme.colors.secondaryContainer,
        unfocusedLabelColor = MobiTheme.colors.onSecondaryContainer,
        unfocusedLeadingIconColor = MobiTheme.colors.onSecondaryContainer,
        unfocusedPlaceholderColor = Green,
        unfocusedPrefixColor = Green,
        unfocusedSuffixColor = Green,
        unfocusedSupportingTextColor = Green,
        unfocusedTextColor = MobiTheme.colors.onSecondaryContainer,
        unfocusedTrailingIconColor = MobiTheme.colors.onSecondaryContainer,
    )

@Preview()
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewMobiTextField() {
    MobiTheme {
        Surface(
            color = MobiTheme.colors.surface
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(MobiTheme.dimens.dimen_2),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = MobiTheme.dimens.dimen_1,
                        vertical = MobiTheme.dimens.dimen_1
                    )
            ) {
                val value = "value"
                val error = "error"
                val placeHolder = "placeholder"

                MobiTextField(
                    value = "",
                    isError = false,
                    errorMessage = error,
                    onValueChange = {},
                    enabled = true,
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                    placeholder = { Text(placeHolder) },
                    singleLine = true,
                    visualTransformation = VisualTransformation.None,
                    modifier = Modifier.fillMaxWidth()
                )

                MobiTextField(
                    value = "",
                    isError = error.isNotEmpty(),
                    errorMessage = error,
                    onValueChange = {},
                    enabled = true,
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                    placeholder = { Text(placeHolder) },
                    singleLine = true,
                    visualTransformation = VisualTransformation.None,
                    modifier = Modifier.fillMaxWidth()
                )


                MobiTextField(
                    value = value,
                    isError = false,
                    onValueChange = {},
                    enabled = true,
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                    placeholder = { Text(placeHolder) },
                    singleLine = true,
                    visualTransformation = VisualTransformation.None,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}