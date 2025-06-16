package com.samuraicmdv.featureproductdetails.state

/**
 * Represents the mode of the item details screen.
 */
enum class ProductDetailsUiMode {
    // Display the details of a specific item.
    VIEW,

    // Edit an existing item.
    EDIT,

    // Create a new item.
    CREATE,

    // Create a new item.
    CREATE_SUCCESS
}