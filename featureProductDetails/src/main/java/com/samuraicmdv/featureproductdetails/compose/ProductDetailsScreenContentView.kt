package com.samuraicmdv.featureproductdetails.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Error
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.samuraicmdv.common.event.Action
import com.samuraicmdv.common.extension.getMargin
import com.samuraicmdv.common.theme.MobiTheme
import com.samuraicmdv.featureproductdetails.R
import com.samuraicmdv.featureproductdetails.data.BrandUiData
import com.samuraicmdv.featureproductdetails.data.CategoryUiData
import com.samuraicmdv.featureproductdetails.data.ProductPriceUiData
import com.samuraicmdv.featureproductdetails.data.ProductUiData
import com.samuraicmdv.ui.util.ThemePreviews
import com.samuraicmdv.ui.widget.ActionText
import com.samuraicmdv.ui.widget.IconLabelValue
import com.samuraicmdv.ui.widget.LabelValue
import com.samuraicmdv.ui.widget.PriceComponentLevel
import com.samuraicmdv.ui.widget.PriceComponentStyle
import com.samuraicmdv.ui.widget.PriceComponentWeight
import com.samuraicmdv.ui.widget.StyledPriceComponent

@Composable
fun ProductDetailsScreenContentView(
    product: ProductUiData?,
    modifier: Modifier = Modifier
) {
    val scrollState = rememberScrollState()
    Box(
        modifier = modifier
            .fillMaxSize()
    ) {
        product?.run {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(scrollState)
            ) {
                // Display product images
                ProductDetailsImageGallery(
                    imageUrls = imageUrls,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(MobiTheme.dimens.dimen_2))

                name?.let {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = MobiTheme.dimens.dimen_2)
                    ) {
                        Text(
                            text = it,
                            style = MobiTheme.typography.titleMediumBold,
                            modifier = Modifier
                                .weight(1F)
                        )
                        ActionText(
                            action = Action(
                                name = "Edit",
                                label = "Edit",
                                handler = {
                                    /*TODO*/
                                }
                            ),
                            modifier = Modifier.align(Alignment.CenterVertically)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(MobiTheme.dimens.dimen_1))
                brand?.let { brand ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(MobiTheme.dimens.dimen_1),
                        modifier = Modifier.padding(horizontal = MobiTheme.dimens.dimen_2)
                    ) {
                        Image(
                            painter = rememberAsyncImagePainter(model = brand.logoUrl),
                            contentDescription = null,
                            contentScale = ContentScale.Fit,
                            modifier = Modifier
                                .size(42.dp)
                                .clip(RoundedCornerShape(MobiTheme.dimens.dimen_0_5))
                        )

                        Text(
                            text = brand.name,
                            style = MobiTheme.typography.bodyLarge,
                            modifier = Modifier
                        )
                    }
                }

                Spacer(modifier = Modifier.height(MobiTheme.dimens.dimen_1))

                category?.let {
                    LabelValue(
                        label = "Category",
                        value = stringResource(id = it.nameResId),
                        modifier = Modifier.padding(horizontal = MobiTheme.dimens.dimen_2)
                    )
                }

                Spacer(modifier = Modifier.height(MobiTheme.dimens.dimen_3))

                price?.let {
                    ProductDetailsPriceContent(it)
                }

                Spacer(modifier = Modifier.height(MobiTheme.dimens.dimen_2))

                shortDescription?.let {
                    Text(
                        text = "Short description",
                        style = MobiTheme.typography.titleSmallBold,
                        modifier = Modifier.padding(horizontal = MobiTheme.dimens.dimen_2)
                    )
                    Spacer(modifier = Modifier.height(MobiTheme.dimens.dimen_1))
                    Text(
                        text = it,
                        style = MobiTheme.typography.bodyMedium,
                        modifier = Modifier.padding(horizontal = MobiTheme.dimens.dimen_2)
                    )
                }

                Spacer(modifier = Modifier.height(MobiTheme.dimens.dimen_2))

                longDescription?.let {
                    Text(
                        text = "Long description",
                        style = MobiTheme.typography.titleSmallBold,
                        modifier = Modifier.padding(horizontal = MobiTheme.dimens.dimen_2)
                    )
                    Spacer(modifier = Modifier.height(MobiTheme.dimens.dimen_1))
                    Text(
                        text = it,
                        style = MobiTheme.typography.bodyMedium,
                        modifier = Modifier.padding(horizontal = MobiTheme.dimens.dimen_2)
                    )
                }

                Spacer(modifier = Modifier.height(MobiTheme.dimens.dimen_2))

                LabelValue(
                    label = "Model",
                    value = product.model,
                    action = Action(
                        name = "Edit",
                        label = "Edit",
                        handler = {
                            /*TODO*/
                        }
                    ),
                    modifier = Modifier.padding(horizontal = MobiTheme.dimens.dimen_2)
                )

                Spacer(modifier = Modifier.height(MobiTheme.dimens.dimen_2))

                product.code?.let { productCode ->
                    LabelValue(
                        label = "Code",
                        value = productCode,
                        action = Action(
                            name = "Edit",
                            label = "Edit",
                            handler = {
                                /*TODO*/
                            }
                        ),
                        modifier = Modifier.padding(horizontal = MobiTheme.dimens.dimen_2)
                    )
                    Spacer(modifier = Modifier.height(MobiTheme.dimens.dimen_2))
                }

                LabelValue(
                    label = "SKU",
                    value = product.sku,
                    action = Action(
                        name = "Edit",
                        label = "Edit",
                        handler = {
                            /*TODO*/
                        }
                    ),
                    modifier = Modifier.padding(horizontal = MobiTheme.dimens.dimen_2)
                )

                Spacer(modifier = Modifier.height(MobiTheme.dimens.dimen_8))
            }
        } ?: kotlin.run {
            Box {
                Text(text = "Error: Product not found") // TODO handle gracefully
            }
        }
    }
}

@Composable
fun ProductDetailsPriceContent(
    price: ProductPriceUiData,
    modifier: Modifier = Modifier,
) {
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
                }
            ),
            modifier = Modifier.align(Alignment.End)
        )
    }
}

@ThemePreviews
@Composable
fun PreviewProductDetailsScreenContentView() {
    MobiTheme {
        Surface {
            ProductDetailsScreenContentView(
                product = ProductUiData(
                    id = 1,
                    name = "Product Name",
                    shortDescription = "Product Description",
                    longDescription = "Product Description",
                    imageUrls = listOf("https://picsum.photos/200/300"),
                    brand = BrandUiData(
                        id = 1,
                        name = "Brand Name",
                        logoUrl = "https://picsum.photos/200/300"
                    ),
                    category = CategoryUiData(
                        id = 1,
                        nameResId = R.string.field_label_category,
                        description = "Category Description",
                        logoUrl = "https://picsum.photos/200/300"
                    ),
                    price = ProductPriceUiData(
                        sellingPrice = 7800.04,
                        currency = "USD",
                        costPrice = 1256.45,
                        preferredMargin = 65
                    )
                ),
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}