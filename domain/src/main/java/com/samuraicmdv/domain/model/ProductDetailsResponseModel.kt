package com.samuraicmdv.domain.model

data class ProductDetailsResponseModel(
    val product: ProductModel? = null,
    val brand: BrandModel? = null,
    val category: ProductCategoryModel? = null,
    val subcategory: ProductSubcategoryModel? = null,
)
