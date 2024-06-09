package com.samuraicmdv.featureproductdetails.compose

import android.content.Context
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import com.samuraicmdv.common.EMPTY_STRING
import com.samuraicmdv.common.extension.getMargin
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
    val context = LocalContext.current
    var name by remember {
        mutableStateOf(product?.name ?: EMPTY_STRING)
    }
    var nameError: String? by remember {
        mutableStateOf(null)
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
    var categoryError: String? by remember {
        mutableStateOf(null)
    }
    var brand by remember {
        mutableStateOf(product?.brand)
    }
    var brandError: String? by remember {
        mutableStateOf(null)
    }
    var margin by remember {
        mutableIntStateOf(65) // TODO product?.price?.preferredMargin with 65 as default
    }
    var cost by remember {
        mutableStateOf(product?.price?.costPrice?.toString() ?: EMPTY_STRING)
    }
    var costError: String? by remember {
        mutableStateOf(null)
    }
    var revenue by remember {
        mutableStateOf(product?.price?.sellingPrice?.toString() ?: EMPTY_STRING)
    }
    var revenueError: String? by remember {
        mutableStateOf(null)
    }


    var validateFormToCreateProduct by rememberSaveable {
        mutableStateOf(false)
    }
    var isFormValid by rememberSaveable {
        mutableStateOf(false)
    }

    LaunchedEffect(key1 = validateFormToCreateProduct) {
        if (validateFormToCreateProduct) {
            val isValidName = validateName(context, name) { error -> nameError = error }
            val isValidCost = validateCost(context, cost) { error -> costError = error }
            val isValidRevenue = validateRevenue(context, revenue, cost, margin) { error -> revenueError = error }
            val isValidCategory = validateCategory(context, category) { error -> categoryError = error }
            val isValidBrand = validateBrand(context, brand) { error -> brandError = error }

            isFormValid = isValidName && isValidRevenue && isValidCost && isValidCategory && isValidBrand

            if (isFormValid)
                handleEvent(
                    ProductDetailsPresentationEvent.CreateNewProduct(
                        product = ProductUiData(
                            id = -1, // When creating a product there is no ID associated with it
                            name = name,
                            shortDescription = shortDescription,
                            longDescription = longDescription,
                            model = model,
                            code = code,
                            sku = sku,
                            thumbnailUrl = EMPTY_STRING,
                            imageUrls = emptyList(),
                            price = ProductPriceUiData(
                                sellingPrice = revenue.toDouble(),
                                costPrice = cost.toDouble(),
                                preferredMargin = margin
                            ),
                            brand = brand,
                            category = category
                        )
                    )
                )
            // Form validations ended up
            validateFormToCreateProduct = false
        }
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
                        nameError = EMPTY_STRING
                    },
                    nameError = nameError,
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
                    cost = cost,
                    onCostChange = {
                        cost = it
                        costError = EMPTY_STRING
                    },
                    costError = costError,
                    revenue = revenue,
                    revenueError = revenueError,
                    onRevenueChange = {
                        revenue = it
                        revenueError = EMPTY_STRING
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
                        categoryError = null
                    },
                    categoryError = categoryError,
                    brands = brands,
                    onSelectedBrand = { newBrand ->
                        brand = newBrand
                        brandError = null
                    },
                    brandError = brandError,
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
                    validateFormToCreateProduct = true
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
                    text = stringResource(id = R.string.button_label_save).uppercase(),
                    style = MobiTheme.typography.buttonLabel
                )
            }
        }
    }
}

private fun validateName(
    context: Context,
    name: String,
    onNameError: (String) -> Unit,
): Boolean {
    if (name.isEmpty()) {
        onNameError(ContextCompat.getString(context, R.string.field_error_required))
        return false
    }
    if (name.length < 4) {
        onNameError(ContextCompat.getString(context, R.string.field_error_name_short))
        return false
    }
    return true
}

private fun validateCost(
    context: Context,
    cost: String,
    onCostError: (String) -> Unit,
): Boolean {
    if (cost.isEmpty()) {
        onCostError(ContextCompat.getString(context, R.string.field_error_required))
        return false
    }
    if (cost.toDouble() <= 0.0) {
        onCostError(ContextCompat.getString(context, R.string.field_error_cost_invalid_amount))
        return false
    }
    return true
}

/**
 * @param revenue The selling price of the product set in the form.
 * @param cost The cost price of the product set in the form.
 * @param margin The selected margin in the form.
 */
private fun validateRevenue(
    context: Context,
    revenue: String,
    cost: String,
    margin: Int,
    onRevenueError: (String) -> Unit,
): Boolean {
    if (revenue.isEmpty()) {
        onRevenueError(ContextCompat.getString(context, R.string.field_error_required))
        return false
    }
    if (revenue.toDouble() <= 0.0) {
        onRevenueError(ContextCompat.getString(context, R.string.field_error_revenue_invalid_amount))
        return false
    }
    val realMargin = (cost.toDouble() to revenue.toDouble()).getMargin(2)
    if (realMargin < margin) {
        onRevenueError(ContextCompat.getString(context, R.string.field_error_revenue_low))
        return false
    }
    return true
}

private fun validateCategory(
    context: Context,
    category: CategoryUiData?,
    onCategoryError: (String) -> Unit,
): Boolean {
    if (category?.id == -1) {
        onCategoryError(ContextCompat.getString(context, R.string.field_error_category_required))
        return false
    }
    return true
}

private fun validateBrand(
    context: Context,
    brand: BrandUiData?,
    onBrandError: (String) -> Unit,
): Boolean {
    if (brand?.id == -1) {
        onBrandError(ContextCompat.getString(context, R.string.field_error_brand_required))
        return false
    }
    return true
}

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