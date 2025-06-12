package com.samuraicmdv.data.entity

import com.google.gson.annotations.SerializedName
import com.samuraicmdv.data.mapper.CategoryEntityMapper
import com.samuraicmdv.domain.model.ProductCategoryModel

/**
 * Data class that models a specific Product Category in the API response.
 */
data class ProductCategoryEntity(
    @SerializedName("id") val id: Int? = null,
    @SerializedName("name") val name: String? = null,
    @SerializedName("description") val description: String? = null,
    @SerializedName("subcategories") val subcategories: List<ProductSubcategoryEntity>? = null,
) {
    fun toModel(): ProductCategoryModel {
        return ProductCategoryModel(
            id = id,
            name = name,
            description = description,
            type = CategoryEntityMapper.getProductCategoryType(name)
        )
    }
}
