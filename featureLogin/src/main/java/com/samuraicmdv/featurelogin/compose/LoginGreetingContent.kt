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
import com.samuraicmdv.common.theme.MobiTheme
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
            color = MobiTheme.colors.textPrimary,
            style = MobiTheme.typography.displayMedium,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(TEXT_PERCENT_WIDTH)
        )
        Spacer(modifier = Modifier.height(MobiTheme.dimens.dimen_1))
        Text(
            text = stringResource(id = R.string.greetings_content_subtitle),
            color = MobiTheme.colors.textSecondary,
            style = MobiTheme.typography.bodyMedium,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(TEXT_PERCENT_WIDTH)
        )
    }
}

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewLoginGreetingContent() {
    MobiTheme {
        Surface {
            LoginGreetingContent(modifier = Modifier.fillMaxWidth())
        }
    }
}