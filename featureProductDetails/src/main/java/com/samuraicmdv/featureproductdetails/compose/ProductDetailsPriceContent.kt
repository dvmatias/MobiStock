package com.samuraicmdv.featureproductdetails.compose

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Error
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import com.samuraicmdv.common.event.Action
import com.samuraicmdv.common.extension.getMargin
import com.samuraicmdv.common.theme.MobiTheme
import com.samuraicmdv.featureproductdetails.data.ProductPriceUiData
import com.samuraicmdv.ui.widget.ActionText
import com.samuraicmdv.ui.widget.IconLabelValue
import com.samuraicmdv.ui.widget.LabelValue
import com.samuraicmdv.ui.widget.PriceComponentLevel
import com.samuraicmdv.ui.widget.PriceComponentStyle
import com.samuraicmdv.ui.widget.PriceComponentWeight
import com.samuraicmdv.ui.widget.StyledPriceComponent

@Composable
fun ProductDetailsPriceContent(
    price: ProductPriceUiData,
    modifier: Modifier = Modifier,
) {
    val context = LocalContext.current
    val actualMargin: Double = (price.costPrice to price.sellingPrice).getMargin(2)
    val preferredMargin: Int = price.preferredMargin ?: 65
    val marginIcon = if (actualMargin > preferredMargin) {
        Icons.Default.CheckCircle
    } else {
        Icons.Default.Error
    }
    val marginIconColor = if (actualMargin > preferredMargin) {
        MobiTheme.colors.textPositive
    } else {
        MobiTheme.colors.error
    }
    val preferredMarginCaption = "(preferred: $preferredMargin%)"

    Column(
        modifier = modifier
            .background(MobiTheme.colors.disabledContainerColor)
            .padding(vertical = MobiTheme.dimens.dimen_2, horizontal = MobiTheme.dimens.dimen_2)
    ) {
        Text(
            text = "Pricing",
            style = MobiTheme.typography.titleSmallBold,
            modifier = Modifier
                .fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(MobiTheme.dimens.dimen_2))

        price.costPrice?.let { sellingPrice ->
            LabelValue(
                label = {
                    Text(
                        text = "cost",
                        style = MobiTheme.typography.bodyMediumBold,
                        modifier = Modifier.weight(1F)
                    )
                },
                value = {
                    StyledPriceComponent(
                        amount = sellingPrice,
                        priceComponentStyle = PriceComponentStyle.REGULAR,
                        priceComponentWeight = PriceComponentWeight.BOLD,
                        priceComponentLevel = PriceComponentLevel.DISPLAY,
                        modifier = Modifier
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
            )
        }

        Spacer(modifier = Modifier.height(MobiTheme.dimens.dimen_1))

        price.sellingPrice?.let { sellingPrice ->
            LabelValue(
                label = {
                    Text(
                        text = "selling",
                        style = MobiTheme.typography.bodyMediumBold,
                        modifier = Modifier.weight(1F)
                    )
                },
                value = {
                    StyledPriceComponent(
                        amount = sellingPrice,
                        priceComponentStyle = PriceComponentStyle.REGULAR,
                        priceComponentWeight = PriceComponentWeight.BOLD,
                        priceComponentLevel = PriceComponentLevel.POSITIVE,
                        modifier = Modifier
                    )
                },
            )
        }

        Spacer(modifier = Modifier.height(MobiTheme.dimens.dimen_1))

        IconLabelValue(
            label = {
                Text(
                    text = "margin",
                    style = MobiTheme.typography.bodyMediumBold
                )
            },
            value = {
                Text(
                    text = (price.costPrice to price.sellingPrice).getMargin(2, "", "%"),
                    style = MobiTheme.typography.bodyMediumBold,
                    textAlign = TextAlign.End,
                    modifier = Modifier.weight(1F)
                )
            },
            icon = {
                Icon(
                    imageVector = marginIcon,
                    contentDescription = null,
                    tint = marginIconColor
                )
            }
        )
        Text(
            text = preferredMarginCaption,
            style = MobiTheme.typography.bodyMedium,
            textAlign = TextAlign.End,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(MobiTheme.dimens.dimen_3))

        ActionText(
            action = Action(
                name = "Edit",
                label = "Edit",
                handler = {
                    /*TODO*/
                    Toast.makeText(context, "Not implemented yet.", Toast.LENGTH_SHORT).show()
                }
            ),
            modifier = Modifier.align(Alignment.End)
        )
    }
}