package com.samuraicmdv.featurecategory.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.samuraicmdv.common.theme.MobiTheme
import com.samuraicmdv.featurecategory.R
import com.samuraicmdv.featurecategory.event.CategoryEvent
import com.samuraicmdv.featurecategory.event.CategoryPresentationEvent
import com.samuraicmdv.featurecategory.state.ProductBrandUiData
import com.samuraicmdv.featurecategory.state.ProductPriceUiData
import com.samuraicmdv.featurecategory.state.ProductStockUiData
import com.samuraicmdv.featurecategory.state.ProductUiData
import com.samuraicmdv.ui.util.ThemePreviews
import com.samuraicmdv.ui.widget.PriceComponentLevel
import com.samuraicmdv.ui.widget.PriceComponentStyle
import com.samuraicmdv.ui.widget.PriceComponentWeight
import com.samuraicmdv.ui.widget.StyledPriceComponent

@Composable
fun ProductItem(
    product: ProductUiData,
    handleEvent: (CategoryEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        shape = RoundedCornerShape(MobiTheme.dimens.dimen_2),
        color = MobiTheme.colors.background,
        modifier = modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .clickable {
                    handleEvent(CategoryPresentationEvent.HandleProductDetailsBottomSheetState(true, product))
                }
                .fillMaxWidth()
                .height(140.dp)
                .padding(horizontal = MobiTheme.dimens.dimen_1, vertical = MobiTheme.dimens.dimen_1)
        ) {
            ElevatedCard(
                elevation = CardDefaults.elevatedCardElevation(
                    defaultElevation = .5.dp
                ),
            ) {
                Image(
                    painter = rememberAsyncImagePainter(model = product.thumbnailUrl),
                    contentDescription = null,
                    modifier = Modifier
                        .aspectRatio(1F)
                        .background(MobiTheme.colors.onPrimary)
                )
            }

            Column(
                modifier = Modifier
                    .weight(1F)
                    .wrapContentHeight()
                    .padding(horizontal = MobiTheme.dimens.dimen_1),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                product.name?.let {
                    Text(
                        text = it,
                        style = MobiTheme.typography.bodyMedium,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
                Spacer(modifier = Modifier.height(MobiTheme.dimens.dimen_0_75))
                product.shortDescription?.let {
                    Text(
                        text = it,
                        style = MobiTheme.typography.bodySmall,
                        color = MobiTheme.colors.textSecondary,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                    )
                }

                Spacer(modifier = Modifier.height(MobiTheme.dimens.dimen_1))

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.in_stock_ic),
                        contentDescription = null,
                        colorFilter = ColorFilter.tint(color = MobiTheme.colors.onSurface),
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(MobiTheme.dimens.dimen_0_5))
                    Text(
                        text = product.stock?.quantity.toString(),
                        style = MobiTheme.typography.bodyMedium,
                        color = MobiTheme.colors.textSecondary,
                    )
                }

                Spacer(modifier = Modifier.weight(1F))

                product.price?.sellingPrice?.let { sellingPrice ->
                    StyledPriceComponent(
                        amount = sellingPrice,
                        priceComponentWeight = PriceComponentWeight.NORMAL,
                        priceComponentStyle = PriceComponentStyle.REGULAR,
                        priceComponentLevel = PriceComponentLevel.POSITIVE,
                        modifier = Modifier.align(Alignment.Start)
                    )
                }
            }
        }
    }
}

@ThemePreviews
@Composable
fun PreviewProductItem() {
    MobiTheme {
        Surface {
            ProductItem(
                product = ProductUiData(
                    id = 1,
                    name = "Product Name",
                    shortDescription = "Product Description",
                    imageUrls = listOf(),
                    price = ProductPriceUiData(
                        sellingPrice = 100.0,
                        costPrice = 50.0,
                        currency = "ARS",
                    ),
                    rating = 4.5,
                    reviews = 100,
                    isFavorite = true,
                    stock = ProductStockUiData(
                        quantity = 100,
                        low = 10,
                        min = 5
                    ),
                    brand = ProductBrandUiData(
                        id = 1,
                        name = "Brand",
                        logoUrl = "https://www.example.com/image.jpg"
                    ),
                    model = "Model",
                    code = "Code",
                    sku = "ABCD-00000001",
                ),
                handleEvent = {},
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}