package com.samuraicmdv.featureproductdetails.compose

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
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
import com.samuraicmdv.featureproductdetails.data.BrandUiData
import com.samuraicmdv.featureproductdetails.data.CategoryUiData
import com.samuraicmdv.featureproductdetails.data.ProductPriceUiData
import com.samuraicmdv.featureproductdetails.data.ProductUiData
import com.samuraicmdv.featureproductdetails.event.ProductDetailsEvent
import com.samuraicmdv.featureproductdetails.event.ProductDetailsPresentationEvent
import com.samuraicmdv.ui.util.ThemePreviews
import com.samuraicmdv.ui.widget.MobiTextField
import java.util.Locale

private const val SHORT_DESCRIPTION_MAX_LENGTH = 128
private const val LONG_DESCRIPTION_MAX_LENGTH = 256

/**
 * This content is for rendering [ProductDetailsScreen] when a product is in edit mode. This applies for existing
 * products or for products that are being created (a new product).
 */
@Composable
fun ProductDetailsScreenContentEdit(
    product: ProductUiData?,
    categories: List<CategoryUiData>?,
    brands: List<BrandUiData>?,
    handleEvent: (ProductDetailsEvent) -> Unit,
    modifier: Modifier = Modifier,
) {
    val focusManager = LocalFocusManager.current
    val scrollState = rememberScrollState()
    var name by remember { mutableStateOf(product?.name ?: EMPTY_STRING) }
    var model by remember { mutableStateOf(product?.model ?: EMPTY_STRING) }
    var code by remember { mutableStateOf(product?.code ?: EMPTY_STRING) }
    var sku by remember { mutableStateOf(product?.sku ?: EMPTY_STRING) }
    var shortDescription by remember { mutableStateOf(product?.shortDescription ?: EMPTY_STRING) }
    var longDescription by remember { mutableStateOf(product?.longDescription ?: EMPTY_STRING) }
    var category by remember { mutableStateOf(product?.category) }
    var brand by remember { mutableStateOf(product?.brand) }
    var margin by remember {
        mutableIntStateOf(65) // TODO product?.price?.preferredMargin with 65 as default
    }
    var costPrice by remember {
        mutableStateOf(product?.price?.costPrice?.toString() ?: EMPTY_STRING)
    }
    var sellingPrice by remember {
        mutableStateOf(product?.price?.sellingPrice?.toString() ?: EMPTY_STRING)
    }

    Surface(color = MobiTheme.colors.background) {
        Column(
            modifier = modifier
                .fillMaxSize()
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

                Text(
                    text = stringResource(id = R.string.title_general).uppercase(),
                    style = MobiTheme.typography.titleSmallBold,
                )

                Spacer(modifier = Modifier.height(MobiTheme.dimens.dimen_2))

                // Name
                MobiTextField(
                    value = name,
                    onValueChange = {
                        name = it
                    },
                    mobiLabel = {
                        Text(
                            text = buildAnnotatedString {
                                append(stringResource(id = R.string.field_label_name))
                                withStyle(style = SpanStyle(MobiTheme.colors.error)) {
                                    append(SPACE_STRING)
                                    append(stringResource(id = R.string.mandatory_field_indicator))
                                }
                            }.toUpperCase(),
                            style = MobiTheme.typography.labelMediumBold,
                        )
                    },
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                    keyboardActions = KeyboardActions(
                        onNext = { focusManager.moveFocus(FocusDirection.Down) }
                    ),
                    placeholder = {
                        Text(
                            text = stringResource(id = R.string.field_placeholder_name),
                            style = MobiTheme.typography.bodyLarge,
                            color = MobiTheme.colors.textSecondary
                        )
                    },
                    singleLine = true,
                    supportingText = {
                        Text(text = stringResource(id = R.string.field_supporting_text_name))
                    },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(MobiTheme.dimens.dimen_3))

                // Short description
                Text(
                    text = buildAnnotatedString {
                        append(stringResource(id = R.string.field_label_short_description))
                        withStyle(style = SpanStyle(MobiTheme.colors.error)) {
                            append(SPACE_STRING)
                            append(stringResource(id = R.string.mandatory_field_indicator))
                        }
                    }.toUpperCase(),
                    style = MobiTheme.typography.labelMediumBold,
                )
                Spacer(modifier = Modifier.height(MobiTheme.dimens.dimen_1))
                OutlinedTextField(
                    value = shortDescription,
                    onValueChange = { newShortDescription ->
                        if (newShortDescription.length <= SHORT_DESCRIPTION_MAX_LENGTH) {
                            shortDescription = newShortDescription
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
                                text = stringResource(id = R.string.field_supporting_text_short_description),
                                textAlign = TextAlign.Start,
                                modifier = Modifier.weight(1F)
                            )
                            Text(
                                text = "${shortDescription.length} / $SHORT_DESCRIPTION_MAX_LENGTH",
                                textAlign = TextAlign.End,
                                modifier = Modifier
                            )
                        }
                    },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(MobiTheme.dimens.dimen_3))

                // Long description
                Text(
                    text = buildAnnotatedString {
                        append(stringResource(id = R.string.field_label_long_description))
                        withStyle(style = SpanStyle(MobiTheme.colors.error)) {
                            append(SPACE_STRING)
                            append(stringResource(id = R.string.mandatory_field_indicator))
                        }
                    }.toUpperCase(),
                    style = MobiTheme.typography.labelMediumBold,
                )
                Spacer(modifier = Modifier.height(MobiTheme.dimens.dimen_1))
                OutlinedTextField(
                    value = longDescription,
                    onValueChange = { newLongDescription ->
                        if (newLongDescription.length <= LONG_DESCRIPTION_MAX_LENGTH) {
                            longDescription = newLongDescription
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
                                text = stringResource(id = R.string.field_supporting_text_long_description),
                                textAlign = TextAlign.Start,
                                modifier = Modifier.weight(1F)
                            )
                            Text(
                                text = "${longDescription.length} / $LONG_DESCRIPTION_MAX_LENGTH",
                                textAlign = TextAlign.End,
                            )
                        }
                    },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(MobiTheme.dimens.dimen_3))

                // Model
                MobiTextField(
                    value = model,
                    onValueChange = {
                        model = it
                    },
                    mobiLabel = {
                        Text(
                            text = stringResource(id = R.string.field_label_model).uppercase(),
                            style = MobiTheme.typography.labelMediumBold,
                        )
                    },
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                    keyboardActions = KeyboardActions(
                        onNext = { focusManager.moveFocus(FocusDirection.Down) }
                    ),
                    placeholder = {
                        Text(
                            text = stringResource(id = R.string.field_placeholder_model),
                            style = MobiTheme.typography.bodyLarge,
                            color = MobiTheme.colors.textSecondary
                        )
                    },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(MobiTheme.dimens.dimen_3))

                // Code
                MobiTextField(
                    value = code,
                    onValueChange = {
                        code = it
                    },
                    mobiLabel = {
                        Text(
                            text = stringResource(id = R.string.field_label_code).uppercase(),
                            style = MobiTheme.typography.labelMediumBold,
                        )
                    },
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                    keyboardActions = KeyboardActions(
                        onNext = { focusManager.moveFocus(FocusDirection.Down) }
                    ),
                    placeholder = {
                        Text(
                            text = stringResource(id = R.string.field_placeholder_code),
                            style = MobiTheme.typography.bodyLarge,
                            color = MobiTheme.colors.textSecondary
                        )
                    },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(MobiTheme.dimens.dimen_4))
                Text(
                    text = stringResource(id = R.string.title_product_specifics).uppercase(),
                    style = MobiTheme.typography.titleSmallBold,
                )

                // Category
                categories?.let {
                    Spacer(modifier = Modifier.height(MobiTheme.dimens.dimen_2))
                    Text(
                        text = buildAnnotatedString {
                            append(stringResource(id = R.string.field_label_category))
                            withStyle(style = SpanStyle(MobiTheme.colors.error)) {
                                append(SPACE_STRING)
                                append(stringResource(id = R.string.mandatory_field_indicator))
                            }
                        }.toUpperCase(),
                        style = MobiTheme.typography.labelMediumBold,
                    )

                    Spacer(modifier = Modifier.height(MobiTheme.dimens.dimen_1))

                    ProductEditDropDownMenu(
                        items = it.map { category ->
                            ItemMenu(
                                title = stringResource(id = category.nameResId),
                                item = category
                            )
                        },
                        defaultOptionTitle = stringResource(id = R.string.option_dropdown_menu_category_default)
                    ) { selectedCategory ->
                        category = selectedCategory
                    }
                }

                // Brand
                Spacer(modifier = Modifier.height(MobiTheme.dimens.dimen_3))
                brands?.let {
                    Text(
                        text = buildAnnotatedString {
                            append(stringResource(id = R.string.field_label_brand))
                            withStyle(style = SpanStyle(MobiTheme.colors.error)) {
                                append(SPACE_STRING)
                                append(stringResource(id = R.string.mandatory_field_indicator))
                            }
                        }.toUpperCase(),
                        style = MobiTheme.typography.labelMediumBold,
                    )

                    Spacer(modifier = Modifier.height(MobiTheme.dimens.dimen_1))

                    ProductEditDropDownMenu(
                        items = it.map { brand ->
                            ItemMenu(
                                title = brand.name,
                                item = brand
                            )
                        },
                        defaultOptionTitle = stringResource(id = R.string.option_dropdown_menu_brand_default)
                    ) { selectedBrand ->
                        brand = selectedBrand
                    }
                }

                // SKU
                Spacer(modifier = Modifier.height(MobiTheme.dimens.dimen_3))
                MobiTextField(
                    value = sku,
                    onValueChange = {
                        sku = it
                    },
                    mobiLabel = {
                        Text(
                            text = stringResource(id = R.string.field_label_sku).uppercase(),
                            style = MobiTheme.typography.labelMediumBold,
                        )
                    },
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                    keyboardActions = KeyboardActions(
                        onNext = { focusManager.moveFocus(FocusDirection.Down) }
                    ),
                    placeholder = {
                        Text(
                            text = stringResource(id = R.string.field_placeholder_sku),
                            style = MobiTheme.typography.bodyLarge,
                            color = MobiTheme.colors.textSecondary
                        )
                    },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth()
                )

                // Prices (selling and cost)
                Spacer(modifier = Modifier.height(MobiTheme.dimens.dimen_4))

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
                            value = if (costPrice != "null") costPrice else EMPTY_STRING,
                            onValueChange = {
                                costPrice = it
                            },
                            prefix = {
                                Text(
                                    text = "$",
                                    style = MobiTheme.typography.bodyLargeBold
                                )
                            },
                            mobiLabel = {
                                Text(
                                    text = buildAnnotatedString {
                                        append(stringResource(id = R.string.field_label_cost_price))
                                        withStyle(style = SpanStyle(MobiTheme.colors.error)) {
                                            append(SPACE_STRING)
                                            append(stringResource(id = R.string.mandatory_field_indicator))
                                        }
                                    }.toUpperCase(),
                                    style = MobiTheme.typography.labelMediumBold,
                                )
                            },
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
                        val cost = costPrice.toDoublePrice()
                        val revenue = sellingPrice.toDoublePrice()

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

                            val dropdownItems = (1..99)
                            ProductEditDropDownMenu(
                                items = dropdownItems.map { margin ->
                                    ItemMenu(
                                        title = margin.toString(),
                                        item = margin
                                    )
                                },
                                selectedIndexDefault = dropdownItems.indexOfFirst { it == margin },
                                modifier = Modifier.fillMaxWidth()
                            ) { selectedMargin ->
                                margin = selectedMargin
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(MobiTheme.dimens.dimen_2))

                MobiTextField(
                    value = if (sellingPrice != "null") sellingPrice else EMPTY_STRING,
                    onValueChange = {
                        sellingPrice = it
                    },
                    prefix = {
                        Text(
                            text = "$",
                            style = MobiTheme.typography.bodyLargeBold
                        )
                    },
                    mobiLabel = {
                        Text(
                            text = buildAnnotatedString {
                                append(stringResource(id = R.string.field_label_selling_price))
                                withStyle(style = SpanStyle(MobiTheme.colors.error)) {
                                    append(SPACE_STRING)
                                    append(stringResource(id = R.string.mandatory_field_indicator))
                                }
                            }.toUpperCase(),
                            style = MobiTheme.typography.labelMediumBold,
                        )
                    }, keyboardOptions = KeyboardOptions(
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
                        val cost = costPrice.toDoublePrice()
                        val revenue = sellingPrice.toDoublePrice()
                        val currentMargin = (cost to revenue).getMargin(2)

                        Column(
                            horizontalAlignment = Alignment.End,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            // Render selling price recommendation supporting text only if there is a suggested price to show
                            if (cost > 0.0) {
                                Text(
                                    text = String.format(
                                        Locale.getDefault(),
                                        stringResource(id = R.string.supporting_text_suggested_price_placeholder),
                                        margin,
                                        String.format(
                                            Locale.getDefault(),
                                            "%.2f",
                                            (costPrice.toDoublePrice().div((100 - margin)) * 100)
                                        )
                                    ),
                                    textAlign = TextAlign.End
                                )
                            }

                            Spacer(modifier = Modifier.height(MobiTheme.dimens.dimen_0_5))
                            if (cost > 0.0 && revenue > 0.0 && currentMargin < margin) {
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

                Spacer(modifier = Modifier.height(MobiTheme.dimens.dimen_2))



                Spacer(
                    modifier = Modifier.height(
                        MobiTheme.dimens.dimen_8
                    )
                )
            }

            Button(
                onClick = {
                    // TODO
                    handleEvent(ProductDetailsPresentationEvent.CreateNewProduct)
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
}

@Composable
fun <T> ProductEditDropDownMenu(
    items: List<ItemMenu<T>>,
    modifier: Modifier = Modifier,
    defaultOptionTitle: String? = null,
    selectedIndexDefault: Int? = null,
    onItemSelected: (T) -> Unit
) {
    val options: List<ItemMenu<T>> = items.toMutableList().apply {
        defaultOptionTitle?.let { add(0, ItemMenu(title = it)) }
    }.toList()
    var expanded by remember { mutableStateOf(false) }
    var selectedOption by remember {
        mutableStateOf(options[selectedIndexDefault ?: 0])
    }

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
                    text = selectedOption.title,
                    style = if (selectedOption.item == null) MobiTheme.typography.labelMediumBold else MobiTheme.typography.bodyLarge,
                    color = if (selectedOption.item == null) MobiTheme.colors.primary else MobiTheme.colors.textPrimary,
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
                                    text = option.title,
                                    style = MobiTheme.typography.bodyLarge,
                                )
                            }
                        },
                        onClick = {
                            if (option.item != null) {
                                selectedOption = option
                                onItemSelected(option.item)
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

data class ItemMenu<T>(
    val title: String,
    val item: T? = null,
)

@ThemePreviews
@Composable
fun PreviewProductDetailsScreenContentEdit() {
    MobiTheme {
        Surface {
            ProductDetailsScreenContentEdit(
                product = ProductUiData(
                    id = -1,
                    name = EMPTY_STRING,
                    shortDescription = EMPTY_STRING,
                    longDescription = EMPTY_STRING,
                    model = EMPTY_STRING,
                    code = EMPTY_STRING,
                    sku = EMPTY_STRING,
                    thumbnailUrl = EMPTY_STRING,
                    imageUrls = emptyList(),
                    price = ProductPriceUiData(),
                    brand = BrandUiData(
                        id = -1,
                        name = EMPTY_STRING,
                        logoUrl = EMPTY_STRING,
                    ),
                    category = CategoryUiData(
                        id = -1,
                        nameResId = -1,
                        description = EMPTY_STRING,
                        logoUrl = EMPTY_STRING,
                    ),
                ),
                categories = List(5) {
                    CategoryUiData(
                        id = it,
                        nameResId = R.string.field_label_category,
                        description = EMPTY_STRING,
                        logoUrl = EMPTY_STRING,
                    )
                },
                brands = List(5) {
                    BrandUiData(
                        id = it,
                        name = EMPTY_STRING,
                        logoUrl = EMPTY_STRING,
                    )
                },
                handleEvent = {}
            )
        }
    }
}

/*
if (cost > 0.0 && revenue > 0.0) {
                                    buildAnnotatedString {
                                        append("Margin: ")
                                        val margin = (cost to revenue).getMargin(2, suffix = " %")
                                        withStyle(
                                            style = SpanStyle(MobiTheme.colors.primary)
                                        ) {
                                            append(margin)
                                        }
                                    }
                                } else {
                                    buildAnnotatedString {
                                        append("Margin: ")
                                        append("0 %")
                                    }
                                } TODO
 */