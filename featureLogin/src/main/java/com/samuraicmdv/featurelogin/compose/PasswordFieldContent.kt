package com.samuraicmdv.featurelogin.compose

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Key
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.samuraicmdv.common.theme.MobiTheme
import com.samuraicmdv.featurelogin.R
import com.samuraicmdv.ui.widget.MobiTextField

@Composable
fun PasswordFieldContent(
    value: String,
    onChange: (String) -> Unit,
    isLoading: Boolean,
    modifier: Modifier = Modifier,
    passwordError: Int? = null,
    placeholder: String = "Enter your password",
) {
    var isPasswordVisible by remember { mutableStateOf(false) }
    val keyboardController = LocalSoftwareKeyboardController.current

    val leadingIcon = @Composable {
        Icon(
            Icons.Default.Key,
            contentDescription = ""
        )
    }
    val trailingIcon = @Composable {
        IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
            Icon(
                if (isPasswordVisible) Icons.Default.VisibilityOff else Icons.Default.Visibility,
                contentDescription = ""
            )
        }
    }

    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Text(
            text = stringResource(id = R.string.label_password_input_field).uppercase(),
            style = MobiTheme.typography.labelSmallBold,
            color = MobiTheme.colors.textSecondary,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(MobiTheme.dimens.dimen_0_5))
        MobiTextField(
            value = value,
            isError = passwordError != null,
            errorMessage = getLoginError(errorCode = passwordError),
            onValueChange = onChange,
            modifier = modifier.fillMaxWidth(),
            enabled = !isLoading,
            leadingIcon = leadingIcon,
            trailingIcon = trailingIcon,
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done,
                keyboardType = KeyboardType.Password
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    keyboardController?.hide()
                }
            ),
            placeholder = { Text(text = placeholder) },
            singleLine = true,
            visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation()
        )
    }
}

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewPasswordFieldContent() {
    MobiTheme {
        Surface {
            PasswordFieldContent(
                value = "Value",
                onChange = { },
                isLoading = false,
                passwordError = null,
                placeholder = "User name or email",
            )
        }
    }
}