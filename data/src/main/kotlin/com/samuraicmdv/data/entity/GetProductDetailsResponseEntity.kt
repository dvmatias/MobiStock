package com.samuraicmdv.data.entity

import com.google.gson.annotations.SerializedName

data class GetProductDetailsResponseEntity(
    @SerializedName("meta") val meta: MetaEntity? = null,
    @SerializedName("product") val product: ProductEntity? = null,
    @SerializedName("category") val category: ProductCategoryEntity? = null,
    @SerializedName("brand") val brand: BrandEntity? = null,
    @SerializedName("stock") val stock: StockEntity? = null,
    @SerializedName("prices") val price: PriceEntity? = null,
    @SerializedName("image_urls") val imageUrls: List<String>? = null,
)
