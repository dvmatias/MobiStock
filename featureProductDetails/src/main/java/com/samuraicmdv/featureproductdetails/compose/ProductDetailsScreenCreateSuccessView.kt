package com.samuraicmdv.featureproductdetails.compose

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.samuraicmdv.common.theme.MobiTheme
import com.samuraicmdv.featureproductdetails.R
import com.samuraicmdv.featureproductdetails.event.ProductDetailsEvent
import com.samuraicmdv.ui.util.ThemePreviews

@Composable
fun ProductDetailsScreenCreateSuccessView(
    productId: Int?,
    handleEvent: (ProductDetailsEvent) -> Unit,
    modifier: Modifier
) {
    val context = LocalContext.current
    Column(
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ) {
        Spacer(modifier = Modifier.height(MobiTheme.dimens.dimen_8))

        Text(
            text = "Product created!",
            style = MobiTheme.typography.headlineMediumBold,
        )

        Spacer(modifier = Modifier.height(MobiTheme.dimens.dimen_8))

        Image(
            painter = painterResource(id = R.drawable.logo_1),
            contentDescription = null,
            contentScale = androidx.compose.ui.layout.ContentScale.Inside,
            modifier = Modifier
                .fillMaxWidth(0.5F)
                .aspectRatio(1F)
                .clip(CircleShape)
                .background(MobiTheme.colors.success)
                .padding(20.dp)

        )

        Spacer(modifier = Modifier.weight(1F))

        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(
                onClick = {
                    /*handleEvent(LoginBusinessEvent.Login(user, password))*/
                    Toast.makeText(context, "Not implemented yet!", Toast.LENGTH_SHORT).show()
                },
                shape = RoundedCornerShape(MobiTheme.dimens.dimen_1_5),
                modifier = Modifier
                    .padding(
                        start = MobiTheme.dimens.dimen_2,
                        end = MobiTheme.dimens.dimen_2,
                        bottom = MobiTheme.dimens.dimen_2,
                        top = MobiTheme.dimens.dimen_1
                    )
                    .fillMaxWidth()
                    .height(48.dp)
            ) {
                Text(
                    text = "See details".uppercase(),
                    style = MobiTheme.typography.buttonLabel
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
                    .padding(
                        start = MobiTheme.dimens.dimen_2,
                        end = MobiTheme.dimens.dimen_2,
                        bottom = MobiTheme.dimens.dimen_2,
                        top = MobiTheme.dimens.dimen_1
                    )
                    .fillMaxWidth()
                    .height(48.dp)
                    .border(
                        width = 2.dp,
                        color = MobiTheme.colors.primary,
                        shape = RoundedCornerShape(MobiTheme.dimens.dimen_1_5)
                    )
            ) {
                Text(
                    text = "Create another".uppercase(),
                    style = MobiTheme.typography.buttonLabel,
                    color = MobiTheme.colors.primary
                )
            }
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