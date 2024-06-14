package com.samuraicmdv.featureproductdetails.compose

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.samuraicmdv.common.extension.getMargin
import com.samuraicmdv.common.theme.MobiTheme
import com.samuraicmdv.featureproductdetails.R
import com.samuraicmdv.featureproductdetails.data.BrandUiData
import com.samuraicmdv.featureproductdetails.data.CategoryUiData
import com.samuraicmdv.featureproductdetails.data.ProductPriceUiData
import com.samuraicmdv.featureproductdetails.data.ProductUiData
import com.samuraicmdv.ui.util.ThemePreviews
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
    Box(
        modifier = modifier
            .fillMaxSize()
    ) {
        product?.run {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(MobiTheme.dimens.dimen_1)
            ) {
                // Display product images
                ProductDetailsImageGallery(
                    imageUrls = imageUrls,
                    modifier = Modifier.fillMaxWidth()
                )

                name?.let {
                    Text(
                        text = it,
                        style = MobiTheme.typography.headlineMediumBold,
                        modifier = Modifier
                            .padding(horizontal = MobiTheme.dimens.dimen_2)
                            .fillMaxWidth()
                    )
                }

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

                category?.let {
                    LabelValue(
                        label = "Category",
                        value = stringResource(id = it.nameResId),
                        modifier = Modifier.padding(horizontal = MobiTheme.dimens.dimen_2)
                    )
                }

                Spacer(modifier = Modifier.height(MobiTheme.dimens.dimen_1))

                price?.let {
                    ProductDetailsPriceContent(it)
                }

                shortDescription?.let {
                    Text(
                        text = it,
                        style = MobiTheme.typography.bodyMedium,
                    )
                }

                longDescription?.let {
                    Text(
                        text = it,
                        style = MobiTheme.typography.bodyMedium,
                    )
                }
            }
        } ?: kotlin.run {
            Box {
                Text(text = "Error: Product not found") // TODO handle gracefully
            }
        }
    }
}

@Composable
fun ProductDetailsPriceContent(price: ProductPriceUiData) {
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
    val marginText = "${(price.costPrice to price.sellingPrice).getMargin(2, "", "%")} (preferred: $preferredMargin%)"

    Column {
        Text(
            text = "Pricing",
            style = MobiTheme.typography.titleLargeBold,
            modifier = Modifier
                .padding(horizontal = MobiTheme.dimens.dimen_2)
                .fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(MobiTheme.dimens.dimen_1))

        price.costPrice?.let { sellingPrice ->
            LabelValue(
                label = {
                    Text(
                        text = "cost",
                        style = MobiTheme.typography.titleSmallBold
                    )
                },
                value = {
                    StyledPriceComponent(
                        amount = sellingPrice,
                        priceComponentStyle = PriceComponentStyle.REGULAR,
                        priceComponentWeight = PriceComponentWeight.BOLD,
                        priceComponentLevel = PriceComponentLevel.NEGATIVE,
                        modifier = Modifier
                    )
                },
                modifier = Modifier.padding(horizontal = MobiTheme.dimens.dimen_2)
            )
        }

        Spacer(modifier = Modifier.height(MobiTheme.dimens.dimen_1))

        price.sellingPrice?.let { sellingPrice ->
            LabelValue(
                label = {
                    Text(
                        text = "selling",
                        style = MobiTheme.typography.titleSmallBold
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
                modifier = Modifier.padding(horizontal = MobiTheme.dimens.dimen_2)
            )
        }

        Spacer(modifier = Modifier.height(MobiTheme.dimens.dimen_1))

        IconLabelValue(
            label = "margin",
            value = marginText,
            icon = {
                Icon(
                    imageVector = marginIcon,
                    tint = marginIconColor,
                    contentDescription = null
                )
            },
            modifier = Modifier.padding(horizontal = 16.dp)
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