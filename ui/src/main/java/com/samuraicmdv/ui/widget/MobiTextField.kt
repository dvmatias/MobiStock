package com.samuraicmdv.ui.widget

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.samuraicmdv.common.theme.MobiTheme
import com.samuraicmdv.ui.util.ThemePreviews

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MobiTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    mobiLabel: @Composable (() -> Unit)? = null,
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
    prefix: @Composable (() -> Unit)? = null,
    suffix: @Composable (() -> Unit)? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    singleLine: Boolean = false,
    maxLines: Int = if (singleLine) 1 else Int.MAX_VALUE,
    minLines: Int = 1,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    shape: Shape? = null,
    colors: TextFieldColors? = null,
) {
    val updatedTextStyle = MobiTheme.typography.bodyLarge.copy(
        color =
        when {
            isError -> MobiTheme.colors.error
            !enabled -> MobiTheme.colors.textDisable
            enabled -> MobiTheme.colors.textPrimary
            else -> MobiTheme.colors.textPrimary
        }
    )
    /* val updatedLabel = label.apply { textStyle.copy(fontSize = 15.sp) }*/
    val updatedShape = shape ?: RoundedCornerShape(MobiTheme.dimens.dimen_1)
    val updatedColors = updateColors(colors)

    Column {
        mobiLabel?.invoke()

        CompositionLocalProvider(LocalTextStyle provides updatedTextStyle) {
            BasicTextField(
                value = value,
                modifier = modifier.heightIn(40.dp),
                onValueChange = onValueChange,
                enabled = enabled,
                readOnly = readOnly,
                textStyle = updatedTextStyle,
                cursorBrush = SolidColor(MobiTheme.colors.primary),
                visualTransformation = visualTransformation,
                keyboardOptions = keyboardOptions,
                keyboardActions = keyboardActions,
                interactionSource = interactionSource,
                singleLine = singleLine,
                maxLines = maxLines,
                minLines = minLines,
                decorationBox = @Composable { innerTextField ->
                    // places leading icon, text field with label and placeholder, trailing icon
                    TextFieldDefaults.DecorationBox(
                        value = value,
                        visualTransformation = visualTransformation,
                        innerTextField = innerTextField,
                        placeholder = placeholder,
                        label = label,
                        leadingIcon = leadingIcon,
                        trailingIcon = trailingIcon,
                        prefix = prefix,
                        suffix = suffix,
                        supportingText = supportingText,
                        shape = updatedShape,
                        singleLine = singleLine,
                        enabled = enabled,
                        isError = isError,
                        interactionSource = interactionSource,
                        colors = updatedColors,
                        contentPadding = PaddingValues(start = 0.dp, end = 0.dp, top = 8.dp, bottom = 8.dp)
                    )
                }
            )
        }
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

@Composable
private fun updateColors(colors: TextFieldColors?): TextFieldColors =
    colors ?: OutlinedTextFieldDefaults.colors(
        cursorColor = MobiTheme.colors.onDisabledContainerColor,
        disabledBorderColor = MobiTheme.colors.disabledContainerColor,
        disabledContainerColor = MobiTheme.colors.background,
        disabledLabelColor = MobiTheme.colors.textDisable,
        disabledLeadingIconColor = MobiTheme.colors.textDisable,
        disabledPlaceholderColor = Green,
        disabledPrefixColor = Green,
        disabledSuffixColor = Green,
        disabledSupportingTextColor = Green,
        disabledTextColor = MobiTheme.colors.textDisable,
        disabledTrailingIconColor = MobiTheme.colors.textDisable,
        errorBorderColor = MobiTheme.colors.error,
        errorContainerColor = MobiTheme.colors.background,
        errorCursorColor = MobiTheme.colors.error,
        errorLabelColor = MobiTheme.colors.error,
        errorLeadingIconColor = MobiTheme.colors.error,
        errorPlaceholderColor = MobiTheme.colors.error,
        errorPrefixColor = MobiTheme.colors.error,
        errorSuffixColor = MobiTheme.colors.error,
        errorSupportingTextColor = MobiTheme.colors.error,
        errorTextColor = MobiTheme.colors.error,
        errorTrailingIconColor = MobiTheme.colors.error,
        focusedBorderColor = MobiTheme.colors.primary,
        focusedContainerColor = MobiTheme.colors.background,
        focusedLabelColor = MobiTheme.colors.onSecondaryContainer,
        focusedLeadingIconColor = MobiTheme.colors.onSecondaryContainer,
        focusedPlaceholderColor = Green,
        focusedPrefixColor = Green,
        focusedSuffixColor = Green,
        focusedSupportingTextColor = Green,
        focusedTextColor = MobiTheme.colors.onPrimary,
        focusedTrailingIconColor = MobiTheme.colors.onSecondary,
        selectionColors = null,
        unfocusedBorderColor = MobiTheme.colors.textSecondary,
        unfocusedContainerColor = MobiTheme.colors.background,
        unfocusedLabelColor = MobiTheme.colors.onSecondaryContainer,
        unfocusedLeadingIconColor = MobiTheme.colors.onSecondaryContainer,
        unfocusedPlaceholderColor = Green,
        unfocusedPrefixColor = Green,
        unfocusedSuffixColor = Green,
        unfocusedSupportingTextColor = Green,
        unfocusedTextColor = MobiTheme.colors.onSecondaryContainer,
        unfocusedTrailingIconColor = MobiTheme.colors.onSecondaryContainer,
    )

@ThemePreviews
@Composable
fun PreviewMobiTextField() {
    MobiTheme {
        Surface(
            color = MobiTheme.colors.background
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(MobiTheme.dimens.dimen_1),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = MobiTheme.dimens.dimen_1,
                        vertical = MobiTheme.dimens.dimen_1
                    )
            ) {
                val value = "Value tesgjy"
                val error = "error"

                MobiTextField(
                    value = "",
                    label = { Text(text = "Label") },
                    isError = false,
                    supportingText = { Text(text = "Supporting text") },
                    errorMessage = error,
                    onValueChange = {},
                    enabled = true,
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                    placeholder = { Text(text = "Placeholder text") },
                    singleLine = true,
                    visualTransformation = VisualTransformation.None,
                    modifier = Modifier.fillMaxWidth()
                )

                MobiTextField(
                    value = "Some worong input",
                    isError = error.isNotEmpty(),
                    errorMessage = error,
                    onValueChange = {},
                    enabled = true,
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                    placeholder = { Text(text = "Placeholder text") },
                    singleLine = true,
                    visualTransformation = VisualTransformation.None,
                    modifier = Modifier.fillMaxWidth()
                )


                MobiTextField(
                    value = "",
                    isError = false,
                    onValueChange = {},
                    enabled = true,
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                    placeholder = { Text(text = "Placeholder text") },
                    singleLine = true,
                    visualTransformation = VisualTransformation.None,
                    modifier = Modifier.fillMaxWidth()
                )


                MobiTextField(
                    value = value,
                    isError = false,
                    onValueChange = {},
                    enabled = false,
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                    placeholder = { Text(text = "Placeholder text") },
                    singleLine = true,
                    visualTransformation = VisualTransformation.None,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}