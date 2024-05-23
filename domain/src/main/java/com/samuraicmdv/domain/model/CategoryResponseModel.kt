package com.samuraicmdv.domain.model

import com.samuraicmdv.common.utils.ProductCategory

/**
 * Data class that models the API response for getting a Category in the domain layer.
 */
data class CategoryResponseModel(
    val category: CategoryModel? = null,
    val brands: List<ProductBrandModel>? = null,
    val products: List<ProductModel>? = null,
)

data class ProductModel(
    val id: Int? = null,
    val name: String? = null,
    val shortDescription: String? = null,
    val longDescription: String? = null,
    val model: String? = null,
    val code: String? = null,
    val sku: String? = null,
    val thumbnailUrl: String? = null,
    val imageUrls: List<String>? = null,
    val categoryId: Int? = null,
    val stock: ProductStockModel? = null,
    val sellingPrice: String? = null,
    val costPrice: String? = null,
    val currencyId: String? = null,
    val brand: ProductBrandModel? = null,
)

data class CategoryModel(
    val id: Int?,
    val type: ProductCategory? = null,
    val name: String?,
    val description: String? = null,
    val logoUrl: String? = null,
    val imageUrl: String? = null,
    val productsCount: Int? = null,
    val productsQuantity: Int? = null,
)

data class ProductBrandModel(
    val id: Int? = null,
    val name: String? = null,
    val logoUrl: String? = null,
)

data class ProductStockModel(
    val quantity: Int? = null,
    val low: Int? = null,
    val min: Int? = null,
)
