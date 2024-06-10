package com.samuraicmdv.featureproductdetails.event

/**
 * Represents the events that can be triggered in the product details screen and that are handled by the presentation
 * layer.
 */
sealed class ProductDetailsPresentationEvent : ProductDetailsEvent {
    /**
     * Event triggered when the user wants to edit the product.
     */
    data object EditProduct : ProductDetailsPresentationEvent()

    /**
     * Event triggered when the user wants to cancel the product edition.
     */
    data object CancelProductEdition : ProductDetailsPresentationEvent()

    /**
     * Exit the screen.
     */
    data object ExitScreen : ProductDetailsPresentationEvent()

}