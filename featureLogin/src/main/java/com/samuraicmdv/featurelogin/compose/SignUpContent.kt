package com.samuraicmdv.featurelogin.compose

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.samuraicmdv.common.theme.MobiTheme
import com.samuraicmdv.featurelogin.event.LoginBusinessEvent
import com.samuraicmdv.featurelogin.event.LoginEvent
import com.samuraicmdv.ui.util.ThemePreviews

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
            color = MobiTheme.colors.textPrimary,
            fontSize = 14.sp,
        )
        Spacer(modifier = Modifier.height(MobiTheme.dimens.dimen_0_75))
        OutlinedButton(
            onClick = { handleEvent(LoginBusinessEvent.SignUp) },
            border = BorderStroke(1.5.dp, MobiTheme.colors.primary),
            shape = RoundedCornerShape(MobiTheme.dimens.dimen_1_5),
            modifier = Modifier
                .fillMaxWidth()
                .background(MobiTheme.colors.background)
                .height(48.dp)
        ) {
            Text(
                "Sign up".uppercase(),
                style = MobiTheme.typography.buttonLabel
            )
        }
    }
}

@ThemePreviews
@Composable
fun PreviewSignUpContent(modifier: Modifier = Modifier) {
    MobiTheme {
        Surface {
            SignUpContent {

            }
        }
    }
}