package com.samuraicmdv.featurebarcodescanner.state

/**
 * Data class that contains the UI data points for rendering a item details in the bottom sheet once a barcode is
 * scanned.
 *
 * @param id The unique identifier for the item.
 * @param brandLogoUrl The URL of the brand's logo image.
 * @param brandName The name of the brand associated with the item.
 * @param categorySubcategory The category and subcategory of the item, formatted as "Category - Subcategory".
 * @param code The item's unique code, typically a barcode or SKU.
 * @param description The description of the item.
 * @param price The price of the item.
 * @param stock The available stock quantity of the item, if applicable.
 * @param thumbnailUrl The URL of the item's thumbnail image.
 * @param title The title or name of the item.
 */
data class ItemDetailsUiData(
    val id: Int,
    val brandLogoUrl: String,
    val brandName: String,
    val categorySubcategory: String,
    val code: String,
    val description: String,
    val price: Double,
    val stock: Int? = null,
    val thumbnailUrl: String,
    val title: String,
)
