package com.samuraicmdv.data.entity

import com.google.gson.annotations.SerializedName

data class GetProductDetailsResponseEntity(
    @SerializedName("meta") val meta: MetaEntity,
    @SerializedName("product") val productEntity: ProductEntity,
)
