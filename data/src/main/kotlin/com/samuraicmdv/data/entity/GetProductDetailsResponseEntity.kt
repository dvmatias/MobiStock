package com.samuraicmdv.data.entity

import com.google.gson.annotations.SerializedName

data class GetProductDetailsResponseEntity(
    @SerializedName("meta") val meta: MetaEntity,
    @SerializedName("product") val product: ProductEntity,
    @SerializedName("category") val category: ProductCategoryEntity,
    @SerializedName("brand") val brand: BrandEntity,
    @SerializedName("stock") val stock: StockEntity,
    @SerializedName("prices") val price: PriceEntity,
    @SerializedName("image_urls") val imageUrls: List<String>,
)
