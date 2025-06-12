package com.samuraicmdv.featurebarcodescanner.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.samuraicmdv.common.theme.MobiTheme
import com.samuraicmdv.common.uidata.ProductUiData
import com.samuraicmdv.featurebarcodescanner.R
import com.samuraicmdv.featurebarcodescanner.preview.ProductDetailsBottomSheetReadyContentPreviewParameter
import com.samuraicmdv.ui.util.ThemePreviews
import com.samuraicmdv.ui.widget.PriceComponentLevel
import com.samuraicmdv.ui.widget.PriceComponentStyle
import com.samuraicmdv.ui.widget.PriceComponentWeight
import com.samuraicmdv.ui.widget.StyledPriceComponent

/**
 *  This composable function displays the content of the product details bottom sheet when the product data is ready.
 *
 *  @param uiData The product details data to be displayed in the bottom sheet.
 *  @param modifier The modifier to be applied to the content layout.
 */
@Composable
fun ProductDetailsBottomSheetReadyContent(
    uiData: ProductUiData,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.wrapContentHeight()) {

        Row(modifier = modifier.height(160.dp)) {
            Column {
                // Thumbnail image
                uiData.thumbnailUrl?.let {
                    ElevatedCard(
                        elevation = CardDefaults.elevatedCardElevation(
                            defaultElevation = 1.dp
                        ),
                        modifier = Modifier
                            .size(160.dp)
                    ) {
                        Image(
                            painter = rememberAsyncImagePainter(model = it),
                            contentDescription = null,
                            modifier = Modifier
                                .aspectRatio(1F)
                                .background(MobiTheme.colors.surfaceContainer)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.width(MobiTheme.dimens.dimen_1))

            Column(
                modifier = Modifier.wrapContentHeight()
            ) {
                // Brand
                Row(
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    uiData.brand?.logoUrl?.let { brandLogoUrl ->
                        Image(
                            painter = rememberAsyncImagePainter(model = brandLogoUrl),
                            contentDescription = null,
                            contentScale = ContentScale.Fit,
                            modifier = Modifier
                                .size(36.dp)
                                .clip(RoundedCornerShape(MobiTheme.dimens.dimen_0_5))
                        )
                    }
                    Spacer(modifier = Modifier.width(MobiTheme.dimens.dimen_1))
                    uiData.brand?.name?.let { brandName ->
                        Text(
                            text = brandName,
                            style = MobiTheme.typography.bodyMedium
                        )
                    }
                }

                // Name
                uiData.name?.let { productName ->
                    Spacer(modifier = Modifier.height(MobiTheme.dimens.dimen_0_5))
                    Text(
                        text = productName,
                        maxLines = 2,
                        overflow = androidx.compose.ui.text.style.TextOverflow.Ellipsis,
                        style = MobiTheme.typography.titleSmallBold
                    )
                    Spacer(modifier = Modifier.height(MobiTheme.dimens.dimen_0_5))
                }

                // Product category/subcategory and brand
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    // Category
                    uiData.productCategoryName?.let {
                        Text(
                            text = it,
                            style = MobiTheme.typography.bodyMedium
                        )
                    }

                    // Subcategory with " - " separator
                    uiData.productSubcategoryName?.let {
                        uiData.productCategoryName?.let {
                            Text(
                                text = "-",
                                style = MobiTheme.typography.bodySmall,
                                modifier = Modifier.padding(horizontal = MobiTheme.dimens.dimen_0_5)
                            )
                        }
                        Text(
                            text = it,
                            style = MobiTheme.typography.bodySmall
                        )
                    }
                }

                // Code
                uiData.code?.let { productCode ->
                    Spacer(modifier = Modifier.height(MobiTheme.dimens.dimen_0_5))
                    Text(
                        text = "Code $productCode",
                        style = MobiTheme.typography.bodySmall
                    )
                }

                Spacer(modifier = Modifier.weight(1f))
                // Price
                uiData.price?.sellingPrice?.let { price ->
                    StyledPriceComponent(
                        amount = price,
                        priceComponentWeight = PriceComponentWeight.BOLD,
                        priceComponentStyle = PriceComponentStyle.MEDIUM,
                        priceComponentLevel = PriceComponentLevel.DISPLAY,
                    )
                }
            }
        }

        // Stock
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.width(160.dp)
        ) {
            uiData.stock?.quantity.let {
                AssistChip(
                    onClick = {},
                    border = null,
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = com.samuraicmdv.common.R.drawable.in_stock_ic),
                            contentDescription = null,
                            modifier = Modifier
                                .size(24.dp)
                        )
                    },
                    label = {
                        Text(
                            text = "In stock: $it",
                            style = MobiTheme.typography.bodyMedium
                        )
                    },
                    modifier = Modifier
                )
            }
        }

        HorizontalDivider(
            modifier = Modifier
                .padding(top = MobiTheme.dimens.dimen_1)
                .padding(bottom = MobiTheme.dimens.dimen_2),
            thickness = MobiTheme.dimens.dividerThickness,
            color = MobiTheme.colors.outlineVariant
        )

        // Long description
        uiData.longDescription?.let {
            Text(
                text = it,
                style = MobiTheme.typography.bodyMedium,
            )
            Spacer(modifier = Modifier.height(MobiTheme.dimens.dimen_2))
        }

        Button(
            onClick = {
                // TODO handleEvent(CategoryNavigationEvent.NavigateProductDetails(false, product.id))
            },
            enabled = true, // TODO isAdmin,
            shape = RoundedCornerShape(MobiTheme.dimens.dimen_1_5),
            modifier = Modifier
                .padding(vertical = MobiTheme.dimens.dimen_2)
                .fillMaxWidth()
                .height(48.dp)
        ) {
            Text(
                text = stringResource(id = R.string.label_product_details_button),
                style = MobiTheme.typography.buttonLabel
            )
        }
    }
}

@ThemePreviews
@Composable
fun PreviewProductDetailsBottomSheetReadyContent(
    @PreviewParameter(ProductDetailsBottomSheetReadyContentPreviewParameter::class) previewData: ProductUiData
) {
    MobiTheme {
        Surface(color = MobiTheme.colors.background) {
            ProductDetailsBottomSheetReadyContent(
                uiData = previewData
            )
        }
    }
}