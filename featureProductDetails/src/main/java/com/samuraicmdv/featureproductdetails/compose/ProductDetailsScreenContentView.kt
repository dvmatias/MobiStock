package com.samuraicmdv.featureproductdetails.compose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.samuraicmdv.common.theme.MobiTheme
import com.samuraicmdv.featureproductdetails.data.ProductUiData
import com.samuraicmdv.ui.util.ThemePreviews

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
            Column {
                // Display product images
                ProductDetailsImageGallery(
                    imageUrls = imageUrls,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(MobiTheme.dimens.dimen_2))

                name?.let {
                    Text(
                        text = it,
                        style = MobiTheme.typography.titleMediumBold,
                        modifier = Modifier.padding(horizontal = MobiTheme.dimens.dimen_2)
                    )
                }

                Spacer(modifier = Modifier.height(MobiTheme.dimens.dimen_2))

                shortDescription?.let {
                    Text(text = it)
                }

                Spacer(modifier = Modifier.height(MobiTheme.dimens.dimen_2))
                
                longDescription?.let {
                    Text(text = it)
                }
            }
        } ?: kotlin.run {
            Box {
                Text(text = "Error: Product not found") // TODO handle gracefully
            }
        }
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
                ),
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}