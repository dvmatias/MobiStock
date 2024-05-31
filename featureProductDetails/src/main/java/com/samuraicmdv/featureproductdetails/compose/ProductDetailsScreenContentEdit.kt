package com.samuraicmdv.featureproductdetails.compose

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.samuraicmdv.common.theme.MobiTheme
import com.samuraicmdv.featureproductdetails.R
import com.samuraicmdv.featureproductdetails.data.ProductUiData
import com.samuraicmdv.ui.util.ThemePreviews
import com.samuraicmdv.ui.widget.MobiTextField

/**
 * This content is for rendering [ProductDetailsScreen] when a product is in edit mode. This applies for existing
 * products or for products that are being created (a new product).
 */
@Composable
fun ProductDetailsScreenContentEdit(
    product: ProductUiData?,
    modifier: Modifier = Modifier
) {
    val scrollState = rememberScrollState()
    var name by remember {
        mutableStateOf("A+C Turbo Charger")
    }
    /*
    var model by remember {
         mutableStateOf("MOT-1406")
     }
      var code by remember {
            mutableStateOf("CHARG-2005")
        }
        var sku by remember {
            mutableStateOf("1-1200004357-M/S")
        }
        var costPrice by remember {
            mutableStateOf("6.500,00")
        }
        var sellingPrice by remember {
            mutableStateOf("12.900,00")
        }
        var shortDescription by remember {
            mutableStateOf("")
        }
        var longDescription by remember {
            mutableStateOf("")
        }
        */

    Column(
        modifier = modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(scrollState)
                .padding(horizontal = MobiTheme.dimens.dimen_2)
                .weight(1F)
        ) {
            // Screen title
            Spacer(modifier = Modifier.height(MobiTheme.dimens.dimen_2))
            Text(
                text = stringResource(id = R.string.title_product_details_screen_content_edit),
                style = MobiTheme.typography.headlineMediumBold,
            )
            Spacer(modifier = Modifier.height(MobiTheme.dimens.dimen_4))

            // Name
            ProductDetailsScreenContentEditSimpleInputField(
                value = name,
                onValueChange = { name = it },
                label = stringResource(id = R.string.field_label_name),
                mandatory = true,
                modifier = Modifier.padding(top = MobiTheme.dimens.dimen_2),
                supportingText = {
                    Text(text = "Do not include brand, model or technical specifications")
                },
                textFieldModifier = Modifier.fillMaxWidth()
            )
            /*

                        Spacer(modifier = Modifier.height(MobiTheme.dimens.dimen_2))
                        Text(
                            text = "Short Description".uppercase(),
                            style = MobiTheme.typography.titleSmallBold,
                        )
                        Spacer(modifier = Modifier.height(MobiTheme.dimens.dimen_1))
                        OutlinedTextField(
                            value = shortDescription,
                            onValueChange = { input ->
                                if (input.length <= 128) { // TODO constant
                                    shortDescription = input
                                }
                            },
                            minLines = 3,
                            maxLines = 3,
                            textStyle = MobiTheme.typography.bodyLarge,
                            supportingText = {
                                Row(
                                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Text(
                                        text = "Essential information. This is for showing on small contexts and items",
                                        textAlign = TextAlign.Start,
                                        modifier = Modifier.weight(1F)
                                    )
                                    Text(
                                        text = "${shortDescription.length} / 128", // TODO constant
                                        textAlign = TextAlign.End,
                                        modifier = Modifier
                                    )
                                }
                            },
                            modifier = Modifier.fillMaxWidth()
                        )

                        Spacer(modifier = Modifier.height(MobiTheme.dimens.dimen_2))
                        Text(
                            text = "Long Description".uppercase(),
                            style = MobiTheme.typography.titleSmallBold,
                        )
                        Spacer(modifier = Modifier.height(MobiTheme.dimens.dimen_1))
                        OutlinedTextField(
                            value = longDescription,
                            onValueChange = { input ->
                                if (input.length <= 256) { // TODO constant
                                    longDescription = input
                                }
                            },
                            minLines = 4,
                            maxLines = 4,
                            textStyle = MobiTheme.typography.bodyLarge,
                            supportingText = {
                                Row(
                                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Text(
                                        text = "Essential and specific information. This is for showing on large contexts and detail screens.",
                                        textAlign = TextAlign.Start,
                                        modifier = Modifier.weight(1F)
                                    )
                                    Text(
                                        text = "${longDescription.length} / 256", // TODO constant
                                        textAlign = TextAlign.End,
                                    )
                                }
                            },
                            modifier = Modifier.fillMaxWidth()
                        )

                        // Model
                        ProductDetailsScreenContentEditSimpleInputField(
                            value = model,
                            onValueChange = { model = it },
                            label = stringResource(id = R.string.field_label_model),
                            mandatory = true,
                            modifier = Modifier.padding(top = MobiTheme.dimens.dimen_3),
                            textFieldModifier = Modifier.fillMaxWidth()
                        )

                        // Code
                        ProductDetailsScreenContentEditSimpleInputField(
                            value = code,
                            onValueChange = { code = it },
                            label = stringResource(id = R.string.field_label_code),
                            modifier = Modifier.padding(top = MobiTheme.dimens.dimen_3),
                            textFieldModifier = Modifier.fillMaxWidth()
                        )

                        // SKU
                        ProductDetailsScreenContentEditSimpleInputField(
                            value = sku,
                            onValueChange = { sku = it },
                            label = stringResource(id = R.string.field_label_sku),
                            modifier = Modifier.padding(top = MobiTheme.dimens.dimen_3),
                            textFieldModifier = Modifier.fillMaxWidth()
                        )

                        // Category
                        Spacer(modifier = Modifier.height(MobiTheme.dimens.dimen_3))
                        Text(
                            text = "Category".uppercase(),
                            style = MobiTheme.typography.titleSmallBold,
                        )
                        Spacer(modifier = Modifier.height(MobiTheme.dimens.dimen_1))
                        ProductDetailsScreenContentEditCategoryDropDownMenu()

                        // Brand
                        Spacer(modifier = Modifier.height(MobiTheme.dimens.dimen_3))
                        Text(
                            text = "Brand".uppercase(),
                            style = MobiTheme.typography.titleSmallBold,
                        )
                        Spacer(modifier = Modifier.height(MobiTheme.dimens.dimen_1))
                        ProductDetailsScreenContentEditCategoryDropDownMenu()

                        // Prices (selling and cost)
                        Spacer(modifier = Modifier.height(MobiTheme.dimens.dimen_3))
                        Text(
                            text = "Prices".uppercase(),
                            style = MobiTheme.typography.titleSmallBold,
                        )
                        Spacer(modifier = Modifier.height(MobiTheme.dimens.dimen_1))
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(MobiTheme.dimens.dimen_2),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Box(modifier = Modifier.weight(1F)) {
                                ProductDetailsScreenContentEditSimpleInputField(
                                    value = costPrice,
                                    onValueChange = { costPrice = it },
                                    label = stringResource(id = R.string.field_label_cost_price),
                                    mandatory = true,
                                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                                    textFieldModifier = Modifier.fillMaxWidth()
                                )
                            }
                            Box(modifier = Modifier.weight(1F)) {
                                ProductDetailsScreenContentEditSimpleInputField(
                                    value = sellingPrice,
                                    onValueChange = { sellingPrice = it },
                                    label = stringResource(id = R.string.field_label_selling_price),
                                    mandatory = true,
                                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                                    textFieldModifier = Modifier.fillMaxWidth()
                                )
                            }
                        }
            */

            Spacer(
                modifier = Modifier.height(
                    MobiTheme.dimens.dimen_5
                )
            )
        }

        Button(
            onClick = {
                /*TODO*/
            },
            enabled = true,
            shape = RoundedCornerShape(MobiTheme.dimens.dimen_1_5),
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = MobiTheme.dimens.dimen_2,
                    end = MobiTheme.dimens.dimen_2,
                    bottom = MobiTheme.dimens.dimen_2,
                    top = MobiTheme.dimens.dimen_1
                )
                .height(48.dp)
        ) {
            Text(
                text = "save".uppercase(),
                style = MobiTheme.typography.buttonLabel
            )
        }
    }
}

