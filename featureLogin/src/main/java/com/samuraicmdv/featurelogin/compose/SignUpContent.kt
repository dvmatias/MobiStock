package com.samuraicmdv.featurelogin.compose

import androidx.compose.foundation.BorderStroke
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
import com.samuraicmdv.featurelogin.event.LoginBusinessEvent
import com.samuraicmdv.featurelogin.event.LoginEvent

@Composable
fun SignUpContent(
    modifier: Modifier = Modifier,
    handleEvent: (LoginEvent) -> Unit,
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = "Don't have an account? Create one",
            color = MobiStockTheme.colors.foregroundPrimary,
            fontSize = 14.sp,
        )
        Spacer(modifier = Modifier.height(MobiStockTheme.spaces.grid_0_75))
        Button(
            onClick = { handleEvent(LoginBusinessEvent.SignUp) },
            border = BorderStroke(1.5.dp, MobiStockTheme.colors.brandPrimary),
            shape = RoundedCornerShape(MobiStockTheme.spaces.grid_0_5),
            colors = ButtonDefaults.buttonColors(
                containerColor = MobiStockTheme.colors.backgroundPrimary,
                disabledContainerColor = MobiStockTheme.colors.backgroundDisabled,
                contentColor = Color.White,
                disabledContentColor = MobiStockTheme.colors.foregroundDisabled
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
        ) {
            Text("Sign up", color = MobiStockTheme.colors.brandPrimary)
        }
    }
}