package com.samuraicmdv.data.entity

import com.google.gson.annotations.SerializedName

/**
 * Data class that models the API response for getting a Category.
 */
data class CategoryResponseEntity(
    @SerializedName("category") val category: CategoryEntity? = null,
    @SerializedName("brands") val brands: List<ProductBrandEntity>? = null,
    @SerializedName("products") val products: List<ProductEntity>? = null,
)

/**
 * Data class that models a Category in the API response.
 */
data class CategoryEntity(
    @SerializedName("id") val id: Int? = null,
    @SerializedName("name") val name: String? = null,
    @SerializedName("description") val description: String? = null,
    @SerializedName("logo_url") val logoUrl: String? = null,
    @SerializedName("image_url") val imageUrl: String? = null,
    @SerializedName("products_count") val productsCount: Int? = null,
    @SerializedName("products_quantity") val productsQuantity: Int? = null,
)

/**
 * Data class that models a product in the API response.
 */
data class ProductEntity(
    @SerializedName("id") val id: Int? = null,
    @SerializedName("name") val name: String? = null,
    @SerializedName("description") val description: String? = null,
    @SerializedName("model") val model: String? = null,
    @SerializedName("code") val code: String? = null,
    @SerializedName("sku") val sku: String? = null,
    @SerializedName("brand") val brand: ProductBrandEntity? = null,
    @SerializedName("category_id") val categoryId: Int? = null,
    @SerializedName("stock") val stock: Int? = null,
    @SerializedName("price") val productPrice: ProductPriceEntity? = null,
)

/**
 * Data class that models a product brand in the API response.
 */
data class ProductBrandEntity(
    @SerializedName("id") val id: Int? = null,
    @SerializedName("name") val name: String? = null,
    @SerializedName("logo_url") val logoUrl: String? = null,
)

/**
 * Data class that models a product price in the API response.
 */
data class ProductPriceEntity(
    @SerializedName("selling") val selling: String? = null,
    @SerializedName("cost") val cost: String? = null,
    @SerializedName("f_currency_id") val currencyId: String? = null,
)