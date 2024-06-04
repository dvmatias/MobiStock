package com.samuraicmdv.featureproductdetails.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.samuraicmdv.common.EMPTY_STRING
import com.samuraicmdv.common.theme.MobiTheme
import com.samuraicmdv.featureproductdetails.R
import com.samuraicmdv.featureproductdetails.data.BrandUiData
import com.samuraicmdv.featureproductdetails.data.CategoryUiData
import com.samuraicmdv.featureproductdetails.data.ProductPriceUiData
import com.samuraicmdv.featureproductdetails.data.ProductUiData
import com.samuraicmdv.featureproductdetails.event.ProductDetailsEvent
import com.samuraicmdv.featureproductdetails.event.ProductDetailsPresentationEvent
import com.samuraicmdv.ui.util.ThemePreviews

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
    var name by remember {
        mutableStateOf(product?.name ?: EMPTY_STRING)
    }
    var model by remember {
        mutableStateOf(product?.model ?: EMPTY_STRING)
    }
    var code by remember {
        mutableStateOf(product?.code ?: EMPTY_STRING)
    }
    var sku by remember {
        mutableStateOf(product?.sku ?: EMPTY_STRING)
    }
    var shortDescription by remember {
        mutableStateOf(product?.shortDescription ?: EMPTY_STRING)
    }
    var longDescription by remember {
        mutableStateOf(product?.longDescription ?: EMPTY_STRING)
    }
    var category by remember {
        mutableStateOf(product?.category)
    }
    var brand by remember {
        mutableStateOf(product?.brand)
    }
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

                // General section
                ProductDetailsScreenContentEditGeneralSection(
                    focusManager = focusManager,
                    name = name,
                    onNameChange = { newName ->
                        name = newName
                    },
                    model = model,
                    onModelChange = { newModel ->
                        model = newModel
                    },
                    code = code,
                    onCodeChange = { newCode ->
                        code = newCode
                    }
                )

                Spacer(modifier = Modifier.height(MobiTheme.dimens.dimen_4))

                // Prices section
                ProductDetailsScreenContentEditPriceSection(
                    focusManager = focusManager,
                    costPrice = costPrice,
                    onCostPriceChange = { newCostPrice ->
                        costPrice = newCostPrice
                    },
                    sellingPrice = sellingPrice,
                    onSellingPriceChange = { newSellingPrice ->
                        sellingPrice = newSellingPrice
                    },
                    margin = margin,
                    onMarginChange = { newMargin ->
                        margin = newMargin
                    }
                )


                Spacer(modifier = Modifier.height(MobiTheme.dimens.dimen_4))

                // Product specifics section
                ProductDetailsScreenContentEditSpecificsSection(
                    focusManager = focusManager,
                    categories = categories,
                    onSelectedCategory = { newCategory ->
                        category = newCategory
                    },
                    brands = brands,
                    onSelectedBrand = { newBrand ->
                        brand = newBrand
                    },
                    sku = sku,
                    onSkuChange = { newSku ->
                        sku = newSku
                    },
                    shortDescription = shortDescription,
                    onShortDescriptionChange = { newShortDescription ->
                        shortDescription = newShortDescription
                    },
                    longDescription = longDescription,
                    onLongDescriptionChange = { newLongDescription ->
                        longDescription = newLongDescription
                    }
                )

                Spacer(modifier = Modifier.height(MobiTheme.dimens.dimen_8))
            }

            // Create Product/Save button
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