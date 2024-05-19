package com.samuraicmdv.featurelogin.compose

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.samuraicmdv.common.theme.MobiTheme
import com.samuraicmdv.featurelogin.event.LoginEvent
import com.samuraicmdv.featurelogin.state.LoginScreenState
import com.samuraicmdv.ui.widget.LinearLoadingIndicator

@Composable
fun LoginScreen(
    uiState: LoginScreenState,
    modifier: Modifier = Modifier,
    handleEvent: (LoginEvent) -> Unit,
) {
    var user by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }

    Box(
        modifier = modifier
            .fillMaxSize()
            .paint(
                painterResource(id = com.samuraicmdv.featurelogin.R.drawable.login_screen_bgr),
                contentScale = ContentScale.FillHeight,
                colorFilter = ColorFilter.tint(MobiTheme.colors.tertiary),
                alpha = 0.1F
            )
    ) {
        if (uiState.isLoading) {
            LinearLoadingIndicator(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(MobiTheme.dimens.dimen_2)
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = MobiTheme.dimens.dimen_2,
                    vertical = MobiTheme.dimens.dimen_2
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(MobiTheme.dimens.dimen_5))
            Image(
                painterResource(com.samuraicmdv.featurelogin.R.drawable.logo_1),
                contentDescription = "",
                contentScale = ContentScale.Inside,
                modifier = Modifier.size(110.dp)
            )
            LoginGreetingContent()
            LoginFormContent(
                user = user,
                onUserChange = { user = it },
                password = password,
                onPasswordChange = { password = it },
                isLoading = uiState.isLoading,
                modifier = modifier.weight(1F),
                userError = uiState.userError,
                passwordError = uiState.passwordError
            ) { event ->
                handleEvent(event)
            }
            SignUpContent { event ->
                handleEvent(event)
            }
        }
    }
}

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewLoginScreen() {
    MobiTheme {
        Surface {
            LoginScreen(uiState = LoginScreenState(true)) {}
        }
    }
}