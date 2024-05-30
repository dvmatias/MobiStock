package com.samuraicmdv.featurelogin.compose

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.samuraicmdv.common.theme.MobiTheme
import com.samuraicmdv.featurelogin.R
import com.samuraicmdv.ui.widget.MobiTextField

@Composable
fun UserFieldContent(
    value: String,
    onChange: (String) -> Unit,
    isLoading: Boolean,
    modifier: Modifier = Modifier,
    userError: Int? = null,
    placeholder: String = "Enter your user or email",
) {
    val focusManager = LocalFocusManager.current
    val leadingIcon = @Composable {
        Icon(
            Icons.Default.Person,
            contentDescription = ""
        )
    }
    val trailingIcon = @Composable {
        IconButton(onClick = { onChange("") }) {
            Icon(
                Icons.Default.Close,
                contentDescription = ""
            )
        }
    }

    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Text(
            text = stringResource(id = R.string.label_user_name_input_field).uppercase(),
            style = MobiTheme.typography.labelMediumBlack,
            color = MobiTheme.colors.textSecondary,
            modifier = Modifier.fillMaxWidth(),
        )
        Spacer(modifier = Modifier.height(MobiTheme.dimens.dimen_0_5))
        MobiTextField(
            value = value,
            isError = userError != null,
            errorMessage = GetLoginError(errorCode = userError),
            onValueChange = onChange,
            enabled = !isLoading,
            leadingIcon = leadingIcon,
            trailingIcon = trailingIcon,
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
            keyboardActions = KeyboardActions(
                onNext = { focusManager.moveFocus(FocusDirection.Down) }
            ),
            placeholder = { Text(text = placeholder) },
            singleLine = true,
            visualTransformation = VisualTransformation.None,
            modifier = modifier.fillMaxWidth()
        )
    }
}

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewUserFieldContent() {
    MobiTheme {
        Surface {
            UserFieldContent(
                value = "Value",
                onChange = { },
                isLoading = false,
                userError = null,
                placeholder = "User name or email",
            )
        }
    }
}