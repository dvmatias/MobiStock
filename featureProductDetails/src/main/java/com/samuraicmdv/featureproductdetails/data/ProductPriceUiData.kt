package com.samuraicmdv.featureproductdetails.data

/**
 * Data class that models the UI data for the price of a product.
 *
 * @param sellingPrice The selling price of the product.
 * @param costPrice The cost price of the product.
 * @param currency The currency of the prices.
 */
data class ProductPriceUiData(
    val sellingPrice: Double? = null,
    val costPrice: Double? = null,
    val currency: String? = null,
    val preferredMargin: Int? = null,
)