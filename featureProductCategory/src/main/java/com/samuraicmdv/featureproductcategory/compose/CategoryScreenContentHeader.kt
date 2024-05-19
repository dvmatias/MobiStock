package com.samuraicmdv.featureproductcategory.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import com.samuraicmdv.common.theme.MobiTheme
import com.samuraicmdv.featureproductcategory.R
import com.samuraicmdv.ui.util.ThemePreviews

@Composable
fun CategoryScreenContentHeader(
    name: String?,
    description: String?,
    imageUrl: String?,
    productsCount: Int?,
    productsQuantity: Int?,
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = MobiTheme.dimens.dimen_2)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .weight(1F)
                .padding(end = MobiTheme.dimens.dimen_2)
        ) {
            name?.let {
                Text(text = it, style = MobiTheme.typography.headlineLarge, modifier = Modifier.fillMaxWidth())
            }
            Spacer(modifier = Modifier.height(MobiTheme.dimens.dimen_1))
            description?.let {
                Text(
                    text = it,
                    style = MobiTheme.typography.bodyLarge,
                    lineHeight = 18.sp,
                    modifier = Modifier.fillMaxWidth()
                )
            }
            Spacer(modifier = Modifier.height(MobiTheme.dimens.dimen_1))
            productsCount?.let {
                Text(
                    text = "Products count: $it",
                    style = MobiTheme.typography.bodyMedium,
                    modifier = Modifier.fillMaxWidth()
                ) // TODO
            }
            productsQuantity?.let {
                Text(
                    text = "Products quantity: $it",
                    style = MobiTheme.typography.bodyMedium,
                    modifier = Modifier.fillMaxWidth()
                ) // TODO
            }
        }
        Image(
            painter = painterResource(id = R.drawable.logo_1),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth(0.3F)
                .aspectRatio(1F)
        )
    }
}

@ThemePreviews
@Composable
fun PreviewCategoryHeader(modifier: Modifier = Modifier) {
    MobiTheme {
        Surface {
            CategoryScreenContentHeader(
                name = "Category Name",
                description = "Lorem ipsum dolor sato sit amet. Lorem ipsum dolor sato sit amet. ",
                imageUrl = "https://www.example.com/image.jpg",
                productsCount = 10,
                productsQuantity = 100,
                modifier = Modifier.padding(horizontal = MobiTheme.dimens.dimen_2)
            )
        }
    }
}