@Composable
fun ProductDetailsScreenContentEditSimpleInputField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String?,
    modifier: Modifier = Modifier,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    supportingText: @Composable (() -> Unit)? = null,
    textFieldModifier: Modifier = Modifier,
    mandatory: Boolean = false
) {
    Box(modifier = modifier) {
        MobiTextField(
            value = value,
            onValueChange = { newValue ->
                onValueChange(newValue)
            },
            label = {
                label?.let { label ->
                    Text(
                        text = buildAnnotatedString {
                            if (mandatory) {
                                withStyle(style = SpanStyle(MobiTheme.colors.error)) {
                                    append(stringResource(id = R.string.mandatory_field_indicator))
                                    append(" ")
                                }
                            }
                            append(label)
                        },
                        fontWeight = FontWeight.Bold
                    )
                }
            },
            keyboardActions = keyboardActions,
            keyboardOptions = keyboardOptions,
            maxLines = 1,
            supportingText = supportingText,
            modifier = textFieldModifier
        )
    }
}

@Composable
fun ProductDetailsScreenContentEditCategoryDropDownMenu(
    modifier: Modifier = Modifier
) {
    val options = listOf("Select an option", "Option 1", "Option 2", "Option 3")
    var expanded by remember { mutableStateOf(false) }
    var selectedOption by remember { mutableStateOf(options[0]) }

    Box(
        modifier = Modifier
            .wrapContentSize(Alignment.TopStart)
            .background(Color.Transparent)
    ) {

        Column(
            modifier = Modifier
                .width(IntrinsicSize.Max)
                .background(Color.Transparent)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = modifier
                    .padding(
                        start = 0.dp,
                        end = 0.dp,
                        top = 0.dp,
                        bottom = MobiTheme.dimens.dimen_0_5,
                    )
                    .clickable { expanded = true }
                    .animateContentSize()

            ) {
                Text(
                    text = selectedOption,
                    style = if (selectedOption == "Select an option") MobiTheme.typography.labelMediumBold else MobiTheme.typography.bodyLarge,
                    color = if (selectedOption == "Select an option") MobiTheme.colors.primary else MobiTheme.colors.textPrimary,
                )
                Icon(
                    imageVector = Icons.Default.ArrowDropDown,
                    contentDescription = null,
                    tint = MobiTheme.colors.primary,
                    modifier = Modifier.width(MobiTheme.dimens.dimen_3)
                )
            }

            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = Modifier.background(MobiTheme.colors.surface)
            ) {
                options.forEach { option ->
                    DropdownMenuItem(
                        text = {
                            Row {
                                Text(
                                    text = option,
                                    style = MobiTheme.typography.bodyLarge,
                                )
                            }
                        },
                        onClick = {
                            if (option != "Select an option") {
                                selectedOption = option
                                expanded = false
                            }
                        }
                    )
                }
            }
            Spacer(
                modifier = Modifier
                    .height(1.dp)
                    .background(MobiTheme.colors.textDisable)
                    .fillMaxWidth()
            )
        }
    }
}

@ThemePreviews
@Composable
fun PreviewProductDetailsScreenContentEdit() {
    MobiTheme {
        Surface {
            ProductDetailsScreenContentEdit(
                null
            )
        }
    }
}