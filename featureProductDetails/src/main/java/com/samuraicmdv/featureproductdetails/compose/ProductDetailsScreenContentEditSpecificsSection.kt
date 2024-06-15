package com.samuraicmdv.featureproductdetails.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.samuraicmdv.common.EMPTY_STRING
import com.samuraicmdv.common.SPACE_STRING
import com.samuraicmdv.common.theme.MobiTheme
import com.samuraicmdv.featureproductdetails.R
import com.samuraicmdv.featureproductdetails.data.BrandUiData
import com.samuraicmdv.featureproductdetails.data.CategoryUiData
import com.samuraicmdv.ui.util.ThemePreviews
import com.samuraicmdv.ui.widget.MobiTextField

private const val SHORT_DESCRIPTION_MAX_LENGTH = 128
private const val LONG_DESCRIPTION_MAX_LENGTH = 256

@Composable
fun ProductDetailsScreenContentEditSpecificsSection(
    focusManager: FocusManager,
    categories: List<CategoryUiData>?,
    onSelectedCategory: (CategoryUiData) -> Unit,
    categoryError: String?,
    brands: List<BrandUiData>?,
    onSelectedBrand: (BrandUiData) -> Unit,
    brandError: String?,
    sku: String,
    onSkuChange: (String) -> Unit,
    shortDescription: String,
    onShortDescriptionChange: (String) -> Unit,
    longDescription: String,
    onLongDescriptionChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = stringResource(id = R.string.title_product_specifics),
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
                defaultOptionTitle = stringResource(id = R.string.option_dropdown_menu_category_default),
                error = categoryError
            ) { selectedCategory ->
                onSelectedCategory(selectedCategory)
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
                error = brandError,
                defaultOptionTitle = stringResource(id = R.string.option_dropdown_menu_brand_default)
            ) { selectedBrand ->
                onSelectedBrand(selectedBrand)
            }
        }

        // SKU
        Spacer(modifier = Modifier.height(MobiTheme.dimens.dimen_3))
        MobiTextField(
            value = sku,
            onValueChange = {
                onSkuChange(it)
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
                    onShortDescriptionChange(newShortDescription)
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
            text = stringResource(id = R.string.field_label_long_description).uppercase(),
            style = MobiTheme.typography.labelMediumBold,
        )
        Spacer(modifier = Modifier.height(MobiTheme.dimens.dimen_1))
        OutlinedTextField(
            value = longDescription,
            onValueChange = { newLongDescription ->
                if (newLongDescription.length <= LONG_DESCRIPTION_MAX_LENGTH) {
                    onLongDescriptionChange(newLongDescription)
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
    }
}

@ThemePreviews
@Composable
fun PreviewProductDetailsScreenContentEditSpecificsSection() {
    MobiTheme {
        Surface {
            ProductDetailsScreenContentEditSpecificsSection(
                focusManager = LocalFocusManager.current,
                categories = List(5) {
                    CategoryUiData(
                        id = it,
                        nameResId = R.string.field_label_category,
                        description = EMPTY_STRING,
                        logoUrl = EMPTY_STRING,
                    )
                },
                onSelectedCategory = {},
                categoryError = null,
                brands = List(5) {
                    BrandUiData(
                        id = it,
                        name = EMPTY_STRING,
                        logoUrl = EMPTY_STRING,
                    )
                },
                brandError = null,
                onSelectedBrand = {},
                sku = EMPTY_STRING,
                onSkuChange = {},
                shortDescription = EMPTY_STRING,
                onShortDescriptionChange = {},
                longDescription = EMPTY_STRING,
                onLongDescriptionChange = {},
                modifier = Modifier
            )
        }
    }
}