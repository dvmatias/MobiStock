package com.samuraicmdv.featurelogin.compose

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.samuraicmdv.common.theme.MobiStockTheme
import com.samuraicmdv.featurelogin.R

private const val TEXT_PERCENT_WIDTH = 0.7F

@Composable
fun LoginGreetingContent(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.greetings_content_title),
            color = MobiStockTheme.colors.foregroundPrimary,
            style = MobiStockTheme.typography.giant1Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(TEXT_PERCENT_WIDTH)
        )
        Spacer(modifier = Modifier.height(MobiStockTheme.spaces.grid_1))
        Text(
            text = stringResource(id = R.string.greetings_content_subtitle),
            color = MobiStockTheme.colors.foregroundSecondary,
            style = MobiStockTheme.typography.bodyRegular,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(TEXT_PERCENT_WIDTH)
        )
    }
}

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewLoginGreetingContent() {
    MobiStockTheme {
        Surface(color = MobiStockTheme.colors.backgroundPrimary) {
            LoginGreetingContent(modifier = Modifier.fillMaxWidth())
        }
    }
}