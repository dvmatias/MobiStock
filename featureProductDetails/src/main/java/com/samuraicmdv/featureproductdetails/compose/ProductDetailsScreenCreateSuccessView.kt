package com.samuraicmdv.featureproductdetails.compose

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.unit.dp
import com.samuraicmdv.common.theme.MobiTheme
import com.samuraicmdv.featureproductdetails.R
import com.samuraicmdv.featureproductdetails.event.ProductDetailsEvent
import com.samuraicmdv.ui.util.ThemePreviews

@Composable
fun ProductDetailsScreenCreateSuccessView(
    productId: Int?,
    handleEvent: (ProductDetailsEvent) -> Unit,
    modifier: Modifier,
) {
    val context = LocalContext.current
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = MobiTheme.dimens.dimen_2)
    ) {
        Spacer(modifier = Modifier.height(MobiTheme.dimens.dimen_4))

        ClickableText(
            text = AnnotatedString(stringResource(id = R.string.product_details_screen_close_button_label)),
            style = MobiTheme.typography.labelLargeBold.copy(
                color = MobiTheme.colors.primary
            ),
            onClick = {
                /*TODO*/
            },
            modifier = Modifier.align(Alignment.End)
        )

        Spacer(modifier = Modifier.height(MobiTheme.dimens.dimen_4))

        Text(
            text = stringResource(id = R.string.product_details_screen_create_success_title),
            style = MobiTheme.typography.headlineMediumBold,
        )

        Spacer(modifier = Modifier.height(MobiTheme.dimens.dimen_8))

        Image(
            painter = painterResource(id = com.samuraicmdv.common.R.drawable.rounded_check_small_24),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            colorFilter = ColorFilter.tint(MobiTheme.colors.onSuccess),
            modifier = Modifier
                .fillMaxWidth(0.5F)
                .aspectRatio(1F)
                .clip(CircleShape)
                .background(MobiTheme.colors.success)

        )

        Spacer(modifier = Modifier.weight(1F))

        Column(
            verticalArrangement = Arrangement.spacedBy(MobiTheme.dimens.dimen_1),
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Button(
                onClick = {
                    /*handleEvent(LoginBusinessEvent.Login(user, password))*/
                    Toast.makeText(context, "Not implemented yet!", Toast.LENGTH_SHORT).show()
                },
                shape = RoundedCornerShape(MobiTheme.dimens.dimen_1_5),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.product_details_screen_see_details_button_label),
                    style = MobiTheme.typography.buttonLabel,
                    color = MobiTheme.colors.onPrimary
                )
            }

            Button(
                onClick = {
                    /*handleEvent(LoginBusinessEvent.Login(user, password))*/
                    Toast.makeText(context, "Not implemented yet!", Toast.LENGTH_SHORT).show()
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = MobiTheme.colors.surfaceContainer,
                    contentColor = MobiTheme.colors.primary,
                ),
                shape = RoundedCornerShape(MobiTheme.dimens.dimen_1_5),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
                    .border(
                        width = 2.dp,
                        color = MobiTheme.colors.primary,
                        shape = RoundedCornerShape(MobiTheme.dimens.dimen_1_5)
                    )
            ) {
                Text(
                    text = stringResource(id = R.string.product_details_screen_create_another_button_label),
                    style = MobiTheme.typography.buttonLabel,
                    color = MobiTheme.colors.primary
                )
            }

            Spacer(modifier = Modifier.height(MobiTheme.dimens.dimen_2))
        }
    }
}

@ThemePreviews
@Composable
fun PreviewProductDetailsScreenCreateSuccessView() {
    MobiTheme {
        Surface {
            ProductDetailsScreenCreateSuccessView(
                productId = 1,
                handleEvent = {},
                modifier = Modifier
            )
        }
    }
}