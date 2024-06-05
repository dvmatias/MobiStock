package com.samuraicmdv.featureproductdetails.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.samuraicmdv.common.EMPTY_STRING
import com.samuraicmdv.common.SPACE_STRING
import com.samuraicmdv.common.extension.getMargin
import com.samuraicmdv.common.extension.toDoublePrice
import com.samuraicmdv.common.theme.MobiTheme
import com.samuraicmdv.featureproductdetails.R
import com.samuraicmdv.ui.util.ThemePreviews
import com.samuraicmdv.ui.widget.MobiTextField
import java.util.Locale

private const val MARGIN_MIN = 30
private const val MARGIN_MAX = 99

@Composable
fun ProductDetailsScreenContentEditPriceSection(
    focusManager: FocusManager,
    cost: String,
    onCostChange: (String) -> Unit,
    costError: String?,
    revenue: String,
    onRevenueChange: (String) -> Unit,
    revenueError: String?,
    margin: Int,
    onMarginChange: (Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    val costPriceInputLabel = buildAnnotatedString {
        append(stringResource(id = R.string.field_label_cost_price))
        withStyle(style = SpanStyle(MobiTheme.colors.error)) {
            append(SPACE_STRING)
            append(stringResource(id = R.string.mandatory_field_indicator))
        }
    }.toUpperCase()

    val sellingPriceInputLabel = buildAnnotatedString {
        append(stringResource(id = R.string.field_label_selling_price))
        withStyle(style = SpanStyle(MobiTheme.colors.error)) {
            append(SPACE_STRING)
            append(stringResource(id = R.string.mandatory_field_indicator))
        }
    }.toUpperCase()

    Column(
        modifier = modifier
    ) {
        Text(
            text = stringResource(id = R.string.title_price).uppercase(),
            style = MobiTheme.typography.titleSmallBold,
        )

        Spacer(modifier = Modifier.height(MobiTheme.dimens.dimen_2))

        Row(
            horizontalArrangement = Arrangement.spacedBy(MobiTheme.dimens.dimen_2),
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Max)
        ) {
            Box(modifier = Modifier.weight(1F)) {
                
                MobiTextField(
                    value = if (cost != "null") cost else EMPTY_STRING,
                    onValueChange = { onCostChange(it) },
                    prefix = {
                        Text(
                            text = "$",
                            style = MobiTheme.typography.bodyLargeBold
                        )
                    },
                    mobiLabel = {
                        Text(
                            text = costPriceInputLabel,
                            style = MobiTheme.typography.labelMediumBold,
                        )
                    },
                    isError = !costError.isNullOrEmpty(),
                    errorMessage = costError,
                    keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.Next,
                        keyboardType = KeyboardType.Decimal
                    ),
                    keyboardActions = KeyboardActions(
                        onNext = { focusManager.moveFocus(FocusDirection.Down) }
                    ),
                    placeholder = {
                        Text(
                            text = stringResource(id = R.string.field_placeholder_cost_price),
                            style = MobiTheme.typography.bodyLarge,
                            color = MobiTheme.colors.textSecondary
                        )
                    },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth()
                )
            }
            Box(
                modifier = Modifier
                    .weight(1F)
                    .fillMaxHeight()
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text(
                        text = stringResource(id = R.string.field_label_preferred_margin).uppercase(),
                        style = MobiTheme.typography.labelMediumBold,
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.weight(1f))

                    val dropdownItems = (MARGIN_MIN..MARGIN_MAX)
                    ProductEditDropDownMenu(
                        items = dropdownItems.map { margin ->
                            ItemMenu(
                                title = margin.toString(),
                                item = margin
                            )
                        },
                        selectedIndexDefault = dropdownItems.indexOfFirst { it == margin },
                        modifier = Modifier.fillMaxWidth()
                    ) { onMarginChange(it) }
                }
            }
        }

        Spacer(modifier = Modifier.height(MobiTheme.dimens.dimen_2))

        MobiTextField(
            value = if (revenue != "null") revenue else EMPTY_STRING,
            onValueChange = { onRevenueChange(it) },
            prefix = {
                Text(
                    text = "$",
                    style = MobiTheme.typography.bodyLargeBold
                )
            },
            mobiLabel = {
                Text(
                    text = sellingPriceInputLabel,
                    style = MobiTheme.typography.labelMediumBold,
                )
            },
            isError = !revenueError.isNullOrEmpty(),
            errorMessage = revenueError,
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next,
                keyboardType = KeyboardType.Decimal
            ),
            keyboardActions = KeyboardActions(
                onNext = { focusManager.moveFocus(FocusDirection.Down) }
            ),
            placeholder = {
                Text(
                    text = stringResource(id = R.string.field_placeholder_selling_price),
                    style = MobiTheme.typography.bodyLarge,
                    color = MobiTheme.colors.textSecondary
                )
            },
            supportingText = {
                val costDouble = cost.toDoublePrice()
                val revenueDouble = revenue.toDoublePrice()
                val currentMargin = (costDouble to revenueDouble).getMargin(2)

                Column(
                    horizontalAlignment = Alignment.End,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    // Render selling price recommendation supporting text only if there is a suggested price to show
                    if (costDouble > 0.0) {
                        Text(
                            text = String.format(
                                Locale.getDefault(),
                                stringResource(id = R.string.supporting_text_suggested_price_placeholder),
                                margin,
                                String.format(
                                    Locale.getDefault(),
                                    "%.2f",
                                    (cost.toDoublePrice().div((100 - margin)) * 100)
                                )
                            ),
                            textAlign = TextAlign.End
                        )
                    }

                    Spacer(modifier = Modifier.height(MobiTheme.dimens.dimen_0_5))
                    if (costDouble > 0.0 && revenueDouble > 0.0 && currentMargin < margin) {
                        Row {
                            Icon(
                                imageVector = Icons.Default.Warning,
                                contentDescription = null,
                                tint = MobiTheme.colors.error,
                                modifier = Modifier.size(16.dp)
                            )
                            Spacer(modifier = Modifier.width(MobiTheme.dimens.dimen_1))
                            Text(
                                text = if (currentMargin > 0) "Selling price has a low margin: $currentMargin %" else "Invalid price, margin is negative",
                                textAlign = TextAlign.End,
                                color = if (currentMargin > 0) MobiTheme.colors.textPrimary else MobiTheme.colors.error,
                                modifier = Modifier
                            )
                        }
                    }
                }
            },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@ThemePreviews
@Composable
fun PreviewProductDetailsScreenContentEditPriceSection() {
    MobiTheme {
        Surface {
            ProductDetailsScreenContentEditPriceSection(
                focusManager = LocalFocusManager.current,
                cost = "100.00",
                onCostChange = {},
                costError = null,
                revenue = "200.00",
                revenueError = null,
                margin = 50,
                onMarginChange = {},
                onRevenueChange = {}
            )
        }
    }
}