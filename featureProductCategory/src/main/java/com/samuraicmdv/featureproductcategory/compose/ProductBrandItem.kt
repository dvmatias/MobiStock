package com.samuraicmdv.featureproductcategory.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import com.samuraicmdv.featureproductcategory.R
import com.samuraicmdv.featureproductcategory.state.ProductBrandUiData
import com.samuraicmdv.featureproductcategory.theme.AppTheme
import com.samuraicmdv.featureproductcategory.theme.AppTypography
import com.samuraicmdv.ui.util.ThemePreviews

@Composable
fun ProductBrandItem(
    brand: ProductBrandUiData,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.padding(horizontal = AppTheme.dimens.dimen_2)
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo_1),
            contentDescription = null,
            modifier = Modifier
                .clip(
                    RoundedCornerShape(AppTheme.dimens.dimen_2)
                )
                .size(AppTheme.dimens.dimen_7)
                .background(AppTheme.colors.onPrimary)
        )
        Spacer(modifier = Modifier.size(AppTheme.dimens.dimen_1))
        Text(text = brand.name.uppercase(), style = AppTheme.typography.bodySmall, fontWeight = FontWeight.Bold)
    }
}

@ThemePreviews
@Composable
fun PreviewProductBrand(modifier: Modifier = Modifier) {
    AppTheme {
        Surface {
            ProductBrandItem(
                brand = ProductBrandUiData(
                    id = "1",
                    name = "Brand Name",
                    logoUrl = "https://www.example.com/image.jpg"
                ),
                modifier = modifier
            )
        }
    }
}