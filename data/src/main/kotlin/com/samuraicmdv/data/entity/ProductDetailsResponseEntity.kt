package com.samuraicmdv.data.entity

import com.google.gson.annotations.SerializedName

data class ProductDetailsResponseEntity(
    @SerializedName("meta") val meta: MetaEntity? = null,
    @SerializedName("brand") val brand: BrandEntity? = null,
    @SerializedName("category") val category: ProductCategoryEntity? = null,
    @SerializedName("item") val product: ProductEntity? = null,
    @SerializedName("subcategory") val subcategory: ProductSubcategoryEntity? = null
)
