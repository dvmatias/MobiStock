package com.samuraicmdv.featureproductdetails.data

/**
 * Data class that models the UI data for a product.
 *
 * @param id The unique identifier of the product. Used to fetch the product details.
 * @param name The name of the product.
 * @param shortDescription A brief description of the product.
 * @param longDescription A detailed description of the product.
 * @param model The model of the product.
 * @param code The code of the product.
 * @param sku The stock keeping unit (SKU) of the product.
 * @param thumbnailUrl The URL of the thumbnail image of the product.
 * @param imageUrls The URLs of the images of the product.
 * @param price The price object of the product.
 * @param brand The brand object of the product.
 */
data class ProductDetailsUiData(
    val id: Int,
    val name: String? = null,
    val shortDescription: String? = null,
    val longDescription: String? = null,
    val model: String? = null,
    val code: String? = null,
    val sku: String? = null,
    val thumbnailUrl: String? = null,
    val imageUrls: List<String>? = null,
    val price: ProductPriceUiData? = null,
    val brand: ProductBrandUiData? = null,
)