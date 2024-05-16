package com.samuraicmdv.featureproductcategory.compose

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.samuraicmdv.featureproductcategory.R
import com.samuraicmdv.featureproductcategory.state.CategoryUiData
import com.samuraicmdv.featureproductcategory.state.ProductBrandUiData
import com.samuraicmdv.featureproductcategory.state.ProductUiData
import com.samuraicmdv.featureproductcategory.theme.AppTheme
import com.samuraicmdv.ui.util.ThemePreviews

@Composable
fun CategoryScreenContent(
    category: CategoryUiData?,
    brands: List<ProductBrandUiData>?,
    products: List<ProductUiData>?,
    modifier: Modifier = Modifier
) {
    category?.run {
        LazyColumn(modifier = modifier.fillMaxWidth()) {
            item {
                CategoryScreenContentHeader(
                    name = name,
                    description = description,
                    imageUrl = imageUrl,
                    productsCount = productsCount,
                    productsQuantity = productsQuantity
                )
            }
            brands?.let {
                item {
                    Spacer(modifier = Modifier.height(AppTheme.dimens.dimen_3))
                    CategoryScreenContentBrands(
                        brands = brands
                    )
                }
            }
            products?.let {
                item {
                    Spacer(modifier = Modifier.height(AppTheme.dimens.dimen_3))
                    Text(
                        text = stringResource(id = R.string.title_products),
                        style = AppTheme.typography.bodyLarge,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(AppTheme.dimens.dimen_1))
                }
                items(products, { it.id }) { product ->
                    ProductItem(product = product)
                    Spacer(modifier = Modifier.height(AppTheme.dimens.dimen_1))
                }
            }
        }
    }
}

@ThemePreviews
@Composable
fun PreviewCategoryContent(modifier: Modifier = Modifier) {
    AppTheme {
        Surface {
            CategoryScreenContent(
                category = CategoryUiData(
                    id = "1",
                    name = "Category Name",
                    description = "Category Description",
                    imageUrl = "https://www.example.com/image.jpg",
                    productsCount = 100,
                    productsQuantity = 1000
                ),
                brands = List(5) { index ->
                    ProductBrandUiData(
                        id = index.toString(),
                        name = "Brand $index",
                        logoUrl = "https://www.example.com/image.jpg"
                    )
                },
                products = List(5) { index ->
                    ProductUiData(
                        id = index.toString(),
                        name = "Product $index",
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
                    )
                },
                modifier = Modifier.padding(horizontal = AppTheme.dimens.dimen_2)
            )
        }
    }
}