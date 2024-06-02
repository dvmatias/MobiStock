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
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
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
import com.samuraicmdv.common.extension.toDisplayPrice
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
    var name by remember { mutableStateOf(product?.name ?: "") }
    var model by remember { mutableStateOf(product?.model ?: "") }
    var code by remember { mutableStateOf(product?.code ?: "") }
    var sku by remember { mutableStateOf(product?.sku ?: "") }
    var shortDescription by remember { mutableStateOf(product?.shortDescription ?: "") }
    var longDescription by remember { mutableStateOf(product?.longDescription ?: "") }
    var category by remember { mutableStateOf(product?.category) }
    var brand by remember { mutableStateOf(product?.brand) }
    var costPrice by remember {
        mutableDoubleStateOf(product?.price?.costPrice ?: 0.0)
    }
    var sellingPrice by remember {
        mutableDoubleStateOf(product?.price?.sellingPrice ?: 0.0)
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
                    text = "General".uppercase(),
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
                                    append(" ")
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
                            append(" ")
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
                            append(" ")
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
                    text = "Product specifics".uppercase(),
                    style = MobiTheme.typography.titleSmallBold,
                )

                // Category
                categories?.let {
                    Spacer(modifier = Modifier.height(MobiTheme.dimens.dimen_2))
                    Text(
                        text = buildAnnotatedString {
                            append(stringResource(id = R.string.field_label_category))
                            withStyle(style = SpanStyle(MobiTheme.colors.error)) {
                                append(" ")
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
                        }
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
                                append(" ")
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
                        }
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
                    text = "Prices".uppercase(),
                    style = MobiTheme.typography.titleSmallBold,
                )

                Spacer(modifier = Modifier.height(MobiTheme.dimens.dimen_2))

                Row(
                    horizontalArrangement = Arrangement.spacedBy(MobiTheme.dimens.dimen_2),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Box(modifier = Modifier.weight(1F)) {
                        MobiTextField(
                            value = costPrice.toDisplayPrice(),
                            onValueChange = {
                                costPrice = it.toDoublePrice()
                            },
                            mobiLabel = {
                                Text(
                                    text = buildAnnotatedString {
                                        append(stringResource(id = R.string.field_label_cost_price))
                                        withStyle(style = SpanStyle(MobiTheme.colors.error)) {
                                            append(" ")
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
                    Box(modifier = Modifier.weight(1F)) {
                        MobiTextField(
                            value = sellingPrice.toDisplayPrice(),
                            onValueChange = {
                                sellingPrice = it.toDoublePrice()
                            },
                            mobiLabel = {
                                Text(
                                    text = buildAnnotatedString {
                                        append(stringResource(id = R.string.field_label_selling_price))
                                        withStyle(style = SpanStyle(MobiTheme.colors.error)) {
                                            append(" ")
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
                            singleLine = true,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }

                Spacer(
                    modifier = Modifier.height(
                        MobiTheme.dimens.dimen_5
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
    onItemSelected: (T) -> Unit
) {
    val defaultOption = stringResource(id = R.string.option_dropdown_menu_default)
    val options: List<ItemMenu<T>> = items.sortedBy { it.title }.toMutableList().apply {
        add(0, ItemMenu(title = defaultOption))
    }.toList()
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
                    name = "",
                    shortDescription = "",
                    longDescription = "",
                    model = "",
                    code = "",
                    sku = "",
                    thumbnailUrl = "",
                    imageUrls = emptyList(),
                    price = ProductPriceUiData(),
                    brand = BrandUiData(
                        id = -1,
                        name = "",
                        logoUrl = "",
                    ),
                    category = CategoryUiData(
                        id = -1,
                        nameResId = -1,
                        description = "",
                        logoUrl = "",
                    ),
                ),
                categories = List(5) {
                    CategoryUiData(
                        id = it,
                        nameResId = R.string.field_label_category,
                        description = "",
                        logoUrl = "",
                    )
                },
                brands = List(5) {
                    BrandUiData(
                        id = it,
                        name = "",
                        logoUrl = "",
                    )
                },
                handleEvent = {}
            )
        }
    }
}