package com.samuraicmdv.featuredashboard.compose.dailysalesledge

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
import java.util.Date

@Composable
fun DailySalesNotOpenContent(
    currentDayDate: Date?,
    summary: String?,
    callback: (DashboardEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .clickable {
                // TODO open daily sales ledge
            }
    ) {
        // Current date
        Text(
            text = currentDayDate?.time.toString(),
            style = MobiTheme.typography.titleSmallBold,
            modifier = Modifier
                .padding(top = MobiTheme.dimens.dimen_2, start = MobiTheme.dimens.dimen_2)
                .fillMaxWidth()
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
                    modifier = Modifier
                        .size(48.dp)
                        .padding(6.dp)
                )
                Text(
                    text = "Open cash register to start selling",
                    style = MobiTheme.typography.bodyMedium,
                    modifier = Modifier
                        .padding(start = MobiTheme.dimens.dimen_1)
                        .weight(1f)
                )
                Icon(
                    painter = painterResource(id = com.samuraicmdv.ui.R.drawable.ic_arrow_forward_24px),
                    contentDescription = "Arrow Right Icon",
                    tint = MobiTheme.colors.primary,
                    modifier = Modifier
                        .size(32.dp)
                        .padding(6.dp)
                )
            }
        }
        // Main summary text
        summary?.let {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxWidth(0.7f)
                    .padding(start = MobiTheme.dimens.dimen_2, end = MobiTheme.dimens.dimen_2)
                    .weight(1f)
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