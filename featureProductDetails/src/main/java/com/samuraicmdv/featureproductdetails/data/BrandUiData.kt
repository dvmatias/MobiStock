package com.samuraicmdv.featureproductdetails.data

/**
 * Data class that models the UI data for a product brand.
 *
 * @param id The unique identifier of the brand.
 * @param name The name of the brand.
 * @param logoUrl The URL of the logo of the brand.
 */
data class BrandUiData(
    val id: Int,
    val name: String,
    val logoUrl: String,
)
