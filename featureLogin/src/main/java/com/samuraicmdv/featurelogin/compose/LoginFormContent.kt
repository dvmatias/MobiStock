package com.samuraicmdv.featurelogin.compose

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.samuraicmdv.common.theme.MobiStockTheme
import com.samuraicmdv.featurelogin.PresentationEvent
import com.samuraicmdv.featurelogin.data.UserCredentialsUiData

@Composable
fun LoginFormContent(
    user: String,
    onUserChange: (String) -> Unit,
    password: String,
    onPasswordChange: (String) -> Unit,
    isLoading: Boolean,
    modifier: Modifier = Modifier,
    handleEvent: (PresentationEvent) -> Unit,
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
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(MobiStockTheme.spaces.grid_1))
        PasswordFieldContent(
            value = password,
            onChange = { password -> onPasswordChange(password) },
            isLoading = isLoading,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(MobiStockTheme.spaces.grid_0_75))
        Text(
            "Forgot password?",
            fontSize = 14.sp,
            color = MobiStockTheme.colors.linkEnabled,
            modifier = Modifier
                .clickable(enabled = !isLoading) { handleEvent(PresentationEvent.ForgotPassword) }
        )
        Spacer(modifier = Modifier.height(MobiStockTheme.spaces.grid_4))
        Button(
            onClick = {
                handleEvent(PresentationEvent.Login(UserCredentialsUiData(user, password)))
            },
            enabled = user.isNotEmpty() && password.isNotEmpty() && !isLoading,
            shape = RoundedCornerShape(MobiStockTheme.spaces.grid_0_5),
            colors = ButtonDefaults.buttonColors(
                containerColor = MobiStockTheme.colors.brandPrimary,
                disabledContainerColor = MobiStockTheme.colors.backgroundDisabled,
                contentColor = Color.White,
                disabledContentColor = MobiStockTheme.colors.foregroundDisabled
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
        ) {
            Text("Login", color = Color.White)
        }
    }
}