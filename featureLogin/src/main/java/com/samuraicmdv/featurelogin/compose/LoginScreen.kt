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
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
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
import com.samuraicmdv.common.theme.MobiStockTheme
import com.samuraicmdv.featurelogin.PresentationEvent
import com.samuraicmdv.featurelogin.state.LoginScreenState

@Composable
fun LoginScreen(
    uiState: LoginScreenState,
    modifier: Modifier = Modifier,
    handleEvent: (PresentationEvent) -> Unit,
) {
    var user by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }

    Box(
        modifier = modifier
            .fillMaxSize()
            .paint(
                painterResource(id = com.samuraicmdv.featurelogin.R.drawable.login_screen_bgr),
                contentScale = ContentScale.FillHeight,
                colorFilter = ColorFilter.tint(MobiStockTheme.colors.backgroundTertiary),
                alpha = 0.3F
            )
    ) {
        if (uiState.isLoading) {
            LinearProgressIndicator(
                modifier = Modifier.fillMaxWidth(),
                color = MaterialTheme.colorScheme.secondary,
                trackColor = MaterialTheme.colorScheme.surfaceVariant,
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = MobiStockTheme.spaces.grid_2,
                    vertical = MobiStockTheme.spaces.grid_2
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(MobiStockTheme.spaces.grid_5))
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
                modifier = modifier.weight(1F)
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
fun LoginScreenPreview() {
    MobiStockTheme {
        Surface(color = MobiStockTheme.colors.backgroundPrimary) {
            LoginScreen(uiState = LoginScreenState(false)) {}
        }
    }
}