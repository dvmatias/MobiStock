package com.samuraicmdv.featureproductdetails.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.text.withStyle
import com.samuraicmdv.common.SPACE_STRING
import com.samuraicmdv.common.theme.MobiTheme
import com.samuraicmdv.featureproductdetails.R
import com.samuraicmdv.ui.util.ThemePreviews
import com.samuraicmdv.ui.widget.MobiTextField

@Composable
fun ProductDetailsScreenContentEditGeneralSection(
    focusManager: FocusManager,
    name: String,
    onNameChange: (String) -> Unit,
    model: String,
    onModelChange: (String) -> Unit,
    code: String,
    onCodeChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = stringResource(id = R.string.title_general).uppercase(),
            style = MobiTheme.typography.titleSmallBold,
        )

        Spacer(modifier = Modifier.height(MobiTheme.dimens.dimen_2))

        // Name
        MobiTextField(
            value = name,
            onValueChange = {
                onNameChange(it)
            },
            mobiLabel = {
                Text(
                    text = buildAnnotatedString {
                        append(stringResource(id = R.string.field_label_name))
                        withStyle(style = SpanStyle(MobiTheme.colors.error)) {
                            append(SPACE_STRING)
                            append(stringResource(id = R.string.mandatory_field_indicator))
                        }
                    }.toUpperCase(),
                    style = MobiTheme.typography.labelMediumBold,
                )
            },
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
            keyboardActions = KeyboardActions(
                onNext = { focusManager.moveFocus(FocusDirection.Down) }
            ),
            placeholder = {
                Text(
                    text = stringResource(id = R.string.field_placeholder_name),
                    style = MobiTheme.typography.bodyLarge,
                    color = MobiTheme.colors.textSecondary
                )
            },
            singleLine = true,
            supportingText = {
                Text(text = stringResource(id = R.string.field_supporting_text_name))
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(MobiTheme.dimens.dimen_3))

        // Model
        MobiTextField(
            value = model,
            onValueChange = {
                onModelChange(it)
            },
            mobiLabel = {
                Text(
                    text = stringResource(id = R.string.field_label_model).uppercase(),
                    style = MobiTheme.typography.labelMediumBold,
                )
            },
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
            keyboardActions = KeyboardActions(
                onNext = { focusManager.moveFocus(FocusDirection.Down) }
            ),
            placeholder = {
                Text(
                    text = stringResource(id = R.string.field_placeholder_model),
                    style = MobiTheme.typography.bodyLarge,
                    color = MobiTheme.colors.textSecondary
                )
            },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(MobiTheme.dimens.dimen_3))

        // Code
        MobiTextField(
            value = code,
            onValueChange = {
                onCodeChange(it)
            },
            mobiLabel = {
                Text(
                    text = stringResource(id = R.string.field_label_code).uppercase(),
                    style = MobiTheme.typography.labelMediumBold,
                )
            },
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
            keyboardActions = KeyboardActions(
                onNext = { focusManager.moveFocus(FocusDirection.Down) }
            ),
            placeholder = {
                Text(
                    text = stringResource(id = R.string.field_placeholder_code),
                    style = MobiTheme.typography.bodyLarge,
                    color = MobiTheme.colors.textSecondary
                )
            },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@ThemePreviews
@Composable
fun PreviewProductDetailsScreenContentEditGeneralSection() {
    MobiTheme {
        Surface {
            ProductDetailsScreenContentEditGeneralSection(
                focusManager = LocalFocusManager.current,
                name = "Product Name",
                onNameChange = {},
                model = "Product Model",
                onModelChange = {},
                code = "Product Code",
                onCodeChange = {}
            )
        }
    }
}