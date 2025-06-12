package com.samuraicmdv.data.entity

import com.google.gson.annotations.SerializedName
import com.samuraicmdv.data.mapper.CategoryEntityMapper
import com.samuraicmdv.domain.model.ProductSubcategoryModel

data class ProductSubcategoryEntity(
    @SerializedName("id") val id: Int? = null,
    @SerializedName("category_id") val categoryId: Int? = null,
    @SerializedName("description") val description: String? = null,
    @SerializedName("name") val name: String? = null,
) {
    fun toModel(): ProductSubcategoryModel {
        return ProductSubcategoryModel(
            id = id,
            name = name,
            description = description,
            type = CategoryEntityMapper.getProductSubcategoryType(name),
        )
    }
}
