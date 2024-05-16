package com.samuraicmdv.featureproductcategory.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.samuraicmdv.featureproductcategory.R
import com.samuraicmdv.featureproductcategory.state.ProductBrandUiData
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
                .padding(horizontal = AppTheme.dimens.dimen_1, vertical = AppTheme.dimens.dimen_1)
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo_1),
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp)
                    .clip(RoundedCornerShape(AppTheme.dimens.dimen_2))
                    .background(AppTheme.colors.onPrimary)
            )
            Column(
                modifier = Modifier
                    .weight(1F)
                    .padding(horizontal = AppTheme.dimens.dimen_1)
            ) {
                Text(text = product.name, style = AppTheme.typography.bodyLarge, fontWeight = FontWeight.Bold)
                Text(text = product.description, style = AppTheme.typography.bodyMedium)

                Spacer(modifier = Modifier.height(AppTheme.dimens.dimen_1))

                Row {
                    Image(
                        painter = painterResource(id = R.drawable.in_stock_ic),
                        contentDescription = null,
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(AppTheme.dimens.dimen_0_75))
                    Text(text = product.stock.toString(), style = AppTheme.typography.bodyMedium)
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
                    id = "1",
                    name = "Product Name",
                    description = "Product Description",
                    imageUrl = "https://www.example.com/image.jpg",
                    sellingPrice = 100.0,
                    costPrice = 50.0,
                    currency = "USD",
                    rating = 4.5,
                    reviews = 100,
                    isFavorite = true,
                    stock = 100,
                    brand = ProductBrandUiData(
                        id = "1",
                        name = "Brand",
                        logoUrl = "https://www.example.com/image.jpg"
                    )
                ),
            )
        }
    }
}