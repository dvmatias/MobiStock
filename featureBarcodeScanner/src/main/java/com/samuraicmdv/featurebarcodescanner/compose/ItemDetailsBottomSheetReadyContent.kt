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
import com.samuraicmdv.featurebarcodescanner.R
import com.samuraicmdv.featurebarcodescanner.preview.ItemDetailsBottomSheetReadyContentPreviewParameter
import com.samuraicmdv.featurebarcodescanner.state.ItemDetailsUiData
import com.samuraicmdv.ui.util.ThemePreviews
import com.samuraicmdv.ui.widget.PriceComponentLevel
import com.samuraicmdv.ui.widget.PriceComponentStyle
import com.samuraicmdv.ui.widget.PriceComponentWeight
import com.samuraicmdv.ui.widget.StyledPriceComponent

private val itemImageSize = 150.dp
private val brandLogoSize = 24.dp

/**
 *  This composable function displays the content of the item details bottom sheet when the item data is ready.
 *
 *  @param uiData The item details data to be displayed in the bottom sheet.
 *  @param modifier The modifier to be applied to the content layout.
 */
@Composable
fun ItemDetailsBottomSheetReadyContent(
    uiData: ItemDetailsUiData,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        // Brand
        Row(
            horizontalArrangement = Arrangement.spacedBy(space = MobiTheme.dimens.dimen_1),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = rememberAsyncImagePainter(model = uiData.brandLogoUrl),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .size(brandLogoSize)
                    .clip(RoundedCornerShape(MobiTheme.dimens.dimen_0_5))
                    .background(MobiTheme.colors.disabledContainerColor)
            )

            Text(
                text = uiData.brandName,
                style = MobiTheme.typography.bodyMedium
            )

        }

        Spacer(modifier = Modifier.height(MobiTheme.dimens.dimen_1))

        Row(
            modifier = Modifier
                .height(itemImageSize)
        ) {
            // Thumbnail image
            ElevatedCard(
                elevation = CardDefaults.elevatedCardElevation(
                    defaultElevation =1.dp
                ),
                modifier = Modifier
                    .size(itemImageSize)
            ) {
                Image(
                    painter = rememberAsyncImagePainter(model = uiData.thumbnailUrl),
                    contentDescription = null,
                    modifier = Modifier
                        .aspectRatio(1F)
                        .background(MobiTheme.colors.disabledContainerColor)
                )
            }

            Spacer(modifier = Modifier.width(MobiTheme.dimens.dimen_1_5))

            Column(
                verticalArrangement = Arrangement.spacedBy(space = MobiTheme.dimens.dimen_1),
                modifier = Modifier.wrapContentHeight()
            ) {
                // Title
                Text(
                    text = uiData.title,
                    maxLines = 2,
                    overflow = androidx.compose.ui.text.style.TextOverflow.Ellipsis,
                    style = MobiTheme.typography.bodyLargeBold,
                )

                // Product category/subcategory
                Text(
                    text = uiData.categorySubcategory,
                    style = MobiTheme.typography.bodyMedium
                )

                // Code
                Text(
                    text = "Code ${uiData.code}",
                    style = MobiTheme.typography.bodyMedium
                )

                Spacer(modifier = Modifier.weight(1f))

                // Price
                StyledPriceComponent(
                    amount = uiData.price,
                    priceComponentWeight = PriceComponentWeight.BOLD,
                    priceComponentStyle = PriceComponentStyle.MEDIUM,
                    priceComponentLevel = PriceComponentLevel.DISPLAY,
                )
            }
        }

        // Stock
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.width(itemImageSize)
        ) {
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
                        text = "In stock: ${uiData.stock}",
                        style = MobiTheme.typography.bodyMedium
                    )
                },
                modifier = Modifier
            )
        }

        HorizontalDivider(
            modifier = Modifier
                .padding(top = MobiTheme.dimens.dimen_1)
                .padding(bottom = MobiTheme.dimens.dimen_2)
                .padding(horizontal = MobiTheme.dimens.dimen_2),
            thickness = MobiTheme.dimens.dividerThickness,
            color = MobiTheme.colors.outlineVariant
        )

        // Description
        Text(
            text = uiData.description,
            style = MobiTheme.typography.bodyMedium,
        )

        Spacer(modifier = Modifier.height(MobiTheme.dimens.dimen_2))

        // Button to navigate to item details
        Button(
            onClick = {
                // TODO handleEvent(CategoryNavigationEvent.NavigateProductDetails(false, item.id))
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
fun PreviewItemDetailsBottomSheetReadyContent(
    @PreviewParameter(ItemDetailsBottomSheetReadyContentPreviewParameter::class) previewData: ItemDetailsUiData
) {
    MobiTheme {
        Surface(color = MobiTheme.colors.background) {
            ItemDetailsBottomSheetReadyContent(
                uiData = previewData
            )
        }
    }
}