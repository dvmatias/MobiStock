package com.samuraicmdv.ui.util

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.ui.tooling.preview.Preview

@Preview(name = "1 Light Mode", showBackground = true, uiMode = UI_MODE_NIGHT_NO)
@Preview(name = "2 Dark Mode", showBackground = true, uiMode = UI_MODE_NIGHT_YES)
annotation class ThemePreviews
