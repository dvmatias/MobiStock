package com.samuraicmdv.featureproductcategory.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.samuraicmdv.featureproductcategory.R
import com.samuraicmdv.featureproductcategory.state.ProductBrandUiData
import com.samuraicmdv.featureproductcategory.state.ProductPriceUiData
import com.samuraicmdv.featureproductcategory.state.ProductUiData
import com.samuraicmdv.featureproductcategory.theme.AppTheme
import com.samuraicmdv.ui.util.ThemePreviews

@Composable
fun ProductItem(
    product: ProductUiData,
    modifier: Modifier = Modifier
) {

    Surface(
        color = AppTheme.colors.surfaceContainer,
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(AppTheme.dimens.dimen_2))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
                .padding(horizontal = AppTheme.dimens.dimen_1, vertical = AppTheme.dimens.dimen_1)
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo_1),
                contentDescription = null,
                modifier = Modifier
                    .aspectRatio(1F)
                    .clip(RoundedCornerShape(AppTheme.dimens.dimen_2))
                    .background(AppTheme.colors.onPrimary)
            )
            Column(
                modifier = Modifier
                    .weight(1F)
                    .wrapContentHeight()
                    .padding(horizontal = AppTheme.dimens.dimen_1),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = product.name,
                    style = AppTheme.typography.bodyMediumBold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.fillMaxWidth()
                )
                Text(
                    text = product.description,
                    style = AppTheme.typography.bodySmall,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                )

                Spacer(modifier = Modifier.height(AppTheme.dimens.dimen_1))

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.in_stock_ic),
                        contentDescription = null,
                        colorFilter = ColorFilter.tint(color = AppTheme.colors.onSurface),
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(AppTheme.dimens.dimen_0_5))
                    Text(text = product.stock.toString(), style = AppTheme.typography.bodyMedium)
                }

                Spacer(modifier = Modifier.weight(1F))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(AppTheme.dimens.dimen_1),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = stringResource(
                            id = R.string.product_item_earnings_placeholder,
                            product.price.sellingPrice / product.price.costPrice
                        ),
                        style = AppTheme.typography.labelSmallBold,
                    )
                    Text(text = "$${product.price.costPrice}", style = AppTheme.typography.bodyMedium)
                    Text(text = "$${product.price.sellingPrice}", style = AppTheme.typography.bodyMediumBold)
                }
            }
        }
    }
}

@ThemePreviews
@Composable
fun PreviewProductItem() {
    AppTheme {
        Surface {
            ProductItem(
                product = ProductUiData(
                    id = 1,
                    name = "Product Name",
                    description = "Product Description",
                    imageUrl = "https://www.example.com/image.jpg",
                    price = ProductPriceUiData(
                        sellingPrice = 100.0,
                        costPrice = 50.0,
                        currency = "$",
                    ),
                    rating = 4.5,
                    reviews = 100,
                    isFavorite = true,
                    stock = 100,
                    brand = ProductBrandUiData(
                        id = 1,
                        name = "Brand",
                        logoUrl = "https://www.example.com/image.jpg"
                    ),
                    model = "Model",
                    code = "Code"
                ),
            )
        }
    }
}