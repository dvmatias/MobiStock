package com.samuraicmdv.ui.util

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.ui.tooling.preview.Preview

@Preview(apiLevel = 34, name = "1 Light Mode", showBackground = true, uiMode = UI_MODE_NIGHT_NO)
@Preview(apiLevel = 34, name = "2 Dark Mode", showBackground = true, uiMode = UI_MODE_NIGHT_YES)
annotation class ThemePreviews
