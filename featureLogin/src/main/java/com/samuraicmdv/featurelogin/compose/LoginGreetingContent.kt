package com.samuraicmdv.featurelogin.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.samuraicmdv.common.theme.MobiStockTheme

@Composable
fun LoginGreetingContent(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Welcome!",
            color = MobiStockTheme.colors.foregroundPrimary,
            fontSize = 36.sp // TODO
        )
        Spacer(modifier = Modifier.height(MobiStockTheme.spaces.grid_1))
        Text(
            text = "Happy to see you!",
            color = MobiStockTheme.colors.foregroundSecondary,
            fontSize = 14.sp, // TODO
            lineHeight = 18.sp, // TODO
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(0.7F) // TODO
        )
        Text(
            text = "Sign in user your credentials or signup if you don't have an account yet.",
            color = MobiStockTheme.colors.foregroundSecondary,
            fontSize = 14.sp,
            lineHeight = 18.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(0.7F) // TODO
        )
    }
}