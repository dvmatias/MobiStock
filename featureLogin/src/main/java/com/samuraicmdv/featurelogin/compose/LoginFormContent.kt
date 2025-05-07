package com.samuraicmdv.featurelogin.compose

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.samuraicmdv.common.ERROR_LOGIN_USER_EMPTY
import com.samuraicmdv.common.theme.MobiTheme
import com.samuraicmdv.featurelogin.event.LoginBusinessEvent
import com.samuraicmdv.featurelogin.event.LoginEvent

@Composable
fun LoginFormContent(
    user: String,
    onUserChange: (String) -> Unit,
    password: String,
    onPasswordChange: (String) -> Unit,
    isLoading: Boolean,
    modifier: Modifier = Modifier,
    userError: Int? = null,
    passwordError: Int? = null,
    handleEvent: (LoginEvent) -> Unit,
) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxWidth()
    ) {
        UserFieldContent(
            value = user,
            onChange = { user -> onUserChange(user) },
            isLoading = isLoading,
            userError = userError,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(MobiTheme.dimens.dimen_2))
        PasswordFieldContent(
            value = password,
            onChange = { password -> onPasswordChange(password) },
            isLoading = isLoading,
            passwordError = passwordError,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(MobiTheme.dimens.dimen_0_75))
        Text(
            "Forgot password?",
            style = MobiTheme.typography.labelMediumBold,
            color = MobiTheme.colors.textLink,
            modifier = Modifier
                .clickable(enabled = !isLoading) { handleEvent(LoginBusinessEvent.ForgotPassword) }
        )
        Spacer(modifier = Modifier.height(MobiTheme.dimens.dimen_4))
        Button(
            onClick = {
                handleEvent(LoginBusinessEvent.Login(user, password))
            },
            enabled = !isLoading,
            shape = RoundedCornerShape(MobiTheme.dimens.dimen_1_5),
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
        ) {
            Text(
                text = "Login".uppercase(),
                style = MobiTheme.typography.buttonLabel
            )
        }
    }
}


@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewLoginFormContent() {
    MobiTheme {
        Surface {
            LoginFormContent(
                user = "user",
                onUserChange = { },
                password = "password",
                onPasswordChange = {},
                isLoading = false,
                userError = null,
                passwordError = null,
            ) {}
        }
    }
}


@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewLoginFormContent_UserError() {
    MobiTheme {
        Surface {
            LoginFormContent(
                user = "user",
                onUserChange = { },
                password = "password",
                onPasswordChange = {},
                isLoading = false,
                userError = ERROR_LOGIN_USER_EMPTY,
                passwordError = null,
            ) {}
        }
    }
}

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewLoginFormContent_PasswordError() {
    MobiTheme {
        Surface {
            LoginFormContent(
                user = "user",
                onUserChange = { },
                password = "password",
                onPasswordChange = {},
                isLoading = false,
                userError = null,
                passwordError = ERROR_LOGIN_USER_EMPTY,
            ) {}
        }
    }
}