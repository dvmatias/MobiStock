package com.samuraicmdv.featuredashboard.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.samuraicmdv.common.theme.MobiTheme
import com.samuraicmdv.featuredashboard.R
import com.samuraicmdv.featuredashboard.event.DashboardEvent
import com.samuraicmdv.featuredashboard.state.DailySaleState
import com.samuraicmdv.ui.util.ThemePreviews
import java.util.Date

@Composable
fun DailySalesLedgeScreen(
    state: DailySaleState?,
    callback: (DashboardEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        if (state?.isDailySalesLedgeOpen == true) {
            // Daily sales ledge already open
            DailySalesOpenContent(callback)
        } else {
            // Daily sales ledge not open yet
            DailySalesNotOpenContent(state?.currentDayDate, state?.summary, callback)
        }
    }
}

@Composable
fun DailySalesNotOpenContent(
    currentDayDate: Date?,
    summary: String?,
    callback: (DashboardEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize().clickable {
            // TODO open daily sales ledge
        }
    ) {
        // Current date
        Text(
            text = currentDayDate?.time.toString(),
            style = MobiTheme.typography.titleSmallBold,
            modifier = Modifier.padding(top = MobiTheme.dimens.dimen_2, start = MobiTheme.dimens.dimen_2).fillMaxWidth()
        )
        // Card to open daily sales ledge
        Card(
            shape = RoundedCornerShape(MobiTheme.dimens.dimen_1),
            modifier = Modifier
                .padding(MobiTheme.dimens.dimen_2)
                .fillMaxWidth()
                .clickable {
                    // TODO
                }
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(MobiTheme.dimens.dimen_1)
                    .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_cash_register),
                    contentDescription = "Cash Register Icon",
                    modifier = Modifier.size(48.dp).padding(6.dp)
                )
                Text(
                    text = "Open cash register to start selling",
                    style = MobiTheme.typography.bodyMedium,
                    modifier = Modifier.padding(start = MobiTheme.dimens.dimen_1).weight(1f)
                )
                Icon(
                    painter = painterResource(id = R.drawable.arrow_forward_ios_24px),
                    contentDescription = "Arrow Right Icon",
                    tint = MobiTheme.colors.primary,
                    modifier = Modifier.size(32.dp).padding(6.dp)
                )
            }
        }
        // Main summary text
        summary?.let {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxWidth(0.7f).padding(start = MobiTheme.dimens.dimen_2, end = MobiTheme.dimens.dimen_2).weight(1f)
            ) {
                Text(
                    text = it,
                    style = MobiTheme.typography.bodyMedium,
                    color = MobiTheme.colors.textDisable,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Composable
fun DailySalesOpenContent(
    callback: (DashboardEvent) -> Unit,
    modifier: Modifier = Modifier
) {

}

@ThemePreviews
@Composable
fun PreviewDailySalesLedgeScreen() {
    MobiTheme {
        // A surface container using the 'background' color from the theme
        Surface {
            DailySalesLedgeScreen(
                state = DailySaleState(
                    isLoading = false,
                    currentDayDate = Date(),
                    summary = "There are no sales registered today. Please open cash register to start registering sales.",
                    isDailySalesLedgeOpen = true
                ),
                callback = {}
            )
        }
    }
}


/* Create an inline function called "prettyMuchThatsIt", it takes two integers and returns the sum of them in String format. If the sum is bigger than 10, it returns a string "Wow, that's a big number!".*/
fun prettyMuchThatsIt(a: Int, b: Int): String {
    val sum = a + b
    return if (sum > 10) {
        "Wow, that's a big number!"
    } else {
        sum.toString()
    }
}



